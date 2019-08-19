package com.nxpicc.policybelong.service;

import com.nxpicc.policybelong.dao.PolicyBelongDao;
import com.nxpicc.policybelong.dao.PolicyDao;
import com.nxpicc.policybelong.entity.Manager;
import com.nxpicc.policybelong.entity.Policy;
import com.nxpicc.policybelong.entity.PolicyBelong;
import com.nxpicc.policybelong.entity.PolicyWithManager;
import com.nxpicc.policybelong.vo.PolicyQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PolicyBelongServiceImpl implements PolicyBelongService {

    @Autowired
    private PolicyDao policyDao;
    @Autowired
    private PolicyBelongDao policyBelongDao;

    @Override
    public List<PolicyWithManager> findPoliciesWithManager(PolicyQueryVo policyQueryVo) throws Exception{
        return policyDao.findPoliciesWithManager(policyQueryVo);
    }

    @Transactional
    @Override
    public void addManagerToPolicy(Policy policy, PolicyBelong policyBelong) throws Exception{
        //1.往hrjx_agri_bdjbxxb 里面插入一条保单归属记录
        policyBelongDao.insertPolicyBelong(policyBelong);
        //3.查询更新Policy的managersharesum 和 managernums
        int managerShareSum = policyDao.countShareSum(policyBelong.getPolicyNo(), null);
        policyDao.updateShareSum(policyBelong.getPolicyNo(), null, managerShareSum);
        int managerNum = policyDao.countMangerNums(policyBelong.getPolicyNo(), null);
        policyDao.updateManagerNums(policyBelong.getPolicyNo(), null, managerNum);
    }

    @Override
    public void deleteManagerOfPolicy(Policy policy, PolicyBelong policyBelong) throws Exception{
//       使保单归属表里的记录失效
        policyBelongDao.invalidPolicyBelong(policyBelong);
//        更新Policy记录 managersettercode managersettername managersetterdate
        int managerShareSum = policyDao.countShareSum(policyBelong.getPolicyNo(), null);
        policyDao.updateShareSum(policyBelong.getPolicyNo(), null, managerShareSum);
        int manageNum = policyDao.countMangerNums(policyBelong.getPolicyNo(), null);
        policyDao.updateManagerNums(policyBelong.getPolicyNo(), null, manageNum);
    }

    @Override
    @Transactional
    public void setPolicyBelong(List<Policy> policyList, List<Manager> managerList) throws Exception{
        Policy policy;
        Manager manager;
        for (int i = 0; i < policyList.size(); i++) {
            for (int j = 0; j < managerList.size(); j++) {
                policy = policyList.get(i);
                manager = managerList.get(j);
                PolicyBelong policyBelong = new PolicyBelong();
                policyBelong.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                policyBelong.setPolicyNo(policy.getPolicyNo());
                policyBelong.setProposalNo(policy.getProposalNo());
                policyBelong.setPolicyFlag("AGRI");
                policyBelong.setSumPremium(policy.getSumPremium());
                policyBelong.setManagerCode(manager.getManagerCode());
                policyBelong.setComCode(policy.getComCode());
                policyBelong.setDeptCode(manager.getDeptCode());
                policyBelong.setDeptName(manager.getDeptName());
                policyBelong.setManagerShare(manager.getManagerShare());
                policyBelong.setManagerName(manager.getManagerName());
                policyBelong.setManagerSetterCode(policy.getManagerSetterCode());
                policyBelong.setManagerSetterName(policy.getManagerSetterName());
                policyBelong.setValidFlag("1");
                policyBelong.setOperateDate(new Date());
                policyBelong.setInsertDate(new Date());
                policyBelongDao.insertPolicyBelong(policyBelong);
            }
        }
        //批量插入 policyBelong informix 不支持
         // policyBelongDao.insertPolicyBelongs(policyBelongList);
        //更新 policy 的 managerShareSum 和 managerNums
        int managerShareSum;
        int managerNum;
        Policy policy1;
        for (int k = 0; k < policyList.size(); k++) {
            policy1 = policyList.get(k);
            managerShareSum = policyDao.countShareSum(policy1.getPolicyNo(), policy1.getProposalNo());
            policyDao.updateShareSum(policy1.getPolicyNo(), policy1.getProposalNo(), managerShareSum);
            managerNum = policyDao.countMangerNums(policy1.getPolicyNo(), policy1.getProposalNo());
            policyDao.updateManagerNums(policy1.getPolicyNo(), policy1.getProposalNo(), managerNum);
        }

    }

    //删除保单归属
    @Transactional
    @Override
    public void deletePolicyBelong(PolicyBelong policyBelong) throws Exception{
        //删除 hrjx_agri_policybelong里的保单归属记录
        policyBelongDao.deletePolicyBelong(policyBelong);
        int managerNum;
        //查询有无保单归属记录，如果没有，则 managerNum=0 managerShareSum=0,如果有则更新
        managerNum = policyDao.countMangerNums(policyBelong.getPolicyNo(), policyBelong.getProposalNo());
        policyDao.updateManagerNums(policyBelong.getPolicyNo(), policyBelong.getProposalNo(), managerNum);
        if(managerNum==0){
            policyDao.updateShareSum(policyBelong.getPolicyNo(),policyBelong.getProposalNo(),0);

        }else{
            int managerShareSum=policyDao.countShareSum(policyBelong.getPolicyNo(),policyBelong.getProposalNo());
            policyDao.updateShareSum(policyBelong.getPolicyNo(),policyBelong.getProposalNo(),managerShareSum);
        }
    }

}
