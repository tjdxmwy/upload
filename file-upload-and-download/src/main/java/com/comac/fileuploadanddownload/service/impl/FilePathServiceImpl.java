package com.comac.fileuploadanddownload.service.impl;

import com.comac.fileuploadanddownload.dao.IFilePathDao;
import com.comac.fileuploadanddownload.entity.FileInfo;
import com.comac.fileuploadanddownload.service.IFilePathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author Mr.Horse
 * @Version v1.0.0
 * @Since 1.0
 * @Date 2020/11/12
 */
@Service
public class FilePathServiceImpl implements IFilePathService {

    @Autowired
    private IFilePathDao filePathDao;

    @Override
    public List<FileInfo> findPath() {
        return filePathDao.findAll();
    }

    @Override
    public void saveFile(FileInfo filePath) {
        filePathDao.savePath(filePath);
    }
}
