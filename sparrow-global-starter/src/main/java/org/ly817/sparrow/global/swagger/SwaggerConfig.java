package org.ly817.sparrow.global.swagger;

import org.springframework.beans.factory.annotation.Value;
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

/**
 * @author LY
 * @date 2020/01/05 13:53
 * <p>
 * Description:
 * 微服务模块swagger
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${spring.application.name}")
    private String appName;

    // 读取各微服务配置文件中开发联系人的信息
    @Value("${swagger.contact.name}")
    private String contactName;

    @Value("${swagger.contact.url}")
    private String contactUrl;

    @Value("${swagger.contact.email}")
    private String contactEmail;


    @Bean
    public Docket buildDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInf()) // .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(""))// 需要生成文档的包的位置 全部扫描
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 接口基本信息
     */
    private ApiInfo buildApiInf() {
        return new ApiInfoBuilder()
                .title(appName + "服务")
                .description("Zuul+Swagger2构建RESTful APIs")
                .termsOfServiceUrl("http://localhost:8080")
                // 联系人
                .contact(new Contact(contactName, contactUrl, contactEmail))
                .version("1.0")
                .build();
    }

}
