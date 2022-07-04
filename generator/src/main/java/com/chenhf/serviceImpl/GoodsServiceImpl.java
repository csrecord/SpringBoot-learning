package com.chenhf.serviceImpl;

import com.chenhf.pojo.Goods;
import com.chenhf.mapper.GoodsMapper;
import com.chenhf.service.IGoodsService;
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
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

}
