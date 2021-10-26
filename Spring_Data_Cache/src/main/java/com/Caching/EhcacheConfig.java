package com.Caching;


import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableCaching
//@EnableJpaRepositories(basePackages = "com.repository")
public class EhcacheConfig {

}
