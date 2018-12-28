package com.dbsd6th.controller;

import com.dbsd6th.entity.TicketCount;
import com.dbsd6th.service.TicketCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * *****************************************
 * **        Author : CrazyWalker         **
 * *****************************************
 * *****************************************
 * ** Date: 星期四, 12/27 2018 12:09 UTC  **
 * *****************************************
 * *****************************************
 * **     用途: TicketCount表控制类       **
 * *****************************************
 */
@Controller
public class TicketCountController {

    @Autowired
    private TicketCountService ticketCountService;

    @RequestMapping(path = "/refreshticket", method = RequestMethod.GET)
    public String refreshTicket() {
        ticketCountService.generateTicket();

        return "admin/form-amazeui";
    }
}
