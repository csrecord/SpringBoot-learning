package com.chenhf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenhf.pojo.Goods;
import com.chenhf.vo.GoodsVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chenhf
 */
@Repository
public interface GoodsMapper extends BaseMapper<Goods> {

    List<GoodsVo> findGoodsVo();
}
