package com.isu.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "rings")
public class Ring {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ring_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
