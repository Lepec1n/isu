package com.isu.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "literature_request")
@Getter
@Setter
public class LiteratureRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "literature_request_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "literature_id")
    private Literature literature;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
