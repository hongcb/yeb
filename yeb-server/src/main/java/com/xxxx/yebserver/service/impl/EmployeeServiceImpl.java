package com.xxxx.yebserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.yebserver.mapper.EmployeeMapper;
import com.xxxx.yebserver.pojo.Employee;
import com.xxxx.yebserver.service.IEmployeeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hongchengbin
 * @since 2021-08-11
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
