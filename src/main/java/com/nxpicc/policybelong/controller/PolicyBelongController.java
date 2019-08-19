package com.nxpicc.policybelong.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nxpicc.policybelong.entity.Manager;
import com.nxpicc.policybelong.entity.Policy;
import com.nxpicc.policybelong.entity.PolicyBelong;
import com.nxpicc.policybelong.entity.PolicyWithManager;
import com.nxpicc.policybelong.service.ManagerQueryService;
import com.nxpicc.policybelong.service.PolicyBelongService;
import com.nxpicc.policybelong.utils.RespBean;
import com.nxpicc.policybelong.utils.RespUtils;
import com.nxpicc.policybelong.vo.ManagerQueryVo;
import com.nxpicc.policybelong.vo.PolicyQueryVo;
import com.nxpicc.policybelong.vo.SetBelongVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/policyBelong")
public class PolicyBelongController{

    @Autowired
    private PolicyBelongService policyBelongService;

    @Autowired
    private ManagerQueryService managerQueryService;

    @RequestMapping(value = "/getPolicyList",method = RequestMethod.POST)
    private RespBean getPoliciesWithManager(@ModelAttribute PolicyQueryVo policyQueryVo) throws Exception{
        int pageSize=policyQueryVo.getPageSize();
        int pageNo=policyQueryVo.getPageNo();
        PageHelper.startPage(pageNo,pageSize).countColumn("*") ;
        List<PolicyWithManager> policyWithManagerList = policyBelongService.findPoliciesWithManager(policyQueryVo);
        PageInfo pageInfo=new PageInfo<PolicyWithManager>(policyWithManagerList);
        System.out.println("+++++++++"+pageInfo);
        return RespUtils.success(pageInfo);
    }

    @RequestMapping(value = "/getManagerList",method = RequestMethod.POST)
    private RespBean getManagerList(@ModelAttribute ManagerQueryVo managerQueryVo) throws Exception{
        int pageSize=managerQueryVo.getPageSize();
        int pageNo=managerQueryVo.getPageNo();
        PageHelper.startPage(pageNo,pageSize).countColumn("*") ;
        List<Manager> managerList=managerQueryService.findManager(managerQueryVo);
        PageInfo pageInfo=new PageInfo<Manager>(managerList);
        System.out.println(pageInfo);
        return RespUtils.success(pageInfo);
    }

    @RequestMapping(value="/setBelong",method = RequestMethod.POST)
    private RespBean setBelong(@RequestBody SetBelongVo setBelongVo) throws Exception{
        List<Policy> policyList=setBelongVo.getPolicyList();
        List<Manager> managerList=setBelongVo.getManagerList();
        policyBelongService.setPolicyBelong(policyList,managerList);
        return  RespUtils.success();
    }

    @RequestMapping(value = "/deleteBelong",method = RequestMethod.POST)
    private RespBean deleteBelong(@RequestBody PolicyBelong policyBelong) throws Exception{
        policyBelongService.deletePolicyBelong(policyBelong);
        return  RespUtils.success();
    }

}
