package com.chenhf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: TODO
 * @className: SeckillMessage
 * @author: Chenhf
 * @date: 2022/7/9 22:19
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeckillMessage {
    private User user;
    private Long GoodsId;
}
