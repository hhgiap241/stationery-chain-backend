package com.kms.giaphoang.stationerychains.exception;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/18/2022, Thursday
 * @project: stationery
 **/
public class UserExistedException extends RuntimeException{
    public UserExistedException(String message){
        super(message);
    }
}
