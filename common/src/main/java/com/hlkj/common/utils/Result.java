package com.hlkj.common.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    private boolean success;
    private String message;
    public Result(boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }

}
