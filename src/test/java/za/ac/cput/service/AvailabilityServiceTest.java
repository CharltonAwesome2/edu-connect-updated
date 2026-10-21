package za.ac.cput.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.ac.cput.domain.Availability;
import za.ac.cput.repository.AvailabilityRepository;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AvailabilityServiceTest {

    @Mock
    private AvailabilityRepository availabilityRepository;

    @InjectMocks
    private AvailabilityService availabilityService;

    @Test
    void createShouldSaveAvailability() {
        Availability availability = Availability.builder().availibilityId(1L).build();
        when(availabilityRepository.save(availability)).thenReturn(availability);

        Availability created = availabilityService.create(availability);

        assertEquals(availability, created);
        verify(availabilityRepository).save(availability);
    }

    @Test
    void readShouldReturnAvailabilityWhenFound() {
        Availability availability = Availability.builder().availibilityId(1L).build();
        when(availabilityRepository.findById(1L)).thenReturn(Optional.of(availability));

        Availability found = availabilityService.read(1L);

        assertEquals(availability, found);
        verify(availabilityRepository).findById(1L);
    }

    @Test
    void readShouldReturnNullWhenNotFound() {
        when(availabilityRepository.findById(99L)).thenReturn(Optional.empty());

        Availability found = availabilityService.read(99L);

        assertNull(found);
        verify(availabilityRepository).findById(99L);
    }

    @Test
    void updateShouldSaveAvailability() {
        Availability availability = Availability.builder().availibilityId(1L).build();
        when(availabilityRepository.save(availability)).thenReturn(availability);

        Availability updated = availabilityService.update(availability);

        assertEquals(availability, updated);
        verify(availabilityRepository).save(availability);
    }

    @Test
    void deleteShouldDeleteAvailabilityById() {
        availabilityService.delete(1L);
        verify(availabilityRepository).deleteById(1L);
    }

    @Test
    void getAllShouldReturnAllAvailability() {
        List<Availability> expected = List.of(
                Availability.builder().availibilityId(1L).build(),
                Availability.builder().availibilityId(2L).build()
        );
        when(availabilityRepository.findAll()).thenReturn(expected);

        List<Availability> actual = availabilityService.getAll();

        assertEquals(expected, actual);
        verify(availabilityRepository).findAll();
    }

    @Test
    void getAllAvailabilityByDayOfWeekShouldDelegateToRepository() {
        DayOfWeek monday = DayOfWeek.MONDAY;
        List<Availability> expected = List.of(Availability.builder().availibilityId(1L).dayOfWeek(monday).build());
        when(availabilityRepository.findAllByDayOfWeek(monday)).thenReturn(expected);

        List<Availability> actual = availabilityService.getAllAvailabilityByDayOfWeek(monday);

        assertEquals(expected, actual);
        verify(availabilityRepository).findAllByDayOfWeek(monday);
    }
}
