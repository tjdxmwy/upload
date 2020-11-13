package com.comac.fileuploadanddownload.controller;

import com.comac.fileuploadanddownload.entity.FileInfo;
import com.comac.fileuploadanddownload.service.IFilePathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author Mr.Horse
 * @Version v1.0.0
 * @Since 1.0
 * @Date 2020/11/12
 */
@Controller
@RequestMapping("/comac")
public class FileUploadController {

    @Autowired
    private IFilePathService service;

    @RequestMapping("/file")
    public String index(Model model) {
        return "fileupload";
    }

    @RequestMapping("/fileupload")
    public String fileUpload(HttpServletRequest request) {

        MultipartHttpServletRequest params = (MultipartHttpServletRequest) request;
        List<MultipartFile> files = params.getFiles("files");

        //获取两个参数
        String fileName = params.getParameter("fileName"); //文件名
        String filenameDesc = params.getParameter("filenameDesc"); //文件描述

        if(files.isEmpty()) {
            return "redirect:/comacc/file";
        }

//        String path = "E:/comacfile";
        String path = "/opt/module/comacfile";
        for (MultipartFile file : files) {
            String rawFilename = file.getOriginalFilename();
            int size = (int)file.getSize();
//            System.out.println(rawFilename + "-->" + size);

            if(!rawFilename.equals("") && rawFilename != null) {
                FileInfo filePath = new FileInfo();
                filePath.setFileName(fileName);
                filePath.setFilenameDesc(filenameDesc);
                filePath.setFilePath(path + "/" + rawFilename);
                filePath.setFileRawName(rawFilename);
                service.saveFile(filePath);  //保存文件信息到数据库
            }

            File dest = new File(path + "/" + rawFilename);
            if(!dest.getParentFile().exists()) {
                dest.getParentFile().mkdir();
            }
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
                return "redirect:/comacc/file";
            }
        }
        return "redirect:/comacc/file";
    }
}
