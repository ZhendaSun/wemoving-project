package com.wemoving;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wemoving
 */
@SpringBootApplication
@MapperScan("com.wemoving.**.mapper")
public class WemovingProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(WemovingProjectApplication.class, args);
        printKeyLoadMessage();
    }

    /**
     * 获取Key加载信息
     */
    public static void printKeyLoadMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("\r\n======================================================================\r\n");
        sb.append("\r\n    欢迎使用成员招聘管理系统 - https://www.wemoving.com\r\n");
        sb.append("\r\n======================================================================\r\n");
        System.out.println(sb);
    }


}
