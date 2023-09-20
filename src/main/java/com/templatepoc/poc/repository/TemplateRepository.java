package com.templatepoc.poc.repository;

import com.templatepoc.poc.model.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends JpaRepository<Template, Long> {
    Template findByName(String Name);
}
