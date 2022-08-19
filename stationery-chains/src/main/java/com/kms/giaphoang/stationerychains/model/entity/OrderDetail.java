package com.kms.giaphoang.stationerychains.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/18/2022, Thursday
 * @project: stationery
 **/
@Entity
@Table(name = "order_detail")
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    @EmbeddedId
    private OrderDetailKey id;

    private Double price;
    private Integer quantity;
    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(name = "last_modified_date")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;
}
