package com.nxpicc.policybelong.service;
import com.nxpicc.policybelong.entity.Manager;
import com.nxpicc.policybelong.entity.Policy;
import com.nxpicc.policybelong.entity.PolicyBelong;
import com.nxpicc.policybelong.entity.PolicyWithManager;
import com.nxpicc.policybelong.vo.PolicyQueryVo;

import java.util.List;

public interface PolicyBelongService {
//     根据PolicyVo 查询保单及保单归属
    List<PolicyWithManager> findPoliciesWithManager(PolicyQueryVo policyQueryVo) throws Exception;

//    新增保单归属 1.往hrjx_agri_policybelong 插入一条归属记录  2.更新hrjx_agri_bdjbxxb的   managersettercode managersettername managersetdate managerupdatedate managersetnamemanagersharesum managerNums
    void addManagerToPolicy(Policy policy, PolicyBelong policyBelong) throws Exception;

//    删除保单的归属客户经理
    void deleteManagerOfPolicy(Policy policy,PolicyBelong policyBelong) throws Exception;

    //根据 policyList 和 managerList 设置保单归属
    void setPolicyBelong(List<Policy> policyList,List<Manager> managerList) throws Exception;

    //删除保单归属
    void deletePolicyBelong(PolicyBelong policyBelong) throws Exception;

}
