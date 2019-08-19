package com.nxpicc.policybelong.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Component
public class Policy implements Serializable {
    private String proposalNo;
    private String policyNo;
    private String classCode;
    private String riskCode;
    private String projectCode;
    private String businessNature;
    private String agriFlag;
    private Date operateDate;
    private Date startDate;
    private Date endDate;
    private BigDecimal sumAmount;
    private BigDecimal sumPremium;
    private BigDecimal coinsPremium;
    private BigDecimal sumSubPremium;
    private BigDecimal sumTaxfee;
    private BigDecimal sumNetPremium;
    private int sumQuantity;
    private int insuredCount;
    private String judicalScope;
    private String argueSolution;
    private int payTimes;
    private String makeCom;
    private String comCode;
    private String handlerCode;
    private String handlerName;
    private String handler1Code;
    private String handler1Name;
    private String approverCode;
    private String approverName;
    private String checkFlag;
    private String checkUpCode;
    private String checkOpinion;
    private String underwriteCode;
    private String underwriteName;
    private String operatorCode;
    private String operatorName;
    private Date underwriteEndDate;
    private String agentCode;
    private String coinsFlag;
    private String crossFlag;
    private String allinsFlag;
    private String underwriteFlag;
    private String jfeeFlag;
    private String policyRelCode;
    private String policyRelName;
    private String payMode;
    private String inputFlag;
    private String antiPovertyFlag;
    private Date undwrtSubmitDate;
    private String othFlag;
    private String flag;
    private String remark;
    private Date insertTimeForHis;
    private Date operateTimeForHis;
    private String reinsFlag;
    private Double pureRate;
    private Double disRate;
    private Double disCount;
    private String policyType;
    private Double sumDiscount;
    private Double sumValue;

    private String managerSetFlag;//1 表示手工清分  0 表示未清分 null 表示没有操作
    private String managerSetName;
    private String managerSetterCode;
    private String managerSetterName;
    private Date managerSetDate;
    private Date managerUpdateDate;
    private int managerShareSum;
}




