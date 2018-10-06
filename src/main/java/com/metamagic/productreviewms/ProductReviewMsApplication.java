package com.metamagic.productreviewms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.metamagic.productreviewms.dto.VersionInfo;

@SpringBootApplication
public class ProductReviewMsApplication extends SpringBootServletInitializer{

	
	public static void main(String[] args) {
		SpringApplication.run(ProductReviewMsApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ProductReviewMsApplication.class);
	}
	
	@Bean
	public VersionInfo getVersion(){
		String version = System.getenv("PRODUCTREVIEW_VERSION");
		System.out.println("*****version******"+version);
		if(version==null){
			version = " ";
		}
		return new VersionInfo(version);
	}

}

