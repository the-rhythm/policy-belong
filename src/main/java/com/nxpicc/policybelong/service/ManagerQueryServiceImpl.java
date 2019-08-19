package com.nxpicc.policybelong.service;
import com.nxpicc.policybelong.dao.ManagerDao;
import com.nxpicc.policybelong.entity.Manager;
import com.nxpicc.policybelong.vo.ManagerQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ManagerQueryServiceImpl implements ManagerQueryService{

    @Autowired
    private ManagerDao managerDao;
    @Override
    public List<Manager> findManager(ManagerQueryVo managerQueryVo) throws Exception{
        return managerDao.findManager(managerQueryVo);
    }

  /*  @Override
    public List<Manager> findManager2(ManagerQueryVo managerQueryVo) {
        return managerDao.findManager2(managerQueryVo);
    }*/


}
