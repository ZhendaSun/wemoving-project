package wemove;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wemoving
 */
@SpringBootApplication
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
        sb.append("\r\n    欢迎使用管理系统 - https://www.yellow.com\r\n");
        sb.append("\r\n======================================================================\r\n");
        System.out.println(sb);
    }


}
