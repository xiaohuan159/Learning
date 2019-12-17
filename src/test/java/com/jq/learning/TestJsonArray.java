package com.jq.learning;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jq.learning.bean.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = LearningApplication.class)
@RunWith(SpringRunner.class)
public class TestJsonArray {

    @Test
    public void test(){
        ArrayList<Student> array = new ArrayList<Student>();
        array.add(new Student("张三","长春",23));
        array.add(new Student("李四","上海",24));
        array.add(new Student("王五","北京",25));
        List<Student> students = JSONObject.parseArray(JSON.toJSONString(array), Student.class);
        for (Student student : students) {
            System.out.println(student);
        }

    }
}
