package com.nxpicc.policybelong;

import com.nxpicc.policybelong.dao.ManagerDao;
import com.nxpicc.policybelong.dao.PolicyBelongDao;
import com.nxpicc.policybelong.dao.PolicyDao;
import com.nxpicc.policybelong.entity.Manager;
import com.nxpicc.policybelong.entity.Policy;
import com.nxpicc.policybelong.entity.PolicyBelong;
import com.nxpicc.policybelong.entity.PolicyWithManager;
import com.nxpicc.policybelong.service.PolicyBelongService;
import com.nxpicc.policybelong.vo.PolicyQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PolicyBelongApplicationTests {

    @Autowired
    private PolicyDao policyDao;
    @Autowired
    private PolicyBelongDao policyBelongDao;
    @Autowired
    private PolicyBelongService policyBelongService;
    @Autowired
    private ManagerDao managerDao;

    @Test
    public void policyTest(){
        Policy p=policyDao.findPolicyByPolicyNo("P6BX20196403N000000011");
        p.setManagerSetFlag("1");
        p.setManagerSetterCode("17246262");
        p.setManagerSetName("手工划归");
        p.setManagerSetterName("测试");
        p.setManagerSetDate(new Date());
        policyDao.setPolicyManager(p);
        Policy p1=policyDao.findPolicyByPolicyNo("P6BX20196403N000000011");
        System.out.println(p1.toString());
    }

    @Test
    public void managerTest(){
        Manager manager=new Manager();
        manager.setComCode("64019100");
    }

    @Test
    public void policyBelongTest(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        PolicyBelong policyBelong=new PolicyBelong();
        policyBelong.setId(uuid);
        policyBelong.setComCode("6401000");
        policyBelong.setPolicyNo("P6BX20196403N000000011");
        policyBelong.setManagerCode("17246262");
        policyBelong.setManagerShare(50);
        //policyBelong.setInsertTime(new Date());
        policyBelong.setValidFlag("1");
        policyBelongDao.insertPolicyBelong(policyBelong);
    }

    @Test
    public void policyWithManagerTest(){
        List<PolicyWithManager> list = new ArrayList<PolicyWithManager>();
        PolicyQueryVo policyQueryVo= new PolicyQueryVo();
        policyQueryVo.setPolicyNo("PINW20196403N000000253");
        list=policyDao.findPoliciesWithManager(policyQueryVo);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
    }

    @Test
    public void uuidTest(){
        String uuid;
        for(int i=0;i<353;i++){
            uuid=UUID.randomUUID().toString().replaceAll("-","");
            System.out.println(uuid);
        }
    }


    @Test
    public void policyBelongServiceTest(){
        Policy policy= new Policy();
        PolicyBelong policyBelong = new PolicyBelong();
        policyBelong.setId(UUID.randomUUID().toString().replaceAll("-",""));
        policyBelong.setComCode("64032472");
        policyBelong.setPolicyNo("PINW20196403N000000253");
        policyBelong.setProposalNo("TINW20196403N000000226");
        policyBelong.setManagerShare(50);
        policyBelong.setManagerCode("86403913");
        policyBelong.setValidFlag("1");
        policyBelong.setManagerName("周小梅");
        policyBelong.setDeptCode("0004567");
        policyBelong.setDeptName("农险部");
        policyBelong.setInsertDate(new Date());
        //policyBelongService.addManagerToPolicy(policy,policyBelong);
    }

    @Test
    public void policyBelongInvalidTest(){
        PolicyBelong policyBelong=new PolicyBelong();
        policyBelong.setId("ed0bf8e1a9054c91b70a21b7330327be");
        policyBelong.setPolicyNo("PINW20196403N000000253");
        policyBelong.setManagerCode("86403913");
        //policyBelongService.deleteManagerOfPolicy(null,policyBelong);
    }

    @Test
    public void logTest(){

     log.error("错误日志输出测试");
    }


    @Test
    public void contextLoads() {
    }

}
