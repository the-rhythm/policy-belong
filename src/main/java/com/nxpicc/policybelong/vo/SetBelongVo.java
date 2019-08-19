package com.nxpicc.policybelong.vo;

import com.nxpicc.policybelong.entity.Manager;
import com.nxpicc.policybelong.entity.Policy;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SetBelongVo implements Serializable {
    private List<Policy> policyList;
    private List<Manager> managerList;
}
