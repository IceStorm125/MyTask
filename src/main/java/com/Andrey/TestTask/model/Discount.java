package com.Andrey.TestTask.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "discount")
@Data
public class Discount {

    @Id
    @Column(name = "client_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "client_id")
    private Client client;

    private Double discountFactor;

}
