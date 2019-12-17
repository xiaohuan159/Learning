package com.jq.learning.exception;

import com.jq.learning.bean.Return;
import lombok.Data;

@Data
public class UserInfoException extends RuntimeException {
    private Return r;

    public UserInfoException(Return r) {
        this.r = r;
    }
}