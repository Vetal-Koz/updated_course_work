package com.example.courseworkserver.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UniobjectRequest extends ApiRequest {

    private String name;

    private Long major;
}
