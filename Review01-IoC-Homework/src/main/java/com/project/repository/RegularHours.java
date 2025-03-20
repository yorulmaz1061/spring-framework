package com.project.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
//What is the point of @Qualifier?
@Qualifier("RH")
//@Primary
// if you put @Primary to RegularHours it ignores other imp class of hours repository interface (overtime hours).
@Component
//Why we put @Component? because it implements Hours Repository which we use in SalaryService
public class RegularHours implements HoursRepository{
    @Override
    public int getHours() {
        return 40;
    }
}
