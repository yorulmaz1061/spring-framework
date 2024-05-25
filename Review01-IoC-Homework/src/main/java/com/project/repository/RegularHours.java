package com.project.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Qualifier("RH")
//@Primary
// if you ut @Primary to RegularHours it ignores other imp class of hours repository interface (overtime hours).
@Component
public class RegularHours implements HoursRepository{
    @Override
    public int getHours() {
        return 40;
    }
}
