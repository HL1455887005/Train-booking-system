package com.dbsd6th.service.impl;

import com.dbsd6th.service.TicketCountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * *****************************************
 * **        Author : CrazyWalker         **
 * *****************************************
 * *****************************************
 * ** Date: 星期四, 12/27 2018 11:12 UTC  **
 * *****************************************
 * *****************************************
 * **     用途:        **
 * *****************************************
 */
public class TicketCountServiceImplTest {

    private ApplicationContext applicationContext;
    private TicketCountService ticketCountService;


    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        //加载spring配置文件

        ticketCountService = applicationContext.getBean(TicketCountService.class);
        //在这里导入要测试的
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    /*测试查票逻辑（将车次信息+余票信息整合并传给前端）*/
    public void getTrainAndTicketList() throws Exception{
        ticketCountService.generateTicket();
    }
}