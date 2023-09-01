package com.zaggle.xpns.admin.authentication.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGeneratorAuth")
    @SequenceGenerator(name = "sequenceGeneratorAuth",allocationSize = 1,initialValue = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 120)
    private String name;

}
