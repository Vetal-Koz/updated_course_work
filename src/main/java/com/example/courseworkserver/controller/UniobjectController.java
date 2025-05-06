package com.example.courseworkserver.controller;


import com.example.courseworkserver.dto.request.ApiRequest;
import com.example.courseworkserver.dto.request.ClassRequest;
import com.example.courseworkserver.dto.response.ClassResponse;
import com.example.courseworkserver.dto.response.MethodEntityResponse;
import com.example.courseworkserver.dto.response.ResponseContainer;
import com.example.courseworkserver.dto.response.UniobjectResponse;
import com.example.courseworkserver.entity.MethodEntity;
import com.example.courseworkserver.facade.ClassFacade;
import com.example.courseworkserver.facade.CrudFacade;
import com.example.courseworkserver.facade.MethodEntityFacade;
import com.example.courseworkserver.facade.UniobjectFacade;
import com.example.courseworkserver.service.MethodEntityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/uniobjects")
@RestController
@RequiredArgsConstructor
public class UniobjectController {
    private final UniobjectFacade uniobjectFacade;
    private final ApplicationContext context;
    private final ClassFacade classFacade;
    private final MethodEntityFacade methodEntityFacade;
    private final MethodEntityService methodEntityService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping()
    public ResponseEntity<ResponseContainer<List<UniobjectResponse>>> getAllUniobjects() {
        return ResponseEntity.ok().body(new ResponseContainer<>(uniobjectFacade.findAll()));
    }

    @GetMapping("/independent")
    public ResponseEntity<ResponseContainer<List<UniobjectResponse>>> getAllUniobjectsWhereMajorIsNull() {
        return ResponseEntity.ok().body(new ResponseContainer<>(uniobjectFacade.findAllWithMajorNull()));
    }

    @GetMapping("/root/classes")
    public ResponseEntity<ResponseContainer<List<String>>> getAllClasses() {
        return ResponseEntity.ok().body(new ResponseContainer<>(uniobjectFacade.findAllClassesName()));
    }

    @GetMapping("/{id}/related")
    public ResponseEntity<ResponseContainer<List<UniobjectResponse>>> getAllWhereMajorIs(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(new ResponseContainer<>(uniobjectFacade.findAllByMajorIs(id)));
    }

