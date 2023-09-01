package com.zaggle.xpns.admin.authentication.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGeneratorAuth")
    @SequenceGenerator(name = "sequenceGeneratorAuth",allocationSize = 1,initialValue = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String userName;
    private String mobileNumber;
    private String email;
    private String userFirstName;
    private String userLastName;
    private String userPassword;
    private String confirmPassword;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(	name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

}
