package com.jq.learning.controller;

import com.alibaba.fastjson.JSONObject;
import com.jq.learning.bean.UserInfoQuery;
import com.jq.learning.client.DataAnalysisServiceClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping("JackSonController")
public class JackSonController {
    Log logger = LogFactory.getLog(JackSonController.class);
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DataAnalysisServiceClient dataAnalysisServiceClient;


    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public Object testJackSon(@RequestBody JSONObject hehe) {

        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("01", hehe.getString("name"));
        String serviceId = "DATAANALYSISSERVICE";
//        String forObject = restTemplate.getForObject("http://DataAnalysisService/nameController/getName?id=jwx813858", String.class);
//        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://"+serviceId+"/nameController/getName?id=jwx813858", String.class);
//        String body = forEntity.getBody();
        String body = dataAnalysisServiceClient.getAge("jwx813858");

        stringStringHashMap.put("name", body);

        try {
            int x = 3/0;
            System.out.println(x);
        } catch (Exception e) {
            logger.error("出错啦",e);
        }
        return stringStringHashMap;
    }

    @GetMapping("/query")
    public Object list(@Valid UserInfoQuery userInfo, BindingResult result) {
//        if (result.hasErrors()) {
//            FieldError error = result.getFieldError();
//            assert error != null;
//            return Return.error(error.getField(), error.getDefaultMessage());
//        }

        return userInfo.getRoleId()+userInfo.getUsername();
    }
}
