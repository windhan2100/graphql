package com.hanchao.graphql.graphql.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author hanliwei
 * @create 2019-02-12 17:18
 */
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {


    /** ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint", nullable = false)
    protected Long id;

    /** 创建时间戳 (单位:秒) */
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdTime;

    /** 更新时间戳 (单位:秒) */
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updatedTime;


    public BaseEntity() {
        createdTime = new Date();
        updatedTime = createdTime;
    }

    @PreUpdate
    private void doPreUpdate() {
        updatedTime = new Date();
    }

}
