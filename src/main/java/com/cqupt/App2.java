package com.cqupt;

import com.cqupt.config.SpringConfig;
import com.cqupt.service.AccountService;
import com.cqupt.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App2 {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = ctx.getBean(AccountService.class);
        System.out.println(accountService.findById(2));

    }
}
