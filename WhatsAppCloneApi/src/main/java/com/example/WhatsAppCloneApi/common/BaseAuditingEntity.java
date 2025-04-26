package com.example.WhatsAppCloneApi.common;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.cglib.core.internal.LoadingCache;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.jmx.export.annotation.ManagedAttribute;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseAuditingEntity {
    @CreatedDate
    @Column(name = "created_date" ,nullable = false ,
    updatable = false)
    private LocalDateTime createdDate;
    @LastModifiedDate
    @Column(name ="last_modified_date" ,insertable = false)
    private LocalDateTime lastModifiedDate;



}
