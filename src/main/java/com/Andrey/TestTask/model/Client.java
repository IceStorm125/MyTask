package com.Andrey.TestTask.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name = "client")
@Entity
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String firstName;
    private String lastName;
    private String tel_no;
    private String homeAddress;

    @OneToMany(mappedBy = "client",fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Visit> visits;
}
