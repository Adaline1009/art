package com.tezis;


import com.tezis.entity.Document;
import com.tezis.mapper.DocumentMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@Configuration
@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages={"com.tezis.controllers"})
@MapperScan("com.tezis.mapper")

public class Application {
    public static void main(String[] args) {
       // SpringApplication.run(Application.class,args);
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        DocumentMapper documentMapper = context.getBean(DocumentMapper.class);
       /* Document document = new Document();
        document.setDocNumber(1234);
        document.setDate(new Date());
        document.setContent("blalala");;
        documentMapper.insertDocument(document);
        Document doc = documentMapper.getDocument(1);
        doc.setDocNumber(//);*/
      //  Document doc = documentMapper.getDocument(1);
     //  System.out.println(doc.getContent());
    }
}




