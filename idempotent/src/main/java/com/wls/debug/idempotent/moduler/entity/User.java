package com.wls.debug.idempotent.moduler.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
/**
 * @Author:wangpeng
 * @Date: 2022/1/23
 * @Description: ***
 * @version:1.0
 */
@Data
public class User {
    private Long id;
    private String name;
    private String idCard;
    private Integer age;
    private String email;
    @TableLogic
    private Integer isDelete;
}