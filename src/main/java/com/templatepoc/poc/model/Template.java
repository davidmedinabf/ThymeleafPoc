package com.templatepoc.poc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
@Entity
public class Template {

    @Id
    private Long id;

    private String name;

    @Lob
    private String content;

}
