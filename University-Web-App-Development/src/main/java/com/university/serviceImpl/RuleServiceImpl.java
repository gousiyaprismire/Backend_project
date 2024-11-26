package com.university.serviceImpl;

import com.university.model.Rules_And_Regulations;
import com.university.repository.RuleRepository;
import com.universtiy.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {
    @Autowired
    private RuleRepository ruleRepository;

    public List<Rules_And_Regulations> getAllRules()
    {
        return ruleRepository.findAll();
    }
    public Rules_And_Regulations saveRule(Rules_And_Regulations rule) {
        return ruleRepository.save(rule); }
}

