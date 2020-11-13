package com.comac.fileuploadanddownload.controller;

import com.comac.fileuploadanddownload.entity.FileInfo;
import com.comac.fileuploadanddownload.service.IFilePathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @Description
 * @Author Mr.Horse
 * @Version v1.0.0
 * @Since 1.0
 * @Date 2020/11/12
 */
@Controller
@RequestMapping("/comacc")
public class FileDownloadController {

    @Autowired
    private IFilePathService service;

    @RequestMapping("/file")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        List<FileInfo> files = service.findPath();
        mv.setViewName("filedownload");
        mv.addObject("files", files);
        return mv;
    }

    @RequestMapping("/download")
    @ResponseBody
    public String download(HttpServletResponse response, String filename, String filepath) throws UnsupportedEncodingException {
        File file = new File(filepath);

        if(file.exists()) {
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            // response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;fileName=" +   java.net.URLEncoder.encode(filename,"UTF-8"));

            byte[] buff = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;
            OutputStream os = null;  //文件输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buff);
                while (i != -1) {
                    os.write(buff,0,buff.length);
                    os.flush();
                    i = bis.read(buff);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    bis.close();
                    fis.close();
                    os.close();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return "done success";
    }
}