package com.xingjob.sbootxjob.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xingjob.sbootxjob.common.JwtUtils;
import com.xingjob.sbootxjob.entity.xingjobUser;
import com.xingjob.sbootxjob.mapper.xjUsermapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class xjUserServiceImpli extends ServiceImpl<xjUsermapper, xingjobUser> implements xjUserService {
    @Autowired
    private xjUserService xjuserservice;

    //登录方法
    @Override
    public String login (xingjobUser xingjuser){
        String weixin_openid = xingjuser.getWeixinOpenid();
        //OPENID非空判断
        if(StringUtils.isEmpty(weixin_openid)){ }
        //判断openid是否正确
        QueryWrapper<xingjobUser> wrapper = new QueryWrapper<>();
        wrapper.eq("weixin_openid",weixin_openid);
        xingjobUser openidMember = baseMapper.selectOne(wrapper);
        if(openidMember == null){
            boolean save =  xjuserservice.save(xingjuser);
        }
        //通过mapper再次遍历wrapper 不然会报空指针异常
        xingjobUser secondopenidMember = baseMapper.selectOne(wrapper);
        //生成token ,使用JWT
        Map<String,String> payload = new HashMap<>();
        payload.put("uid",secondopenidMember.getUid().toString());
        String token = JwtUtils.getToken(payload);
        return token;
    }
}
