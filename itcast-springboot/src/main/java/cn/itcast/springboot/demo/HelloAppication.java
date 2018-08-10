package cn.itcast.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller//表明这是一个springmvc的controller的控制器
@SpringBootApplication //springboot项目的核心注解:主要目的开启自动配置
@Configuration//这个是spring的一个配置类
public class HelloAppication {
	@RequestMapping("hello")
	@ResponseBody
	public String hello() {
		return "hello";
	}
public static void main(String[] args) {
	SpringApplication.run(HelloAppication.class, args);
}
}
