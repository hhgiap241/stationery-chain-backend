package com.kms.giaphoang.stationerychains.controller;

import com.kms.giaphoang.stationerychains.util.ApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/17/2022, Wednesday
 * @project: stationery
 **/
public abstract class AbstractApplicationController {
    @Autowired
    protected ApplicationMapper applicationMapper;
}
