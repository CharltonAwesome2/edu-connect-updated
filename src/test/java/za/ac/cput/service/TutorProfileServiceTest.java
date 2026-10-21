package za.ac.cput.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.User;
import za.ac.cput.repository.ITutorProfileRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TutorProfileServiceTest {

    @Mock
    private ITutorProfileRepository tutorProfileRepository;

    @InjectMocks
    private TutorProfileService tutorProfileService;

    @Test
    void createShouldSaveTutorProfile() {
        TutorProfile tutorProfile = TutorProfile.builder().tutorProfileId(1L).build();
        when(tutorProfileRepository.save(tutorProfile)).thenReturn(tutorProfile);

        TutorProfile created = tutorProfileService.create(tutorProfile);

        assertEquals(tutorProfile, created);
        verify(tutorProfileRepository).save(tutorProfile);
    }

    @Test
    void readShouldReturnTutorProfileWhenFound() {
        TutorProfile tutorProfile = TutorProfile.builder().tutorProfileId(1L).build();
        when(tutorProfileRepository.findById(1L)).thenReturn(Optional.of(tutorProfile));

        TutorProfile found = tutorProfileService.read(1L);

        assertEquals(tutorProfile, found);
        verify(tutorProfileRepository).findById(1L);
    }

    @Test
    void readShouldReturnNullWhenNotFound() {
        when(tutorProfileRepository.findById(99L)).thenReturn(Optional.empty());

        TutorProfile found = tutorProfileService.read(99L);

        assertNull(found);
        verify(tutorProfileRepository).findById(99L);
    }

    @Test
    void updateShouldSaveTutorProfile() {
        TutorProfile tutorProfile = TutorProfile.builder().tutorProfileId(1L).build();
        when(tutorProfileRepository.save(tutorProfile)).thenReturn(tutorProfile);

        TutorProfile updated = tutorProfileService.update(tutorProfile);

        assertEquals(tutorProfile, updated);
        verify(tutorProfileRepository).save(tutorProfile);
    }

    @Test
    void deleteShouldDeleteTutorProfileById() {
        tutorProfileService.delete(1L);
        verify(tutorProfileRepository).deleteById(1L);
    }

    @Test
    void getAllShouldReturnAllTutorProfiles() {
        List<TutorProfile> expected = List.of(
                TutorProfile.builder().tutorProfileId(1L).build(),
                TutorProfile.builder().tutorProfileId(2L).build()
        );
        when(tutorProfileRepository.findAll()).thenReturn(expected);

        List<TutorProfile> actual = tutorProfileService.getAll();

        assertEquals(expected, actual);
        verify(tutorProfileRepository).findAll();
    }

    @Test
    void findByTutorProfileIdShouldDelegateToRepository() {
        List<TutorProfile> expected = List.of(TutorProfile.builder().tutorProfileId(1L).build());
        when(tutorProfileRepository.findByTutorProfileId(1L)).thenReturn(expected);

        List<TutorProfile> actual = tutorProfileService.findByTutorProfileId(1L);

        assertEquals(expected, actual);
        verify(tutorProfileRepository).findByTutorProfileId(1L);
    }

    @Test
    void findByUserShouldDelegateToRepository() {
        User user = User.builder().userId(1L).build();
        List<TutorProfile> expected = List.of(TutorProfile.builder().tutorProfileId(1L).user(user).build());
        when(tutorProfileRepository.findByUser(user)).thenReturn(expected);

        List<TutorProfile> actual = tutorProfileService.findByUser(user);

        assertEquals(expected, actual);
        verify(tutorProfileRepository).findByUser(user);
    }
}
