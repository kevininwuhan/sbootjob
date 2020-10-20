package com.xingjob.sbootxjob.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xingjob.sbootxjob.common.R;
import com.xingjob.sbootxjob.entity.xingjobJob;
import com.xingjob.sbootxjob.mapper.xjJobmapper;
import com.xingjob.sbootxjob.service.xjJobService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/xjob/job")
@MapperScan("com.xingjob.sbootxjob.mapper")
@CrossOrigin
public class xjJobController {
    @Autowired
    private xjJobmapper xjJobmapper;
    @Autowired
    private xjJobService xjjobservice;

    //增加职位
    @PostMapping("addxjJob")
    public R addxjJob(@RequestBody xingjobJob xingjobjob){
        boolean save = xjjobservice.save(xingjobjob);
        if(save){
            return R.ok();
        }else {
            return R.error();
        }
    }

    //分页职位查询
    @GetMapping("pagejob/{current}/{limit}")
    public R pageListJob(@PathVariable long current,
                                 @PathVariable long limit){
        Page<xingjobJob> pageRequirement = new Page<>(current,limit);
        QueryWrapper<xingjobJob> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("jobid");
        xjjobservice.page(pageRequirement,wrapper);
        long total = pageRequirement.getTotal();
        List<xingjobJob> records = pageRequirement.getRecords();
//        Collections.reverse(records);//集合翻转顺序
        return R.ok().data("total",total).data("records",records);
    }

    //根据用户ID查询职位
    @GetMapping("queryjob/{uid}")
    public R getrequirement(@PathVariable long uid){
        QueryWrapper<xingjobJob> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",uid);
        List<xingjobJob> queryjob = xjJobmapper.selectList(wrapper);
        return R.ok().data("idqueryjob",queryjob);
    }





}
