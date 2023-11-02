package com.kfm.first.controller;

import com.kfm.first.utils.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @作者：玉蘅
 * @项目名称：first
 * @包名：com.kfm.first.controller
 * @文件名称：FileController
 * @代码功能：文件
 * @时间：2023/10/31/17:16
 */
@Controller
public class FileController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(MultipartFile[] file, RedirectAttributes attributes) {
        StringBuilder message = new StringBuilder();
        for (MultipartFile f : file) {
            System.out.println("content-type=" + f.getContentType());
            System.out.println("name=" + f.getName()); // name属性的值
            System.out.println("originalFilename=" + f.getOriginalFilename());
            String originalFilename = f.getOriginalFilename();
            InputStream in = null;
            try {
                in = f.getInputStream();
                File file1 = new File(Constant.UPLOAD_PATH, originalFilename);
                if (!file1.getParentFile().exists()) {
                    file1.getParentFile().mkdirs();
                }
                in.transferTo(new FileOutputStream(file1));
                message.append(originalFilename).append("上传成功<br>");
                // return "redirect:/listPage";
            } catch (IOException e) {
                e.printStackTrace();
                message.append(originalFilename).append("上传失败<br>");
            }
        }
        attributes.addFlashAttribute("msg", message.toString());
        return "redirect:/listPage";
    }
}

