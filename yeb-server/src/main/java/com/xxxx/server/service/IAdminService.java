package com.xxxx.server.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.Admin;
import com.xxxx.server.pojo.RespBean;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hongchengbin
 * @since 2021-08-11
 */
public interface IAdminService extends IService<Admin> {

    /**
     * 登陆返回token
     * @param username 用户名
     * @param password 密码
     * @param request  http
     * @author hongcb
     * @date 2021/8/16 14:18
     * @return com.xxxx.yebserver.pojo.RespBean
     */
    RespBean login(String username, String password, HttpServletRequest request);

    /**
     *
     *根据用户名获取用户信息
     * @author hongcb
     * @date 2021/8/17 10:30 
     * @return com.xxxx.yebserver.pojo.Admin
     */
    Admin getAdminByUserName(String username);
}
