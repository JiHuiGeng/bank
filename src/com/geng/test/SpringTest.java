package com.geng.test;

import com.geng.pojo.Account;
import com.geng.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring框架测试
 */
public class SpringTest {
    public static void main(String[] args) {
        //首先加载applicationContext.xml文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        System.out.println("Spring创建对象成功:" + accountService.selectAll());
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println("获取的beanName:"+name);
        }
    }
}
