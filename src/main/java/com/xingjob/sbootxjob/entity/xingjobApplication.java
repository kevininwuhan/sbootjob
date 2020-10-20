package com.xingjob.sbootxjob.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class xingjobApplication {
    private Long applicationid;
    private Long jobid;
    private Long uid;
    private String nickname;
    private String avatar;
    @TableField(fill= FieldFill.INSERT)
    private Date addTime;
    @TableField(fill =FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
