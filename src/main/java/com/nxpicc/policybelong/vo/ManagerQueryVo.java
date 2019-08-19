package com.nxpicc.policybelong.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ManagerQueryVo implements Serializable {
    private String managerCode;
    private String managerName;
    private String comCode;
    private String comName;
    private String deptCode;
    private String deptName;
    private String rankName;
    private String rankCode;
    private String validFlag;
    private Date insertDate;
    private Date updateDate;
    private int managerShare;
    private int pageNo;
    private int pageSize;
}
