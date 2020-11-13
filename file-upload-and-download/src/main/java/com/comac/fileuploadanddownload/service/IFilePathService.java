package com.comac.fileuploadanddownload.service;

import com.comac.fileuploadanddownload.entity.FileInfo;

import java.util.List;

/**
 * @Description
 * @Author Mr.Horse
 * @Version v1.0.0
 * @Since 1.0
 * @Date 2020/11/12
 */
public interface IFilePathService {
    List<FileInfo> findPath();

    void saveFile(FileInfo filePath);
}
