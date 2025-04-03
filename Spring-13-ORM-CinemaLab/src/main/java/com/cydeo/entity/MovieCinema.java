package com.cydeo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MovieCinema extends BaseEntity{
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    //people usually put ManyToOne Relationship (NOT!! OneToMany)
    private Movie movie;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cinema cinema;

    @Override
    public String toString() {
        return "MovieCinema{" +
                "dateTime=" + dateTime +
                '}';
    }
}
