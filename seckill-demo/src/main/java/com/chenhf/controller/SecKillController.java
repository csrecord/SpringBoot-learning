package com.chenhf.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenhf.pojo.Order;
import com.chenhf.pojo.SeckillOrder;
import com.chenhf.pojo.User;
import com.chenhf.service.IGoodsService;
import com.chenhf.service.IOrderService;
import com.chenhf.service.ISeckillOrderService;
import com.chenhf.vo.GoodsVo;
import com.chenhf.vo.RespBean;
import com.chenhf.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: TODO
 * @className: SecKillController
 * @author: Chenhf
 * @date: 2022/7/6 14:49
 * @version: 1.0
 */
@Controller
@RequestMapping("/seckill")
public class SecKillController {
    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private ISeckillOrderService seckillOrderService;
    @Autowired
    private IOrderService orderService;

    ////跳转秒杀页面, 原方法
    //@RequestMapping("/doSeckill2")
    //public String doSecKill2(Model model, User user, Long goodsId){
    //    if (user==null){
    //        return "login";
    //    }
    //    model.addAttribute("user",user);
    //    GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);
    //    if (goods.getStockCount()<1){
    //        //判断库存
    //        model.addAttribute("errmsg", RespBeanEnum.EMPTY_STOCK.getMessage());
    //        return "secKillFail";
    //    }
    //    //判断是否重复抢购
    //    SeckillOrder seckillOrder = seckillOrderService.getOne(new QueryWrapper<SeckillOrder>()
    //            .eq("user_id", user.getId())
    //            .eq("goods_id", goodsId));
    //    if (seckillOrder!=null){
    //        model.addAttribute("errmsg",RespBeanEnum.REPEATE_ERROR.getMessage());
    //        return "secKillFail";
    //    }
    //    Order order = orderService.seckill(user, goods);
    //    model.addAttribute("order",order);
    //    model.addAttribute("goods",goods);
    //    return "orderDetail";
    //}

    //跳转秒杀页面
    @RequestMapping(value = "/doSeckill", method = RequestMethod.POST)
    @ResponseBody
    public RespBean doSecKill(Model model, User user, Long goodsId){
        if (user==null){
            return RespBean.error(RespBeanEnum.SESSION_ERROR);
        }
        GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);
        if (goods.getStockCount()<1){
            //判断库存
            model.addAttribute("errmsg", RespBeanEnum.EMPTY_STOCK.getMessage());
            return RespBean.error(RespBeanEnum.EMPTY_STOCK);
        }
        //判断是否重复抢购
        SeckillOrder seckillOrder = seckillOrderService.getOne(new QueryWrapper<SeckillOrder>()
                .eq("user_id", user.getId())
                .eq("goods_id", goodsId));

        if (seckillOrder!=null){
            model.addAttribute("errmsg",RespBeanEnum.REPEATE_ERROR.getMessage());
            return RespBean.error(RespBeanEnum.REPEATE_ERROR);
        }

        Order order = orderService.seckill(user, goods);
        return RespBean.success(order);
    }
}
