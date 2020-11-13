package com.comac.fileuploadanddownload.dao;

import com.comac.fileuploadanddownload.entity.FileInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author Mr.Horse
 * @Version v1.0.0
 * @Since 1.0
 * @Date 2020/11/12
 */
@Repository
public interface IFilePathDao {
    /**
     * 查询所有路径数据
     * @return
     */
    List<FileInfo> findAll();

    /**
     * 保存上传路径
     */
    void savePath(FileInfo filePath);
}
