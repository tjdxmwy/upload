package com.comac.fileuploadanddownload.entity;

/**
 * @Description
 * @Author Mr.Horse
 * @Version v1.0.0
 * @Since 1.0
 * @Date 2020/11/12
 */
public class FileInfo {
    private Integer id;
    private String fileName;
    private String fileRawName;  //实际文件名
    private String filenameDesc;
    private String filePath;

    public String getFilenameDesc() {
        return filenameDesc;
    }

    public void setFilenameDesc(String filenameDesc) {
        this.filenameDesc = filenameDesc;
    }

    public String getFileRawName() {
        return fileRawName;
    }

    public void setFileRawName(String fileRawName) {
        this.fileRawName = fileRawName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", filenameDesc='" + filenameDesc + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
