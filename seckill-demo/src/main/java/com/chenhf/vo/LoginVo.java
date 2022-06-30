package com.chenhf.vo;

import lombok.Data;

/**
 * @description: TODO
 * @className: LoginVo
 * @author: Chenhf
 * @date: 2022/6/30 19:01
 * @version: 1.0
 */
//获取用户输入，与后端获取的账号密码保持一致
//相当于后端的mobile password
@Data
public class LoginVo {
    private String mobile;
    private String password;
}
