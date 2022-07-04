package com.chenhf.serviceImpl;

import com.chenhf.pojo.Order;
import com.chenhf.mapper.OrderMapper;
import com.chenhf.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenhf
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
