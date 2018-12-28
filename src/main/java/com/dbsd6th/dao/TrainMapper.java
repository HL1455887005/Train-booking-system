package com.dbsd6th.dao;

import com.dbsd6th.entity.Train;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainMapper {
    int deleteByPrimaryKey(Integer id);

    //增加车次信息1
    int insert(Train record);

    //增加车次信息2
    int insertSelective(Train record);

    //根据车次id查询车次信息
    Train selectByPrimaryKey(Integer id);

    //更改车次信息1
    int updateByPrimaryKeySelective(Train record);

    //更改车次信息2
    int updateByPrimaryKey(Train record);

    //根据trainNum（列车号）来获得车次信息
    Train selectByTrainNum(String trainNum);

    List<Train> selectAll();
}