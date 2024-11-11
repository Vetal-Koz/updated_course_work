package com.example.courseworkserver.controller;


import com.example.courseworkserver.dto.request.UniobjectRequest;
import com.example.courseworkserver.dto.response.ResponseContainer;
import com.example.courseworkserver.dto.response.UniobjectResponse;
import com.example.courseworkserver.facade.UniobjectFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/uniobjects")
@RestController
@RequiredArgsConstructor
public class UniobjectController {
    private final UniobjectFacade uniobjectFacade;

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
    public ResponseEntity<ResponseContainer<UniobjectResponse>> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(new ResponseContainer<>(uniobjectFacade.findById(id)));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody UniobjectRequest uniobjectRequest) {
        uniobjectFacade.create(uniobjectRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody UniobjectRequest uniobjectRequest) {
        uniobjectFacade.update(uniobjectRequest, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        uniobjectFacade.delete(id);
        return ResponseEntity.ok().build();
    }
}
