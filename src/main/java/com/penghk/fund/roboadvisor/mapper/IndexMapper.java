package com.penghk.fund.roboadvisor.mapper;

import com.penghk.fund.roboadvisor.entity.Index;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author:hangkong.peng
 * @Date: 2020/3/19 18:47
 */

@Mapper
public interface IndexMapper {

    Index getIndexByTsCode(String tsCode);

}
