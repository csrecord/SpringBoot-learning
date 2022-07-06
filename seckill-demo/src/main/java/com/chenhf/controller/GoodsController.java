package com.chenhf.controller;

import com.chenhf.pojo.User;
import com.chenhf.service.IGoodsService;
import com.chenhf.service.IUserService;
import com.chenhf.service.serviceImpl.UserServiceImpl;
import com.chenhf.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

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
        model.addAttribute("user",user);
        model.addAttribute("goodsList", goodsService.findGoodsVo());
        return "goodsList";
    }

    /**
     *
     * @param GoodsId
     * @return
     */
    @RequestMapping("/toDetail/{goodsId}")
    public String toDetail(Model model, User user, @PathVariable Long goodsId){
        model.addAttribute("user",user);
        GoodsVo goodsVo = goodsService.findGoodsVoByGoodsId(goodsId);
        //定义秒杀状态
        Date startDate = goodsVo.getStartDate();
        Date endDate = goodsVo.getEndDate();
        Date nowDate = new Date();
        int seckillStatus = 0;
        //秒杀倒计时
        int remainSeconds = 0;
        if (nowDate.before(startDate)){
            remainSeconds = ((int) ((startDate.getTime() - nowDate.getTime()) / 1000));
        } else if (nowDate.after(endDate)){
            seckillStatus = 2;
            remainSeconds = -1;
        } else {
            seckillStatus = 1;
            remainSeconds = 0;

        }
        model.addAttribute("remainSeconds",remainSeconds);
        model.addAttribute("seckillStatus",seckillStatus);
        model.addAttribute("goods",goodsVo);
        return "goodsDetail";
    }
}
