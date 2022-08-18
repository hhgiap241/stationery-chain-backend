package com.kms.giaphoang.stationerychains.model.dto;

import com.kms.giaphoang.stationerychains.model.entity.OrderDetail;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/18/2022, Thursday
 * @project: stationery
 **/
@Data
@Builder
public class OrderDto {
    private Integer id;
    @Min(0)
    private Double totalPrice;
    @Min(0)
    private Double shippingPrice;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    @NotBlank(message = "User id is required")
    private String userId;
    private Set<OrderDetail> orderDetails;
}
