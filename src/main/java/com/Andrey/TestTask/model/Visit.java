package com.Andrey.TestTask.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "visits")
@Entity
@Data
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "sport_complex_id")
    private SportComplex sportComplex;

    @Column(name = "visit_date")
    private Date visitDate;

}
