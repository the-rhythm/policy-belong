package com.nxpicc.policybelong.vo;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;


@Data
public class PolicyQueryVo implements Serializable {
    private int pageSize;
    private int pageNo;
    private String policyNo;
    private String proposalNo;
    private String riskCode;
    private String comCode;
    private String comName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDateS;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDateE;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDateS;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDateE;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date operateDateS;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date operateDateE;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date underwriteEndDateS;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date underwriteEndDateE;

}
