package com.cqupt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2  //启动Swagger的自动配置
public class SwaggerConfig {

    //此处配置文档的生成规则
    //Docket:封装的接口信息，定义API的生成规则
    @Bean
    public Docket getDocket() {
        //封装封面信息对象
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("颐养中心项目后端接口文档说明")
                      .description("文档说明:这是颐养中心项目后端接口文档")
                      .version("1.0")
                      .contact(new Contact("汪彦辰",null,"985284116@qq.com"));
        //设置文档基本信息，设置其生成的风格
        ApiInfo apiInfo = apiInfoBuilder.build();
        return new Docket(DocumentationType.SWAGGER_2)
                      .apiInfo(apiInfo)
                      .select()
                      .apis(RequestHandlerSelectors.basePackage("com.cqupt.controller"))
                      .paths(PathSelectors.any())  //指定路径为com.cqupt.Controller下的任意路径
                      .build();
    }
}
