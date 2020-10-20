package com.xingjob.sbootxjob.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xingjob.sbootxjob.common.R;
import com.xingjob.sbootxjob.entity.xingjobResume;
import com.xingjob.sbootxjob.mapper.xjResumemapper;
import com.xingjob.sbootxjob.service.xjResumeService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/xjob/resume")
@MapperScan("com.xingjob.sbootxjob.mapper")
@CrossOrigin
public class xjResumeController {
    @Autowired
    private xjResumemapper xjresumemapper;
    @Autowired
    private xjResumeService xjresumeservice;


    //添加简历
    @PostMapping("addresume")
    public R addresume(@RequestBody xingjobResume xjresume){
        boolean save = xjresumeservice.save(xjresume);
        if(save){
            return R.ok();
        }else {
            return R.error();
        }
    }

    //分页简历查询
    @GetMapping("pageresume/{resumestatus}/{current}/{limit}")
    public R pageListJob(
            @PathVariable byte resumestatus,
            @PathVariable long current,
            @PathVariable long limit){
        Page<xingjobResume> pageRequirement = new Page<>(current,limit);
        QueryWrapper<xingjobResume> wrapper = new QueryWrapper<>();
        wrapper.eq("resumestatus",resumestatus);
        wrapper.orderByDesc("resumeid");
        xjresumeservice.page(pageRequirement,wrapper);
        long total = pageRequirement.getTotal();
        List<xingjobResume> records = pageRequirement.getRecords();
//        Collections.reverse(records);//集合翻转顺序
        return R.ok().data("total",total).data("records",records);
    }

    //根据用户ID查询简历
    @GetMapping("queryresume/{uid}")
    public R getrequirement(@PathVariable long uid){
        QueryWrapper<xingjobResume> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",uid);
        List<xingjobResume> queryresume = xjresumemapper.selectList(wrapper);
        return R.ok().data("idqueryresume",queryresume);

    }
}
