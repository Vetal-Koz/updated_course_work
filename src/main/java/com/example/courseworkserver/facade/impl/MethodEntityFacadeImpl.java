package com.example.courseworkserver.facade.impl;

import com.example.courseworkserver.dto.response.MethodEntityResponse;
import com.example.courseworkserver.facade.MethodEntityFacade;
import com.example.courseworkserver.service.MethodEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MethodEntityFacadeImpl implements MethodEntityFacade {
    private final MethodEntityService methodEntityService;

    @Override
    public List<MethodEntityResponse> findByClassEntityName(String className) {
        return methodEntityService.findByClassEntityName(className).stream().map(MethodEntityResponse::new).toList();
    }
}
