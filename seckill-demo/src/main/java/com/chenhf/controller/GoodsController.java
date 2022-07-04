package com.chenhf.controller;

import com.chenhf.pojo.User;
import com.chenhf.service.IGoodsService;
import com.chenhf.service.IUserService;
import com.chenhf.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@SuppressWarnings("all")
public class GoodsController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IGoodsService goodsService;

   /**
    * @description TODO
    * @param model
    * @param user
    * @return String
    * @author Chenhf
    * @date 2022/7/4 16:37
    */
    @RequestMapping("/toList")
    public String toList(Model model, User user){
        //if (StringUtils.isEmpty(ticket)){
        //    return "login";
        //}
        ////拿到用户
        ////User user = (User) session.getAttribute(ticket);
        //User user = userService.getUserByCookie(ticket, request, response);
        //if (user == null){
        //    return "login";
        //}
        //获取user, 返回给前端
        model.addAttribute("user",user);
        model.addAttribute("goodsList", goodsService.findGoodsVo());
        return "goodsList";
    }
}
