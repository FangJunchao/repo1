package com.xg520.controller;


import com.xg520.domain.LoveProcess;
import com.xg520.domain.Lover;
import com.xg520.domain.ResultInfo;
import com.xg520.service.LoveProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/process")
@SessionAttributes("lover")
public class LoveProcessController {
    @Autowired
    private LoveProcessService loveProcessService;

    @RequestMapping("/publish")
    public @ResponseBody ResultInfo publish(LoveProcess loveProcess, HttpSession session, @RequestParam(value = "upload",required = false)MultipartFile upload, HttpServletRequest request) {
        Lover lover = (Lover) session.getAttribute("lover");
        loveProcess.setLoverId(lover.getId());
        loveProcess.setTime(new Date());
        ResultInfo resultInfo = new ResultInfo();
        String path = request.getSession().getServletContext().getRealPath("/images");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
        filename=uuid+"_"+filename;
        try {
            upload.transferTo(new File(file,filename));
            loveProcess.setImage("images"+"/"+filename);
            loveProcessService.publish(loveProcess);
            resultInfo.setFlag(true);
            resultInfo.setMsg("提交成功");
            return resultInfo;
        } catch (IOException e) {
            resultInfo.setFlag(false);
            resultInfo.setMsg("提交失败");
            return resultInfo;
        }
    }

    @RequestMapping("/findAll")
    public @ResponseBody
    List<LoveProcess> findAll()    {
        return loveProcessService.findAll();
    }

}
