package za.ac.cput.service;

import java.time.DayOfWeek;
import java.util.List;

import za.ac.cput.domain.Availability;

public interface IAvailabilityService extends service<Availability, Long> {
    List<Availability> getAllAvailabilityByDayOfWeek(DayOfWeek dayOfWeek);
}
