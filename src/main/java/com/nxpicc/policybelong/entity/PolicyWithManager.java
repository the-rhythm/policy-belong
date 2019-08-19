package com.nxpicc.policybelong.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@Data
public class PolicyWithManager implements Serializable {
    private String proposalNo;
    private String policyNo;
    private Policy policy;
    private List<PolicyBelong> policyBelongList;
}
