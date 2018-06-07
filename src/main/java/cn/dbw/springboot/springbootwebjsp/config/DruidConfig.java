package cn.dbw.springboot.springbootwebjsp.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource(){
        return  new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean statViewServlet(){
       ServletRegistrationBean bean=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
       Map<String,String> initParams=new HashMap<>();
       initParams.put("loginUsername","admin");
       initParams.put("loginPassword","admin");
       initParams.put("allow","");
       initParams.put("deny","192,168.0.2");
       //设置Servlet初始化参数
       bean.setInitParameters(initParams);
       return bean;
    }

    /**
     * 配置web监控filter
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean=new FilterRegistrationBean(new WebStatFilter());
        Map<String,String> initParams=new HashMap<>();
        initParams.put("exclusions","*.js,*.css,*.jpg,*.png,/druid/*");
        bean.setUrlPatterns(Arrays.asList("/*"));
        return  bean;
    }

}
