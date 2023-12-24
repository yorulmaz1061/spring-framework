package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class MovieCinema extends BaseEntity{
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime DateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    //people usualy put ManyToOne Relationship
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cinema cinema;


}
