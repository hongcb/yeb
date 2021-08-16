package com.xxxx.yebserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.yebserver.mapper.AdminMapper;
import com.xxxx.yebserver.pojo.Admin;
import com.xxxx.yebserver.pojo.RespBean;
import com.xxxx.yebserver.service.IAdminService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hongchengbin
 * @since 2021-08-11
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Override
    public RespBean login(String username, String password, HttpServletRequest request) {
        return null;
    }
}
