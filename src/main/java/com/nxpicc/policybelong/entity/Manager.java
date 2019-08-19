package com.nxpicc.policybelong.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Data
@Component
public class Manager implements Serializable {
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
}
