package com.penghk.fund.roboadvisor.mapper;

import com.penghk.fund.roboadvisor.entity.Index;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author:hangkong.peng
 * @Date: 2020/3/19 19:47
 */

@SpringBootTest
public class IndexTest {

    @Autowired
    IndexMapper indexMapper;

    @Test
    public void find() {
        Index index = indexMapper.getIndexByTsCode("000300");
        System.out.println(index);
    }

}
