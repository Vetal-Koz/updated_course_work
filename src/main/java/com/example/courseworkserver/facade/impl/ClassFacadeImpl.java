package com.example.courseworkserver.facade.impl;


import com.example.courseworkserver.dto.request.ClassRequest;
import com.example.courseworkserver.dto.response.ClassResponse;
import com.example.courseworkserver.facade.ClassFacade;
import com.example.courseworkserver.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassFacadeImpl implements ClassFacade {
    private final ClassService classService;

    @Override
    public ClassResponse findByClassName(ClassRequest request) {
        return new ClassResponse(classService.findByClassName(request.getClassName()));
    }
}
