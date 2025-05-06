package com.example.courseworkserver.facade;

import com.example.courseworkserver.dto.response.MethodEntityResponse;

import java.util.List;

public interface MethodEntityFacade {
    List<MethodEntityResponse> findByClassEntityName(String className);
}
