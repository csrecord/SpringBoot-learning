package com.chenhf.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chenhf.pojo.User;
import com.chenhf.vo.LoginVo;
import com.chenhf.vo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenhf
 */
public interface IUserService extends IService<User> {

    /**
     * @description 登录实现接口
     * @param loginVo
     * @return RespBean
     * @author Chenhf
     * @date 2022/6/30 19:21
     */
    RespBean doLogin(LoginVo loginVo);
}
