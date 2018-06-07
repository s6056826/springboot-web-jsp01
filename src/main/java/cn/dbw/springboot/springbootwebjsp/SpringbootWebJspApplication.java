package cn.dbw.springboot.springbootwebjsp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(value = "cn.dbw.springboot.springbootwebjsp.mapper")
@SpringBootApplication
public class SpringbootWebJspApplication {

	public static void main(String[] args) {
		System.err.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		SpringApplication.run(SpringbootWebJspApplication.class, args);
	}
}
