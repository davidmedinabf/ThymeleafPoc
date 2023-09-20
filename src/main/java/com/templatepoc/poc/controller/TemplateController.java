package com.templatepoc.poc.controller;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.templatepoc.poc.repository.TemplateRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RestController
public class TemplateController {

    private final TemplateEngine templateEngine;
    private final TemplateRepository templateRepository;

    public TemplateController(TemplateEngine templateEngine, TemplateRepository templateRepository) {
        this.templateEngine = templateEngine;
        this.templateRepository = templateRepository;
    }


    @RequestMapping("/welcome/{userType}")
    public  ResponseEntity<?> viewFromDbTemplate(@PathVariable String userType) {

        Context context = new Context();

        //Create Model
        context.setVariable("logo", "https://placehold.co/200x25/F1F1F1/000?text=Blankfactor&font=raleway");

        Map<String, Object> certificate = new HashMap<>();
        certificate.put("expeditionDate", "2021-01-01");
        certificate.put("addressedTo", "Mike Doe");
        certificate.put("withSalary", false);

        context.setVariable("certificate", certificate);

        Map<String, Object> employee = new HashMap<>();
        employee.put("names", "Big Joe");
        employee.put("governmentId", "123456789");
        employee.put("position", "Software Engineer");
        employee.put("startDate", "2021-01-01");
        employee.put("salaryInLetters", "One thousand");
        employee.put("salaryInNumbers", "1000");

        context.setVariable("employee", employee);

        Map<String, Object> signer = new HashMap<>();
        signer.put("name", "John Doe");
        signer.put("position", "CEO");
        signer.put("email", "jhon@email.com");
        signer.put("signature", "https://placehold.co/280x70/F1F1F1/000?text=Signer%201&font=raleway");

        context.setVariable("signer", signer);

        String orderHtml = templateEngine.process(userType, context);

        ByteArrayOutputStream target = new ByteArrayOutputStream();
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setBaseUri("http://localhost:8080");

        /* Call convert to PDF method  */
        HtmlConverter.convertToPdf(orderHtml, target, converterProperties);

        /* extract output as bytes */
        byte[] bytes = target.toByteArray();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=certificate.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(bytes);


        //return  userType;
    }


}
