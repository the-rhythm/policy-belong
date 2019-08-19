package com.nxpicc.policybelong.dao;
import com.nxpicc.policybelong.entity.PolicyBelong;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PolicyBelongDao {

//    插入一条保单归属信息
    int insertPolicyBelong(PolicyBelong policyBelong);

//    删除一条保单归属信息
    int deletePolicyBelong(PolicyBelong policyBelong);

//    使一条保单归属信息失效
    int invalidPolicyBelong(PolicyBelong policyBelong);

//    插入多条保单归属信息
    int insertPolicyBelongs(@Param("policyBelongList") List<PolicyBelong> policyBelongList);

//    根据保单号查询某个保单的所有归属信息
    List<PolicyBelong> findPolicyBelongByPolicyNo(String policyNo);

}
