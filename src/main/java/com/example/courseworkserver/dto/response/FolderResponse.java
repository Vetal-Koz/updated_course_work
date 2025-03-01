package com.example.courseworkserver.dto.response;


import com.example.courseworkserver.entity.Folder;
import org.springframework.beans.BeanUtils;

public class FolderResponse extends UniobjectResponse {

    public FolderResponse(Folder folder) {
        BeanUtils.copyProperties(folder, this);
        setClassEntityName(folder.getClassEntity().getName());
    }
}
