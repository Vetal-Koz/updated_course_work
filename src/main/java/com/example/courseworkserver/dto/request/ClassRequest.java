package com.example.courseworkserver.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassRequest extends ApiRequest {
    private String className;
}
