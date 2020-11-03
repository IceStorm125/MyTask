package com.Andrey.TestTask.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name = "type_of_complex")
@Entity
@Data
public class TypeOfComplex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String typeName;

    @OneToMany(mappedBy = "typeOfComplex",cascade = CascadeType.ALL)
    private List<SportComplex> sportComplexes;

}
