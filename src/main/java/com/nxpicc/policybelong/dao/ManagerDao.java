package com.nxpicc.policybelong.dao;

import com.nxpicc.policybelong.entity.Manager;
import com.nxpicc.policybelong.vo.ManagerQueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ManagerDao {
    //    根据ManagerQueryVo 查询人员
    List<Manager> findManager(ManagerQueryVo managerQueryVo);

}
