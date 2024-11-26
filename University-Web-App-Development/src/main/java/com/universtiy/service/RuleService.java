package com.universtiy.service;

import com.university.model.Rules_And_Regulations;

import java.util.List;

public interface RuleService {
    public List<Rules_And_Regulations> getAllRules();
    public Rules_And_Regulations saveRule(Rules_And_Regulations rule) ;
}
