package com.chenhf.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chenhf.pojo.User;
import com.chenhf.vo.LoginVo;
import com.chenhf.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
     * @param request
     * @param response
     * @return RespBean
     * @author Chenhf
     * @date 2022/6/30 19:21
     */
    RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);
}
