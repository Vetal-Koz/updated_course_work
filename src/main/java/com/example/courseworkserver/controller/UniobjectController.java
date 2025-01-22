package com.example.courseworkserver.controller;


import com.example.courseworkserver.dto.request.ApiRequest;
import com.example.courseworkserver.dto.request.FacultyRequest;
import com.example.courseworkserver.dto.request.UniobjectRequest;
import com.example.courseworkserver.dto.response.ResponseContainer;
import com.example.courseworkserver.dto.response.UniobjectResponse;
import com.example.courseworkserver.facade.CrudFacade;
import com.example.courseworkserver.facade.UniobjectFacade;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/uniobjects")
@RestController
@RequiredArgsConstructor
public class UniobjectController {
    private final UniobjectFacade uniobjectFacade;
    private final ApplicationContext context;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping()
    public ResponseEntity<ResponseContainer<List<UniobjectResponse>>> getAllUniobjects() {
        return ResponseEntity.ok().body(new ResponseContainer<>(uniobjectFacade.findAll()));
    }

    @GetMapping("/independent")
    public ResponseEntity<ResponseContainer<List<UniobjectResponse>>> getAllUniobjectsWhereMajorIsNull() {
        return ResponseEntity.ok().body(new ResponseContainer<>(uniobjectFacade.findAllWithMajorNull()));
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
    public ResponseEntity<Void> create(@RequestBody UniobjectRequest uniobjectRequest) {
        uniobjectFacade.create(uniobjectRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody Map<String, Object> uniobjectRequest) {
        try {
            uniobjectRequest.remove("id");
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
}
