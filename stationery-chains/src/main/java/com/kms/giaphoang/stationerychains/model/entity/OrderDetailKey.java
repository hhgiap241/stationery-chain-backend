package com.kms.giaphoang.stationerychains.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/19/2022, Friday
 * @project: stationery
 **/
@Embeddable
public class OrderDetailKey implements Serializable {
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "product_id")
    private Integer productId;

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final OrderDetailKey other = (OrderDetailKey) obj;
        return Objects.equals(this.orderId, other.orderId) && Objects.equals(this.productId, other.productId);
    }
}
