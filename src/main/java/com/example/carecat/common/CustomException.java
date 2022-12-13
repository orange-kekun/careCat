package com.example.carecat.common;

import org.springframework.remoting.RemoteTimeoutException;

/**
 * 自定义异常
 * @author 200111124
 */
public class CustomException extends RemoteTimeoutException {
    public CustomException(String msg) {
        super(msg);
    }
}
