package com.hjh.movie.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "writer_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
    private Movie movie;

    @Column(nullable = false)
    private Double rating;

    @Column(length = 100)
    private String comment;
}
