package com.xingjob.sbootxjob.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class xingjobUser {
    @TableId(value="uid",type= IdType.AUTO)
    private Long uid;
    private String username;
    private String password;
    private Integer gender;
    private LocalDate birthday;
    private LocalDateTime lastLoginTime;
    private String lastLoginIp;
    private Byte userLevel;
    private String nickname;
    private String mobile;
    private String avatar;
    private String weixinOpenid;
    private String sessionKey;
    private Byte status;
    @TableField(fill= FieldFill.INSERT)
    private Date addTime;
    @TableField(fill =FieldFill.INSERT_UPDATE)
    private Date updateTime;
    private Boolean deleted;

}
