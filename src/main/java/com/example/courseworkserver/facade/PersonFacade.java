package com.example.courseworkserver.facade;

import com.example.courseworkserver.dto.request.PersonRequest;
import com.example.courseworkserver.dto.response.PersonResponse;
import com.example.courseworkserver.facade.CrudFacade;

public interface PersonFacade extends CrudFacade<PersonRequest, PersonResponse> {
}
