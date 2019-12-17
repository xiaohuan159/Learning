package com.jq.learning.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Component
@Data
public class UserInfoQuery{



    @NotNull(message = "账号不能为空")
    @Pattern(regexp = "[a-zA-Z]{1,10}",message = "用户名格式非法")
    private String username;

    @NotNull(message = "权限不能为空")
    @Min(value = 1, message = "权限范围为[1-99]")
    @Max(value = 99, message = "权限范围为[1-99]")
    private Long roleId;
}