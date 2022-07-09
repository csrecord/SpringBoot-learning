package com.chenhf.rabbitmq;

import com.chenhf.pojo.SeckillMessage;
import com.chenhf.pojo.SeckillOrder;
import com.chenhf.pojo.User;
import com.chenhf.service.IGoodsService;
import com.chenhf.service.IOrderService;
import com.chenhf.utils.JsonUtil;
import com.chenhf.vo.GoodsVo;
import com.chenhf.vo.RespBean;
import com.chenhf.vo.RespBeanEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import sun.applet.resources.MsgAppletViewer;

/**
 * @description: TODO
 * @className: MQReceiver
 * @author: Chenhf
 * @date: 2022/7/9 16:54
 * @version: 1.0
 */
@Service
@Slf4j
public class MQReceiver {

    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private IOrderService orderService;
    //监听消息队列
    @RabbitListener(queues = "seckillQueue")
    public void receive05(String message){
        log.info("接收的消息"+message);
        //字符串转换为对象
        SeckillMessage seckillMessage = JsonUtil.jsonStr2Object(message, SeckillMessage.class);
        Long goodsId = seckillMessage.getGoodsId();
        User user = seckillMessage.getUser();
        //根据ID判断库存
        GoodsVo goodsVo = goodsService.findGoodsVoByGoodsId(goodsId);
        if (goodsVo.getStockCount()<1){
            //正常返回
            return;
        }
        //这里获取秒杀订单用户信息,如果用户重复下单返回
        SeckillOrder seckillOrder = (SeckillOrder) redisTemplate.opsForValue().get("order:" + user.getId() + ":" + goodsId);
        if (seckillOrder!=null){
            return;
        }
        //下单操作
        orderService.seckill(user, goodsVo);
    }
}
