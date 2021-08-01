package com.awei.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @program: jwt
 * @author: shizuwei
 * @create: 2021-03-08 14:58
 **/
@Configuration
@EnableSwagger2

public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.awei.swagger.web"))
                .build()
                ;
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("shizuwei", "https://www.cnblogs.com/shizuwei/", "shizuwei99@gmail.com");

       return new ApiInfo("阿威的Swagger API文档"
               , "这是一个测试swagger 描述文档"
               , "v1.0"
               , "https://www.cnblogs.com/shizuwei/"
               ,
                contact
               , "Apache 2.0"
               , "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
    }


}
