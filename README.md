# ThymeleafPoc
Thymeleaf is an open source templating engine for Java web application development. It is commonly used in the context of web applications based on the Spring framework, although it is not limited to Spring and can be used in other Java environments as well. Thymeleaf specializes in generating HTML views dynamically and flexibly.

A few highlights of Thymeleaf:

* Readable and friendly syntax: Uses a syntax that resembles standard HTML, making it easy to understand for developers and designers alike.

* Integration with Java and Spring.

* Supports expressions that allow you to access model data (e.g., data from a database), make conditional decisions and more, all directly in the templates.

* Generates the views on the server side.

Usefully links

https://springhow.com/spring-boot-thymeleaf-views-from-database/

https://www.baeldung.com/thymeleaf-in-spring-mvc

In a Spring Boot application, we can simplify the needed configuration

     <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>


This starter adds the necessary auto-configuration. All we need to do is start placing our template files in the resources/templates folder.



# ITextPDF
The library helps generate PDF files by either creating each element manually or by converting HTML+CSS into PDF. 

In a Spring Boot application, we can simplify the necessary configuration with maven dependency: 

      <dependency>
          <groupId>com.itextpdf</groupId>
          <artifactId>kernel</artifactId>
          <version>7.1.12</version>
      </dependency>


The Itext library comes with a supporting library called html2pdf that can convert Html and CSS to visually pleasing PDF documents: 
          
      <dependency>
          <groupId>com.itextpdf</groupId>
          <artifactId>html2pdf</artifactId>
          <version>3.0.1</version>
      </dependency>



Usefully links

https://springhow.com/spring-boot-pdf-generation/


  



