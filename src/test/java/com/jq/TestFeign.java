package com.jq;

import com.jq.learning.LearningApplication;
import com.jq.learning.client.DataAnalysisServiceClient;
import com.jq.learning.vo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LearningApplication.class)
public class TestFeign {
    @Autowired
    DataAnalysisServiceClient dataAnalysisServiceClient;
    @Test
    public void test1(){
        String jwx813858 = dataAnalysisServiceClient.getAge("jwx813858");
        System.out.println(jwx813858);
    }


    @Test
    public void test2(){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("id", "jwx813858");
        Student student = new Student();
        student.setId("jwx813858");
        String jwx813858 = dataAnalysisServiceClient.getName(student);
        System.out.println(jwx813858);
    }
}
