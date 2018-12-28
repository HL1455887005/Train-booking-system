package com.dbsd6th.dao;

import com.dbsd6th.entity.TicketCount;
import com.dbsd6th.entity.Train;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface TicketCountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TicketCount record);

    int insertSelective(TicketCount record);

    TicketCount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TicketCount record);

    int updateByPrimaryKey(TicketCount record);

    /*根据列车id和具体日期进行余票查询*/
    TicketCount searchTicket(HashMap<String, Object> condition);

    /*选择座位类型(总票数-1，座位类型票数-1)*/
    int minusBySeatLevel(HashMap<String, Object> condition);

    /*将ticket_count表相应记录的(总票数+1,座位类型票数+1*/
    int addByOrderTicket(HashMap<String,Object> condition);

    /*根据trainId以及order_time来获得记录*/
    TicketCount searchTicket2(Integer trainId ,Date orderTime);

    Set<Date> selectAllGroupByTime(Map<String, Date> condition);

    Boolean insertBatch(List<TicketCount> ticketCountList);

}