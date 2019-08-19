package com.nxpicc.policybelong.dao;

import com.nxpicc.policybelong.entity.Policy;
import com.nxpicc.policybelong.entity.PolicyBelong;
import com.nxpicc.policybelong.entity.PolicyWithManager;
import com.nxpicc.policybelong.vo.PolicyQueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PolicyDao {

    //更新保单表
    int updatePolicyByPolicyBelong(PolicyBelong policyBelong);

    //根据保单号查询保单
    Policy findPolicyByPolicyNo(String policyNo);

    //根据投保单号查询保单
    Policy findPolicyByProposalNo(String proposalNo);

    //根据保单号标记手工划定归属
    int setPolicyManager(Policy policy);

    // 根据policyQueryVo 查询保单及保单归属
    List<PolicyWithManager> findPoliciesWithManager(PolicyQueryVo policyQueryVo);

    // 根据保单号或者投保单号查询保单归属
    PolicyWithManager findPolicyWithManagerByPNo(@Param("policyNo") String policyNo, @Param("proposalNo") String proposalNo);

    //计算某个保单的份额和
    Integer countShareSum(@Param("policyNo") String policyNo, @Param("proposalNo") String proposalNo);

    //    更新某个保单的份额和
    int updateShareSum(@Param("policyNo") String policyNo, @Param("proposalNo") String proposalNo, @Param("managerShareSum") int managerShareSum);

    // 计算某个保单的客户经理数量
    Integer countMangerNums(@Param("policyNo") String policyNo, @Param("proposalNo") String proposalNo);

    int updateManagerNums(@Param("policyNo")String policyNo,@Param("proposalNo") String proposalNo,@Param("managerNums") int managerNums);

}
