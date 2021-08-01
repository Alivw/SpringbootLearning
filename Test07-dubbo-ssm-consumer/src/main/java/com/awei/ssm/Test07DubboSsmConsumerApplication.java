package com.awei.ssm;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class Test07DubboSsmConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Test07DubboSsmConsumerApplication.class, args);
	}

}
