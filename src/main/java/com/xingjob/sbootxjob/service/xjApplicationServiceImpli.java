package com.xingjob.sbootxjob.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xingjob.sbootxjob.entity.xingjobApplication;
import com.xingjob.sbootxjob.mapper.xjApplicationmapper;
import org.springframework.stereotype.Service;

@Service
public class xjApplicationServiceImpli extends ServiceImpl<xjApplicationmapper, xingjobApplication> implements xjApplicationService {
}
