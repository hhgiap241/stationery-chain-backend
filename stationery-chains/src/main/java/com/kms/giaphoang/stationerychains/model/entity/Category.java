package com.kms.giaphoang.stationerychains.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/17/2022, Wednesday
 * @project: stationery
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
@EntityListeners(AuditingEntityListener.class)
public class Category {
    @Id
    @SequenceGenerator(name = "category_seq", sequenceName = "category_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    private String id;
    private String name;
    @CreatedDate
    @Column(name = "created_date")
    private String createdAt;
    @LastModifiedDate
    @Column(name = "last_modified_date")
    private String updatedAt;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Set<Product> products;
}
