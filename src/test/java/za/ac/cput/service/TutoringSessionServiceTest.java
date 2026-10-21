package za.ac.cput.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;
import za.ac.cput.repository.ITutoringSessionRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TutoringSessionServiceTest {

    @Mock
    private ITutoringSessionRepository tutoringSessionRepository;

    @InjectMocks
    private TutoringSessionService tutoringSessionService;

    @Test
    void createShouldSaveTutoringSession() {
        TutoringSession session = TutoringSession.builder().tutoringSessionId(1L).build();
        when(tutoringSessionRepository.save(session)).thenReturn(session);

        TutoringSession created = tutoringSessionService.create(session);

        assertEquals(session, created);
        verify(tutoringSessionRepository).save(session);
    }

    @Test
    void readShouldReturnTutoringSessionWhenFound() {
        TutoringSession session = TutoringSession.builder().tutoringSessionId(1L).build();
        when(tutoringSessionRepository.findById(1L)).thenReturn(Optional.of(session));

        TutoringSession found = tutoringSessionService.read(1L);

        assertEquals(session, found);
        verify(tutoringSessionRepository).findById(1L);
    }

    @Test
    void readShouldReturnNullWhenNotFound() {
        when(tutoringSessionRepository.findById(99L)).thenReturn(Optional.empty());

        TutoringSession found = tutoringSessionService.read(99L);

        assertNull(found);
        verify(tutoringSessionRepository).findById(99L);
    }

    @Test
    void updateShouldSaveTutoringSession() {
        TutoringSession session = TutoringSession.builder().tutoringSessionId(1L).build();
        when(tutoringSessionRepository.save(session)).thenReturn(session);

        TutoringSession updated = tutoringSessionService.update(session);

        assertEquals(session, updated);
        verify(tutoringSessionRepository).save(session);
    }

    @Test
    void deleteShouldDeleteTutoringSessionById() {
        tutoringSessionService.delete(1L);
        verify(tutoringSessionRepository).deleteById(1L);
    }

    @Test
    void getAllShouldReturnAllTutoringSessions() {
        List<TutoringSession> expected = List.of(
                TutoringSession.builder().tutoringSessionId(1L).build(),
                TutoringSession.builder().tutoringSessionId(2L).build()
        );
        when(tutoringSessionRepository.findAll()).thenReturn(expected);

        List<TutoringSession> actual = tutoringSessionService.getAll();

        assertEquals(expected, actual);
        verify(tutoringSessionRepository).findAll();
    }

    @Test
    void findByTutoringSessionIdShouldDelegateToRepository() {
        List<TutoringSession> expected = List.of(TutoringSession.builder().tutoringSessionId(1L).build());
        when(tutoringSessionRepository.findByTutoringSessionId(1L)).thenReturn(expected);

        List<TutoringSession> actual = tutoringSessionService.findByTutoringSessionId(1L);

        assertEquals(expected, actual);
        verify(tutoringSessionRepository).findByTutoringSessionId(1L);
    }

    @Test
    void findByTutorProfileShouldDelegateToRepository() {
        TutorProfile tutorProfile = TutorProfile.builder().tutorProfileId(1L).build();
        List<TutoringSession> expected = List.of(TutoringSession.builder().tutoringSessionId(1L).tutorProfile(tutorProfile).build());
        when(tutoringSessionRepository.findByTutorProfile(tutorProfile)).thenReturn(expected);

        List<TutoringSession> actual = tutoringSessionService.findByTutorProfile(tutorProfile);

        assertEquals(expected, actual);
        verify(tutoringSessionRepository).findByTutorProfile(tutorProfile);
    }

    @Test
    void findByStudentShouldDelegateToRepository() {
        User student = User.builder().userId(1L).build();
        List<TutoringSession> expected = List.of(TutoringSession.builder().tutoringSessionId(1L).student(student).build());
        when(tutoringSessionRepository.findByStudent(student)).thenReturn(expected);

        List<TutoringSession> actual = tutoringSessionService.findByStudent(student);

        assertEquals(expected, actual);
        verify(tutoringSessionRepository).findByStudent(student);
    }
}
