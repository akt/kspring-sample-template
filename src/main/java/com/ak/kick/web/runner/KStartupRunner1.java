package com.ak.kick.web.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by ak on 7/6/17.
 */
@Component
@Order(value=1)
public class KStartupRunner1 implements CommandLineRunner{

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作 1111111111<<<<<<<<<<<<<");
    }

}
