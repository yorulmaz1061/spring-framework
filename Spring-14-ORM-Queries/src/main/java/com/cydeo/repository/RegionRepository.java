package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {
    //Requirement is-> display all regions in Canada
    List<Region>findByCountry(String country);
    //It means that SELECT * FROM REGION WHERE COUNTRY IS ...

    //Display all regions in Canada, without duplicates
    List<Region>findDistinctTopByCountry(String country);

    //display all regions with country name includes 'United'
    List<Region>findByCountryContains(String country);

    //Display all regions with country name includes 'Asia' in order
    List<Region>findByCountryContainsOrderByCountry(String country);

    //Display top 2 regions in Canada
    List<Region>findTop2ByCountry(String country);


}
