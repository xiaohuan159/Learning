package com.jq.learning.client;

import com.jq.learning.vo.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "DATAANALYSISSERVICE")
public interface DataAnalysisServiceClient {
    @GetMapping("/nameController/getAge/{id}")
    String getAge(@PathVariable String id);

//    @PostMapping("/nameController/getName")
    @PostMapping(value = "/nameController/getName")
    String getName(@RequestBody Student student);
}
