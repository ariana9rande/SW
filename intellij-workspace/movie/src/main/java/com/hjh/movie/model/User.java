package com.hjh.movie.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable=false)
    private String username;

    @Column(length = 20, nullable=false)
    private String password;

    @Column(length = 20, nullable=false)
    private String nickname;

    @Column(columnDefinition = "int default 1")
    private int role;
}
