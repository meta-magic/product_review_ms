package com.metamagic.productreviewms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.metamagic.productreviewms.dto.VersionInfo;
import com.uber.jaeger.Tracer.Builder;
import com.uber.jaeger.metrics.Metrics;
import com.uber.jaeger.metrics.NullStatsReporter;
import com.uber.jaeger.metrics.StatsFactoryImpl;
import com.uber.jaeger.propagation.b3.B3TextMapCodec;
import com.uber.jaeger.reporters.RemoteReporter;
import com.uber.jaeger.samplers.ConstSampler;
import com.uber.jaeger.senders.HttpSender;

import io.opentracing.propagation.Format.Builtin;

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
	
	@Bean
	  public io.opentracing.Tracer jaegerTracer() {
	    Builder builder = new Builder("spring-boot",
	        new RemoteReporter(new HttpSender("http://jaeger-collector.istio-system:14268/api/traces"), 10,
	        65000, new Metrics(new StatsFactoryImpl(new NullStatsReporter()))),
	        new ConstSampler(true))
	        .registerInjector(Builtin.HTTP_HEADERS, new B3TextMapCodec())
	        .registerExtractor(Builtin.HTTP_HEADERS, new B3TextMapCodec());
	    return builder.build();
	  }
	

}

