package com.cydeo.repository;

import com.cydeo.entity.Account;
import com.cydeo.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    List<Account> findByCountryOrState(String country, String state);

    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findByAgeLessThanEqual(Integer age);

    //Write a derived query to list all accounts with a specific role
    List<Account>findByRole(UserRole role);

    //Write a derived query to list all accounts between a range of ages
    List<Account> findByAgeBetween(Integer minAge, Integer maxAge);

    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account> findByAddressStartsWith(String pattern);

    //Write a derived query to sort the list of accounts with age
    List<Account> findAllByOrderByAgeDesc();


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("SELECT a FROM Account a")
    List<Account> fetchAllAccounts();

    //Write a JPQL query to list all admin accounts
    @Query("SELECT a FROM Account a WHERE a.role = 'ADMIN'")
    List<Account> fetchAllAdminAccounts();

    //Write a JPQL query to sort all accounts with age
    @Query("SELECT a FROM Account a ORDER BY a.age DESC")
    List<Account> fetchAndSortAllAccount();


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "SELECT * FROM account_details WHERE age < ?1",nativeQuery = true)
    List<Account>fetchByLowerThan(Integer age);
    //@Query(value = "SELECT * FROM account_details WHERE age < :inputAge",nativeQuery = true)
   //List<Account>fetchByLowerThan(@Param("inputAge") Integer age);

    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
    //If we change dB to Oracle it will not work because there's no ILIKE definition in Oracle but Postgres
    @Query(value = "SELECT * FROM account_details WHERE name ILIKE concat('%',?1,'%') OR" +
            " adress ILIKE concat('%',?1,'%') OR"
            +" country ILIKE concat('%',?1,'%') OR"
            +" state ILIKE concat('%',?1,'%') OR"
            +" city ILIKE concat('%',?1,'%')",nativeQuery = true)
    List<Account>containableInNameAddressCountryState(String pattern);
    //if dB is other than Postgres you can use below:
    @Query(value = "SELECT * FROM account_details WHERE LOWER(name) LIKE LOWER(concat('%',?1,'%')) OR" +
            " LOWER(adress) LIKE LOWER(concat('%',?1,'%')) OR"
            +" LOWER(country) LIKE LOWER(concat('%',?1,'%')) OR"
            +" LOWER(state) LIKE LOWER(concat('%',?1,'%')) OR"
            +" LOWER(city) LIKE LOWER(concat('%',?1,'%'))",nativeQuery = true)
    List<Account>containableInNameAddressCountryState2(String pattern);


}
