package com.wemoving.framework.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Description:
 *
 * @author liuning
 * @date: 2022/2/22
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.wemoving.**.mapper")
public class MybatisPlusConfig {

}