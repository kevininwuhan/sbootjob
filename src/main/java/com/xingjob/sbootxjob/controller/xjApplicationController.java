package com.xingjob.sbootxjob.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xingjob.sbootxjob.common.R;
import com.xingjob.sbootxjob.entity.xingjobApplication;
import com.xingjob.sbootxjob.entity.xingjobJob;
import com.xingjob.sbootxjob.entity.xingjobResume;
import com.xingjob.sbootxjob.mapper.xjApplicationmapper;
import com.xingjob.sbootxjob.service.xjApplicationService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/xjob/application")
@MapperScan("com.xingjob.sbootxjob.mapper")
@CrossOrigin
public class xjApplicationController {
    @Autowired
    private xjApplicationmapper xjapplicationmapper;
    @Autowired
    private xjApplicationService xjapplicationservice;

    //增加申请
    @PostMapping("addxjApplication")
    public R addxjJob(@RequestBody xingjobApplication xingjobapplication){
        boolean save = xjapplicationservice.save(xingjobapplication);
        if(save){
            return R.ok();
        }else {
            return R.error();
        }
    }

    //根据jobid查询application
    @GetMapping("queryappliction/{jobid}")
    public R getrequirement(@PathVariable long jobid){
        QueryWrapper<xingjobApplication> wrapper = new QueryWrapper<>();
        wrapper.eq("jobid",jobid);
        List<xingjobApplication> queryappliction = xjapplicationmapper.selectList(wrapper);
        return R.ok().data("queryappliction",queryappliction);
    }

    //根据uid查询application
    @GetMapping("uidqueryappliction/{uid}")
    public R getsecondrequirement(@PathVariable long uid){
        QueryWrapper<xingjobApplication> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",uid);
        List<xingjobApplication> queryappliction = xjapplicationmapper.selectList(wrapper);
        return R.ok().data("uidqueryappliction",queryappliction);
    }
}
