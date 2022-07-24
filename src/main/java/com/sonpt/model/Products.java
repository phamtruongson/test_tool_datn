package com.sonpt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Products implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subcate_id")
    private Long subcateId;

    @Column(name = "produce_name")
    private String produceName;

    @Column(name = "color")
    private String color;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "sell_price")
    private double sellPrice;

    @Column(name = "origin_price")
    private double originPrice;

    @Column(name = "description")
    private String description;

    @Column(name = "status_id")
    private Long statusId;
}