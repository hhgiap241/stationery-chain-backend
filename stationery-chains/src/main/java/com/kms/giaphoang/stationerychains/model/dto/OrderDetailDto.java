package com.kms.giaphoang.stationerychains.model.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/19/2022, Friday
 * @project: stationery
 **/
@Data
@Builder
public class OrderDetailDto {
    private Integer orderId;
    private Integer productId;
    private Double price;
    private Integer quantity;
}
