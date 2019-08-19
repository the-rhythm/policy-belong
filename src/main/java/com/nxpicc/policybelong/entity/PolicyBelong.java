package com.nxpicc.policybelong.entity;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Component
public class PolicyBelong implements Serializable {
    private String id;
    private String policyNo;
    private String proposalNo;
    private String policyFlag;
    private BigDecimal sumPremium;
    private String managerCode;
    private String comCode;
    private String deptCode;
    private String deptName;
    private int managerShare;
    private String managerName;
    private Date operateDate;
    private Date insertDate;
    private String managerSetterCode;
    private String managerSetterName;
    private String validFlag;
}

