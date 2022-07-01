package com.chenhf.service.serviceImpl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenhf.exception.GlobalException;
import com.chenhf.mapper.UserMapper;
import com.chenhf.pojo.User;
import com.chenhf.service.IUserService;
import com.chenhf.utils.CookieUtil;
import com.chenhf.utils.MD5Util;
import com.chenhf.utils.UUIDUtil;
import com.chenhf.vo.LoginVo;
import com.chenhf.vo.RespBean;
import com.chenhf.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务实现类
 *  Service层处理业务逻辑数据
 * </p>
 *
 * @author chenhf
 */
//@SuppressWarnings("all")
//service层
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    //Service调用Mapper
    @Autowired
    private UserMapper userMapper;

    /**
     * @description 登录接口实现类, 处理登录业务逻辑, 包含参数校验等功能
     * @param loginVo
     * @param request
     * @param response
     * @return RespBean
     * @author Chenhf
     * @date 2022/6/30 19:22
     */

    @Override
    public RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        ////参数校验，使用springboot-starter-validation JSR303校验
        //if (StringUtils.isEmpty(mobile)||StringUtils.isEmpty(password)){
        //    //在这里调用了枚举类型
        //    return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        //}
        ////登录业务逻辑处理
        //if (!ValidatorUtil.isMobile(mobile)){
        //    return RespBean.error(RespBeanEnum.MOBILE_ERROR);
        //}
        //获取user
        User user = userMapper.selectById(mobile);
        if (user == null){
            //改造返回值, 异常处理的方式
            //定义完异常之后这样放进去
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
            //return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        //如果用户密码不正确
        if (!MD5Util.formPassToDBPass(password, user.getSalt()).equals(user.getPassword())){
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
            //return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }

        //生成cookie
        String ticket = UUIDUtil.uuid();
        //key就是cookie,值就是user对象
        request.getSession().setAttribute(ticket, user);
        CookieUtil.setCookie(request,response,"userTicket",ticket);
        return RespBean.success();
    }
}
