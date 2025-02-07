package com.example.courseworkserver.service.impl;

import com.example.courseworkserver.entity.ClassEntity;
import com.example.courseworkserver.entity.Folder;
import com.example.courseworkserver.exception.EntityNotFoundException;
import com.example.courseworkserver.repository.ClassEntityRepository;
import com.example.courseworkserver.repository.FolderRepository;
import com.example.courseworkserver.service.FolderService;
import com.example.courseworkserver.util.ExceptionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FolderServiceImpl implements FolderService {

    private final FolderRepository folderRepository;
    private final ClassEntityRepository classEntityRepository;

    @Override
    public Folder create(Folder entity) {
        ClassEntity classEntity = classEntityRepository.findClassByName("Folder")
                .orElseThrow(() -> new EntityNotFoundException(ExceptionUtil.ENTITY_NOT_FOUND.getMessage()));
        entity.setClassEntity(classEntity);
        return folderRepository.save(entity);
    }

    @Override
    public void update(Folder entity) {
        folderRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        folderRepository.deleteById(id);
    }

    @Override
    public Folder findById(Long id) {
        return folderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionUtil.ENTITY_NOT_FOUND.getMessage()));
    }

    @Override
    public List<Folder> findAll() {
        return folderRepository.findAll();
    }
}
