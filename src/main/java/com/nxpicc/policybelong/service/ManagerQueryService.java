package com.nxpicc.policybelong.service;

import com.nxpicc.policybelong.entity.Manager;
import com.nxpicc.policybelong.vo.ManagerQueryVo;

import java.util.List;

public interface ManagerQueryService{
    List<Manager> findManager(ManagerQueryVo managerQueryVo) throws Exception;
    //List<Manager> findManager2(ManagerQueryVo managerQueryVo);
}
