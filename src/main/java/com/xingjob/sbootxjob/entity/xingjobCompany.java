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
public class xingjobCompany {
    @TableId(value="cpnyid",type= IdType.AUTO)
    private Long cpnyid;
    private Long uid;
    private String companyname;
    private String companyregnum;
    private String userposition;
    private String companyaddress;
    private String industry;
    private String companyintro;
    private String licencepic;
    private String licencepic2;
    private String email;
    @TableField(fill= FieldFill.INSERT)
    private Date addTime;
    @TableField(fill =FieldFill.INSERT_UPDATE)
    private Date updateTime;



}
