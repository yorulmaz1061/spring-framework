package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.entity.Ticket;
import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought id
    Integer countTicketByUserAccountId(Long userId);

    //Write a derived query to list all tickets by specific email
    List<Ticket> findByUserAccount_Email(String email);

    //Write a derived query to count how many tickets are sold for a specific movie
    Integer countAllByMovieCinema_Movie_Name(String name);

    //Write a derived query to list all tickets between a range of dates
    List<Ticket> findAllByDateTimeBetween(LocalDateTime start, LocalDateTime end);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("SELECT t from Ticket t WHERE t.userAccount.id=?1")
    List<Ticket>findBySpecificUser(Long userId);

    //Write a JPQL query that returns all tickets between a range of dates
    @Query("SELECT t from Ticket t WHERE t.movieCinema.DateTime BETWEEN ?1 AND ?2")
    List<Ticket>findTicketByRangeBetween(LocalDateTime start, LocalDateTime end);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought
    @Query(value = "SELECT count(*) FROM ticket  WHERE user_account_id = ?1",nativeQuery = true)
    Optional<Integer> countTicketBoughtByUser(Long userId);

    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value = "SELECT COUNT(*) FROM ticket WHERE user_account_id = ?1 AND date_time BETWEEN ?2 AND ?3",nativeQuery = true)
    Integer countTicketUserBoughtRange(Long userId, LocalDateTime start, LocalDateTime end);

    //Write a native query to distinct all tickets by movie name
    @Query(value = "SELECT DISTINCT m.name FROM ticket t JOIN movie_cinema mc ON t.movie_cinema_id=mc.id JOIN movie m ON mc.movie_id=m.id",nativeQuery = true)
    List<String> findDistinctTicketByMovieName();

    //Write a native query to find all tickets by user email
    @Query(value = "SELECT * FROM ticket t JOIN user_account u ON t.user_account_id = u.id WHERE u.email=?1",nativeQuery = true)
    List<Ticket> findByUserEmail(String email);

    //Write a native query that returns all tickets
    @Query(value = "SELECT * FROM ticket",nativeQuery = true)
    List<Ticket> findAllTickets();

    //Write a native query to list all tickets where a specific value should be containable in the username or account name or movie name
    @Query(value = "SELECT * FROM ticket t JOIN user_account ua ON t.user_account_id = ua.id "
    +"JOIN account_details ad ON ua.account_details_id = ad.id "
    +"JOIN movie_cinema mc ON t.movie_cinema_id=mc.id JOIN movie m ON mc.movie_id = m.id"
            + " WHERE ua.username ILIKE concat('%',?1,'%')"
            + " OR ad.name ILIKE concat('%',?1,'%')\"
            + " OR m.name ILIKE concat('%',?1,'%')"
            ,nativeQuery = true)
    List<Ticket> findBySpecificName(String pattern);

}
