package com.xingjob.sbootxjob.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xingjob.sbootxjob.entity.xingjobUser;

public interface xjUserService extends IService<xingjobUser> {
    String login(xingjobUser xingjuser);
}
