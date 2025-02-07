package com.example.courseworkserver.service.impl;

import com.example.courseworkserver.entity.ClassEntity;
import com.example.courseworkserver.entity.TextDocument;
import com.example.courseworkserver.exception.EntityNotFoundException;
import com.example.courseworkserver.repository.ClassEntityRepository;
import com.example.courseworkserver.repository.TextDocumentRepository;
import com.example.courseworkserver.service.TextDocumentService;
import com.example.courseworkserver.util.ExceptionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TextDocumentImpl implements TextDocumentService {

    private final TextDocumentRepository textDocumentRepository;
    private final ClassEntityRepository classEntityRepository;

    @Override
    public TextDocument create(TextDocument entity) {
        ClassEntity classEntity = classEntityRepository.findClassByName("TextDocument")
                .orElseThrow(() -> new EntityNotFoundException(ExceptionUtil.ENTITY_NOT_FOUND.getMessage()));
        entity.setClassEntity(classEntity);
        return textDocumentRepository.save(entity);
    }

    @Override
    public void update(TextDocument entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public TextDocument findById(Long id) {
        return null;
    }

    @Override
    public List<TextDocument> findAll() {
        return null;
    }
}
