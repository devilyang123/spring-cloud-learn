package com.xiao.pojo;

import lombok.Data;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description
 * @Auther: 笑笑
 * @Date: 15:45 2019/3/30
 */

@Data
@Table(name = "tb_user")
public class User {

    @Id
    private Long userId;

    private String userName;

    private String userPassword;
}
