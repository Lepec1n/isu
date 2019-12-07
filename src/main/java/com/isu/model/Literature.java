package com.isu.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "literature")
public class Literature {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "literature_id")
    private Long id;

    @NotEmpty(message = "*Введите название магического труда")
    private String name;

    @NotEmpty(message = "*Введите описание магического труда")
    private String preview;

    private Boolean givenOut;
}
