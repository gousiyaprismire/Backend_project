package com.university.controller;

import com.university.model.Rules_And_Regulations;
import com.university.serviceImpl.RuleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/college/rules")
public class RuleController{
    @Autowired
    private RuleServiceImpl ruleService;
    @GetMapping
    public List<Rules_And_Regulations> getRules() {
        return ruleService.getAllRules();
    }
    @PostMapping
    public Rules_And_Regulations addRule(@RequestBody Rules_And_Regulations rule) {
        return ruleService.saveRule(rule);
    }
}
