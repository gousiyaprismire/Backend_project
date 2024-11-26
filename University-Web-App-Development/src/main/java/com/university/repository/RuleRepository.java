package com.university.repository;

import com.university.model.Rules_And_Regulations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleRepository extends JpaRepository<Rules_And_Regulations,Long> {
}
