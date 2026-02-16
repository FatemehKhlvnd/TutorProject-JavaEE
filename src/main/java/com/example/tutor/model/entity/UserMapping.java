package com.example.tutor.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "userMappingEntity")
@Table(name = "user_mapping_tbl")
public class UserMapping {
    @Id
    @Column(name = "u_username", nullable = false)
    private String username;

    @ManyToOne
    @JoinColumn(name = "role", nullable = false)
    private Role role;

}
