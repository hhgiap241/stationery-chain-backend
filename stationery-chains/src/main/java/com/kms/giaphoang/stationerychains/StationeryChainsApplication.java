package com.kms.giaphoang.stationerychains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"classpath:application.yaml"})
public class StationeryChainsApplication {

    public static void main(String[] args) {
        SpringApplication.run(StationeryChainsApplication.class, args);
    }

}
