package com.dbsd6th.controller;

import com.dbsd6th.entity.TrainAndTicket;
import com.dbsd6th.service.SearchTicketService;
import com.dbsd6th.util.DateUtil;
import com.dbsd6th.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * *****************************************
 * **        Author : CrazyWalker         **
 * *****************************************
 * *****************************************
 * ** Date: 星期二, 12/18 2018 20:59 UTC  **
 * *****************************************
 * *****************************************
 * **      用途: 车次信息表控制层         **
 * *****************************************
 */
@Controller
public class TrainController {

    @Autowired
    private SearchTicketService searchTicketService;

    /**
     * 根据出发站、目的站和出发日期查询符合条件的车次
     * (包含标准查询和中转站查询)
     * @author CrazyWalker
     * @param session http session
     * @param beginStation 出发地站点名称
     * @param targetStation 目的地站点名称
     * @param targetDate 出发日期
     * @param flag 查询标志 是否为高级查询
     * @return 无论是否成功均返回到信息查询页，若成功查询则返回对应数据
     */
    @RequestMapping(path = "/ticketSearch", method = RequestMethod.POST)
    public String ticketSearch(HttpSession session, String beginStation, String targetStation,
                               String targetDate, Integer flag) {
        /*三者值均不能为空*/
        if(StringUtil.isEmpty(beginStation) || StringUtil.isEmpty(targetDate) ||
                StringUtil.isEmpty(targetStation)) {
            if (flag == 1) {
                return "tots/advancedsearch";
            } else {
                return "tots/searchTicket";
            }
        }

        Date tDate = DateUtil.transFormDateToDate(targetDate);
        if (tDate != null) {
            List<TrainAndTicket> trainAndTicketList =
                    searchTicketService.getTrainAndTicketList(beginStation, targetStation, tDate, flag);
            if (flag == 1) {
                session.setAttribute("adtatList", trainAndTicketList);
                session.setAttribute("isAdPostResponse", true);
            } else {
                session.setAttribute("tatList", trainAndTicketList);
                session.setAttribute("isPostResponse", true);
            }

        }

        if (flag == 1) {
            return "tots/advancedsearch";
        } else {
            return "tots/searchTicket";
        }
    }
}
