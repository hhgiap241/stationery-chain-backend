package com.kms.giaphoang.stationerychains.model.entity;

import com.kms.giaphoang.stationerychains.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/12/2022, Friday
 * @project: stationery
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "_user")
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    private String id;
    private String username;
    private String email;
    private String address;
    private String phone;
    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(name = "last_modified_date")
    private LocalDateTime updatedAt;
    private String role;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Order> orders;
}
