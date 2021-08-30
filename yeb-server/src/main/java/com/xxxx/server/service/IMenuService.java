package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.Menu;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hongchengbin
 * @since 2021-08-11
 */
public interface IMenuService extends IService<Menu> {

    List<Menu> getMenusByAdminId();
}
