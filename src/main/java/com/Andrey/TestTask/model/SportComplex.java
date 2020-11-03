package com.Andrey.TestTask.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name = "sport_complex")
@Entity
@Data
public class SportComplex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

    @ManyToOne
    @JoinColumn(name = "type_of_complex_id",referencedColumnName = "id")
    @JsonBackReference
    private TypeOfComplex typeOfComplex;

    @OneToMany(mappedBy = "sportComplex")
    @JsonBackReference
    private List<Visit> visits;
}
