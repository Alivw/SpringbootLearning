package com.awei.ssm;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.awei.ssm.mapper")
@EnableDubboConfiguration
public class Test06DubboSsmProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(Test06DubboSsmProviderApplication.class, args);
	}

}
