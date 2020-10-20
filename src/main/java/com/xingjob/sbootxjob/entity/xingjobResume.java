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
public class xingjobResume {
    @TableId(value="resumeid",type= IdType.AUTO)
    private Long resumeid;
    private Long uid;
    private String realname;
    private Byte gender;
    private String email;
    private String resumeavatar;
    private String education;
    private String jobstatus;
    private String age;
    private String college;
    private String selfintro;
    private Long expectsalary;
    private String jobexperience;
    private String project;
    private String educationexperience;
    private String nativeplace;
    private String major;
    private String mobile;
    @TableField(fill= FieldFill.INSERT)
    private Date addTime;
    @TableField(fill =FieldFill.INSERT_UPDATE)
    private Date updateTime;
    private Byte resumestatus;
}
