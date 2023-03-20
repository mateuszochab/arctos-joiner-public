package com.analitiker.arctos.arctosjoinerpublic.service.impl;

import com.analitiker.arctos.arctosjoinerpublic.service.DateService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class DateServiceImpl implements DateService {

    @Override
    public ZonedDateTime generateDatePlusOneDay() {
        return ZonedDateTime.of(LocalDateTime.now().plusDays(1), ZoneId.of("Europe/Copenhagen"));
    }
}
