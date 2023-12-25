package com.cydeo.bootstrap;

import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {
    private final RegionRepository regionRepository;

    public DataGenerator(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("---------REGION START--------------");
        System.out.println("find by country: " + regionRepository.findByCountry("Canada"));
        System.out.println("Display all regions in Canada, without duplicates"+  regionRepository.findDistinctTopByCountry("Canada"));
        System.out.println("display all regions with country name includes 'United'"+regionRepository.findByCountryContains("United"));
        System.out.println("findByCountryContainsOrderByCountry" + regionRepository.findByCountryContainsOrderByCountry("Asia"));
        System.out.println("findTop2ByCountry:" + regionRepository.findTop2ByCountry("Canada"));

        System.out.println("---------REGION END--------------");


    }
}
