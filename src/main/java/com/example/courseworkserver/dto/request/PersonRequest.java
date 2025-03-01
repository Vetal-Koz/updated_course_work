package com.example.courseworkserver.dto.request;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PersonRequest extends UniobjectRequest {
    private Date dateOfBirth;
    private String sex;
    private String nationality;
}
