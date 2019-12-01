package com.isu.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "literature_request")
public class LiteratureRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "literature_request_id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "literature")
    private Literature literature;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private User user;
}
