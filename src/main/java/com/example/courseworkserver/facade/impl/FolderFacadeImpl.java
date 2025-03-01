package com.example.courseworkserver.facade.impl;

import com.example.courseworkserver.dto.request.FolderRequest;
import com.example.courseworkserver.dto.response.FolderResponse;
import com.example.courseworkserver.entity.Folder;
import com.example.courseworkserver.facade.FolderFacade;
import com.example.courseworkserver.service.FolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FolderFacadeImpl implements FolderFacade {

    private final FolderService folderService;

    @Override
    public FolderResponse create(FolderRequest entity) {
        Folder folder = new Folder();
        BeanUtils.copyProperties(entity, folder);
        Folder response = folderService.create(folder);
        return new FolderResponse(response);
    }

    @Override
    public void update(FolderRequest entity, Long id) {
        Folder folder = folderService.findById(id);
        BeanUtils.copyProperties(entity, folder);
        folderService.update(folder);
    }

    @Override
    public void delete(Long id) {
        folderService.delete(id);
    }

    @Override
    public FolderResponse findById(Long id) {
        return new FolderResponse(folderService.findById(id));
    }

    @Override
    public List<FolderResponse> findAll() {
        return folderService.findAll().stream().map(FolderResponse::new).toList();
    }
}
