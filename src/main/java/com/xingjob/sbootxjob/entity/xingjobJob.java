package com.xingjob.sbootxjob.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class xingjobJob {
    @TableId(value="jobid",type= IdType.AUTO)
    private Long jobid;
    private Long uid;
    private String jobtitle;
    private Long salary;
    private String address;
    private Long edulevel;
    private String jobdesc;
    private String longitude;
    private String latitude;
    private String addressname;
    private Byte status;
    private String email;
    private String contactphone;
    private String avatar;
    private String nickname;
    private String wechatnum;
    private String telephone;
    private String contactname;
    private String userposition;
    private String companyname;
    @TableField(fill= FieldFill.INSERT)
    private Date addTime;
    @TableField(fill =FieldFill.INSERT_UPDATE)
    private Date updateTime;



}
