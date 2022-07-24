package com.sonpt.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "status")
@Data
public class Statuses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status_name")
    private String statusName;
}
