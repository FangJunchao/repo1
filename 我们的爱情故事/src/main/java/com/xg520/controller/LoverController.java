package com.xg520.controller;


import com.xg520.domain.ResultInfo;
import com.xg520.domain.Lover;
import com.xg520.service.LoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/lover")
public class LoverController {

    @Autowired
    private LoverService loverService;

    @RequestMapping("/login")

    public @ResponseBody ResultInfo login(String username, String password, HttpServletRequest request) {
        Lover lover = new Lover();
        lover.setPassword(password);
        lover.setUsername(username);
        Lover loginLover;
        loginLover = loverService.login(lover);
        ResultInfo msg = new ResultInfo();
        if(3 == loginLover.getId())   {
            msg.setFlag(false);
            msg.setMsg("账号不存在");
            return msg;
        }else {
            if (4 == loginLover.getId())  {
                msg.setFlag(false);
                msg.setMsg("密码错误");
                return msg;
            }else {
                loginLover.setPassword("");
                request.getSession().setAttribute("lover",loginLover);
                msg.setFlag(true);
                msg.setMsg("登陆成功");
                return msg;
            }
        }
    }
    @RequestMapping("/loveYou")
    public void loveYou(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/OurLoveStory.html").forward(request,response);
    }

    @RequestMapping("/pc")
    public void loveYouPc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/index_pc.html").forward(request,response);
    }

    @RequestMapping("/mo")
    public void loveYouMo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/index_mo.html").forward(request,response);
    }
    @RequestMapping("/findLoginLover")
    public @ResponseBody Lover findLoginLover(HttpServletRequest request) {
        return (Lover) request.getSession().getAttribute("lover");
    }
}
