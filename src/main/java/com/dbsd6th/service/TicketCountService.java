package com.dbsd6th.service;

import com.dbsd6th.entity.TicketCount;

import java.util.List;

/**
 * *****************************************
 * **        Author : CrazyWalker         **
 * *****************************************
 * *****************************************
 * ** Date: 星期三, 12/26 2018 20:18 UTC  **
 * *****************************************
 * *****************************************
 * **   用途: 火车余票表业务逻辑层接口类  **
 * *****************************************
 */
public interface TicketCountService {

    boolean generateTicket();

    void saveTicketCountList(List<TicketCount> ticketCountList) throws Exception;
}
