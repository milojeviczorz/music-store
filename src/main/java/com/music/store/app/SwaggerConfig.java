package com.music.store.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String SWAGGER_API_VERSION = "1.0";
	private static final String LICENCE_TEXT = "1.0";
	private static final String TITLE = "REST API";
	private static final String DESCRIPTION = "Restful API";

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(TITLE).description(DESCRIPTION).license(LICENCE_TEXT)
				.version(SWAGGER_API_VERSION).build();
	}

	@Bean
	public Docket musicStoreApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).pathMapping("/").select()
				.paths(PathSelectors.regex("/api.*")).build();
	}

}
