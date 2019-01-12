package org.jfteam.framework.config;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2019/1/12 16:55
 */

import org.jfteam.framework.holder.AppContextHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = {"org.jfteam.**.controller"})
@EnableWebMvc
@Component
public class SwaggerConfig {

    @Bean
    public Docket customDocket() {
        if (AppContextHolder.isDebug()) {
            return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
        }
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfoForOnline()).select().paths(PathSelectors.none()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("服务平台API").description("").build();
    }

    private ApiInfo apiInfoForOnline() {
        return new ApiInfo("", "", "", "", null, "", "", new ArrayList<>());
    }
}
