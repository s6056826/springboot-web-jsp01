package cn.dbw.springboot.springbootwebjsp.config;

import cn.dbw.springboot.springbootwebjsp.utils.SpringContextUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class myConfig {

    @Bean
    public SpringContextUtils springContextUtils(){
        return new SpringContextUtils();
    }
}