    @GetMapping("/{id}/classes")
    public ResponseEntity<ResponseContainer<List<String>>> getAllRelatedClasses(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(new ResponseContainer<>(uniobjectFacade.findAllRelatedClassesNameById(id)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseContainer<?>> getById(@PathVariable("id") Long id) throws ClassNotFoundException {
        UniobjectResponse uniobjectResponse = uniobjectFacade.findById(id);
        String classEntityName = uniobjectResponse.getClassEntityName();
        String fullNameOfClassFacade = "com.example.courseworkserver.facade." + classEntityName + "Facade";
        Class<?> facadeClass = Class.forName(fullNameOfClassFacade);
        CrudFacade entityFacade = (CrudFacade) context.getBean(facadeClass);
        return ResponseEntity.ok().body(new ResponseContainer<>(entityFacade.findById(id)));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Map<String, Object> uniobjectRequest) {
        try {
            uniobjectRequest.remove("chef");
            String entityClassName = String.valueOf(uniobjectRequest.remove("classEntityName"));
            String fullClassEntityName =  "com.example.courseworkserver.dto.request."
                    + entityClassName + "Request";
            Class<?> entityClass = Class.forName(fullClassEntityName);
            var convertValue = objectMapper.convertValue(uniobjectRequest, entityClass);
            String fullClassEntityFacadeName = "com.example.courseworkserver.facade." + entityClassName + "Facade";
            Class<?> facadeClass = Class.forName(fullClassEntityFacadeName);
            CrudFacade entityFacade = (CrudFacade) context.getBean(facadeClass);
            var response = entityFacade.create((ApiRequest) convertValue);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseContainer<>(response));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody Map<String, Object> uniobjectRequest) {
        try {
            uniobjectRequest.remove("id");
            uniobjectRequest.remove("chef");
            String entityClassName = String.valueOf(uniobjectRequest.remove("classEntityName"));
            String fullClassEntityName =  "com.example.courseworkserver.dto.request."
                    + entityClassName + "Request";
            Class<?> entityClass = Class.forName(fullClassEntityName);
            var convertValue = objectMapper.convertValue(uniobjectRequest, entityClass);
            String fullClassEntityFacadeName = "com.example.courseworkserver.facade." + entityClassName + "Facade";
            Class<?> facadeClass = Class.forName(fullClassEntityFacadeName);
            CrudFacade entityFacade = (CrudFacade) context.getBean(facadeClass);

            entityFacade.update((ApiRequest) convertValue, id);

            return ResponseEntity.ok().build();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        uniobjectFacade.delete(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/attach-to/{parentId}")
    public ResponseEntity<Void> updateMajor(@PathVariable("id") Long id, @PathVariable("parentId") Long parentId) {
        uniobjectFacade.updateMajor(id, parentId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/classes/{name}")
    public ResponseEntity<ClassResponse> getClassByName(@PathVariable("name") String name) {
        ClassRequest request = new ClassRequest();
        request.setClassName(name);
        return ResponseEntity.ok(classFacade.findByClassName(request));
    }

    @GetMapping("{className}/methods")
    public ResponseEntity<List<MethodEntityResponse>> getMethodsByClassName(@PathVariable("className") String className) {
        return ResponseEntity.ok(methodEntityFacade.findByClassEntityName(className));
    }

    @PostMapping("methods/invoke/{methodId}")
    public ResponseEntity<?> invokeMethodById(@PathVariable("methodId") Long methodId,
                                              @RequestBody Map<String, Object> methodRequest)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        MethodEntity method = methodEntityService.findById(methodId);
        String fullServiceName =  "com.example.courseworkserver.service."
                + method.getClassEntity().getName() + "Service";
        Class<?> serviceClass = Class.forName(fullServiceName);
        Object service = context.getBean(serviceClass);

        Method[] methods = serviceClass.getDeclaredMethods();
        Method matchingMethod = null;

        for (Method m : methods) {
            if (m.getName().equals(method.getMethodName())) {
                // Check if all required parameters are present in methodRequest
                boolean allMatch = Arrays.stream(m.getParameters())
                        .allMatch(param -> methodRequest.containsKey(param.getName()));
                if (allMatch) {
                    matchingMethod = m;
                    break;
                }
            }
        }

        if (matchingMethod == null) {
            throw new NoSuchMethodException("No matching method found");
        }

        Parameter[] parameters = matchingMethod.getParameters();
        Object[] args = new Object[parameters.length];

        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            String paramName = parameter.getName();
            Class<?> paramType = parameter.getType();

            Object rawValue = methodRequest.get(paramName);
            Object convertedValue = convertValue(rawValue, paramType);
            args[i] = convertedValue;
        }

        // Step 5: Invoke method
        matchingMethod.setAccessible(true);
        matchingMethod.invoke(service, args);

        return ResponseEntity.noContent().build();
    }


    private Object convertValue(Object value, Class<?> targetType) {
        if (value == null) return null;

        if (targetType.isInstance(value)) {
            return value;
        }

        if (targetType == Integer.class || targetType == int.class) {
            return Integer.parseInt(value.toString());
        } else if (targetType == Long.class || targetType == long.class) {
            return Long.parseLong(value.toString());
        } else if (targetType == Double.class || targetType == double.class) {
            return Double.parseDouble(value.toString());
        } else if (targetType == Boolean.class || targetType == boolean.class) {
            return Boolean.parseBoolean(value.toString());
        } else if (targetType == String.class) {
            return value.toString();
        } else {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.convertValue(value, targetType);
        }
    }
}
