package com.example.courseworkserver.facade;

import com.example.courseworkserver.dto.request.ClassRequest;
import com.example.courseworkserver.dto.response.ClassResponse;

public interface ClassFacade {

    ClassResponse findByClassName(ClassRequest request);
}
