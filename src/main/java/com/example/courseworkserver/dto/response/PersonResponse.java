package com.example.courseworkserver.dto.response;

import com.example.courseworkserver.entity.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PersonResponse extends UniobjectResponse {
    private Date dateOfBirth;

    private String sex;

    private String nationality;

    public PersonResponse(Person person) {
        BeanUtils.copyProperties(person, this);
    }
}
