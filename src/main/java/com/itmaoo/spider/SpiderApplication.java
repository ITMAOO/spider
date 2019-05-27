package com.itmaoo.spider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@SpringBootApplication
@ComponentScan(basePackages = {"com.itmaoo.spider"})
@EnableResourceServer
public class SpiderApplication extends ResourceServerConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(SpiderApplication.class, args);
	}

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers(
                        "/search/stock/**"
                ).permitAll()
                .anyRequest().authenticated();
    }
}
