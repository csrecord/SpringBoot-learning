package com.chenhf.controller;

import com.chenhf.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @description: 登录成功跳转商品页面
 * @className: GoodsController
 * @author: Chenhf
 * @date: 2022/7/1 20:07
 * @version: 1.0
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    /**
     * @description 跳转商品页面
     * @param session
     * @param model
     * @param ticket
     * @return String
     * @author Chenhf
     * @date 2022/7/1 20:15
     */
    @RequestMapping("/toList")
    public String toList(HttpSession session, Model model, @CookieValue("userTicket") String ticket){
        if (StringUtils.isEmpty(ticket)){
            return "login";
        }
        //拿到用户
        User user = (User) session.getAttribute(ticket);
        if (user == null){
            return "login";
        }
        //获取user, 返回给前端
        model.addAttribute("user",user);
        return "goodsList";
    }
}
