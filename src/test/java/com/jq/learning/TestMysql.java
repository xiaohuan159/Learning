package com.jq.learning;

import com.google.common.collect.Lists;
import com.jq.learning.bean.NeInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest(classes = LearningApplication.class)
@RunWith(SpringRunner.class)
public class TestMysql {
    @Autowired
    JdbcTemplate jdbcTemplate;
//
//    @Test
//    public void test(){
//        for (Object o :  ) {
//
//        }
//    }
    //采用jdbctemplate的batchUpdate方法,10000条864ms
    @Test
    public void test2(){
        long start = System.currentTimeMillis();
        StringBuilder sql = new StringBuilder();
        sql.append("insert into neinfo (id,countryCode,cityCode,operatorCode,neName,neType,layer,coorX,coory) values (?,?,?,?,?,?,?,?,?)");
        ArrayList<NeInfo> userNeInfos = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            userNeInfos.add(new NeInfo("hehe"+i,"haha",300.1,400.1,"L3"));
        }
        List<List<NeInfo>> partition = Lists.partition(userNeInfos, 2000);
        for (List<NeInfo> neInfos : partition) {
            jdbcTemplate.batchUpdate(sql.toString(),transform(neInfos));
        }
        System.out.println(System.currentTimeMillis()-start);

    }

    //将neInfos中每一个NeInfo转换为object[]数组
    private List<Object[]> transform(List<NeInfo> neInfos) {
        return neInfos.stream().map(neInfo -> new Object[]{
                neInfo.getId(), neInfo.getCountryCode(), neInfo.getCityCode(), neInfo.getOperatorCode()
                , neInfo.getNeName(), neInfo.getNeType(), neInfo.getLayer(), neInfo.getCoorX(), neInfo.getCoorY()
        }).collect(Collectors.toList());
    }

}
