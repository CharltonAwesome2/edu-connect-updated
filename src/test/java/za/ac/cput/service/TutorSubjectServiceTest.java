package za.ac.cput.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutorSubject;
import za.ac.cput.repository.ITutorSubjectRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TutorSubjectServiceTest {

    @Mock
    private ITutorSubjectRepository tutorSubjectRepository;

    @InjectMocks
    private TutorSubjectService tutorSubjectService;

    @Test
    void createShouldSaveTutorSubject() {
        TutorSubject tutorSubject = TutorSubject.builder().tutorSubjectId(1L).build();
        when(tutorSubjectRepository.save(tutorSubject)).thenReturn(tutorSubject);

        TutorSubject created = tutorSubjectService.create(tutorSubject);

        assertEquals(tutorSubject, created);
        verify(tutorSubjectRepository).save(tutorSubject);
    }

    @Test
    void readShouldReturnTutorSubjectWhenFound() {
        TutorSubject tutorSubject = TutorSubject.builder().tutorSubjectId(1L).build();
        when(tutorSubjectRepository.findById(1L)).thenReturn(Optional.of(tutorSubject));

        TutorSubject found = tutorSubjectService.read(1L);

        assertEquals(tutorSubject, found);
        verify(tutorSubjectRepository).findById(1L);
    }

    @Test
    void readShouldReturnNullWhenNotFound() {
        when(tutorSubjectRepository.findById(99L)).thenReturn(Optional.empty());

        TutorSubject found = tutorSubjectService.read(99L);

        assertNull(found);
        verify(tutorSubjectRepository).findById(99L);
    }

    @Test
    void updateShouldSaveTutorSubject() {
        TutorSubject tutorSubject = TutorSubject.builder().tutorSubjectId(1L).build();
        when(tutorSubjectRepository.save(tutorSubject)).thenReturn(tutorSubject);

        TutorSubject updated = tutorSubjectService.update(tutorSubject);

        assertEquals(tutorSubject, updated);
        verify(tutorSubjectRepository).save(tutorSubject);
    }

    @Test
    void deleteShouldDeleteTutorSubjectById() {
        tutorSubjectService.delete(1L);
        verify(tutorSubjectRepository).deleteById(1L);
    }

    @Test
    void getAllShouldReturnAllTutorSubjects() {
        List<TutorSubject> expected = List.of(
                TutorSubject.builder().tutorSubjectId(1L).build(),
                TutorSubject.builder().tutorSubjectId(2L).build()
        );
        when(tutorSubjectRepository.findAll()).thenReturn(expected);

        List<TutorSubject> actual = tutorSubjectService.getAll();

        assertEquals(expected, actual);
        verify(tutorSubjectRepository).findAll();
    }

    @Test
    void findByTutorSubjectIdShouldDelegateToRepository() {
        List<TutorSubject> expected = List.of(TutorSubject.builder().tutorSubjectId(1L).build());
        when(tutorSubjectRepository.findByTutorSubjectId(1L)).thenReturn(expected);

        List<TutorSubject> actual = tutorSubjectService.findByTutorSubjectId(1L);

        assertEquals(expected, actual);
        verify(tutorSubjectRepository).findByTutorSubjectId(1L);
    }

    @Test
    void findByTutorProfileShouldDelegateToRepository() {
        TutorProfile tutorProfile = TutorProfile.builder().tutorProfileId(1L).build();
        List<TutorSubject> expected = List.of(TutorSubject.builder().tutorSubjectId(1L).tutorProfile(tutorProfile).build());
        when(tutorSubjectRepository.findByTutorProfile(tutorProfile)).thenReturn(expected);

        List<TutorSubject> actual = tutorSubjectService.findByTutorProfile(tutorProfile);

        assertEquals(expected, actual);
        verify(tutorSubjectRepository).findByTutorProfile(tutorProfile);
    }

    @Test
    void findBySubjectShouldDelegateToRepository() {
        Subject subject = Subject.builder().subjectId(1L).build();
        List<TutorSubject> expected = List.of(TutorSubject.builder().tutorSubjectId(1L).subject(subject).build());
        when(tutorSubjectRepository.findBySubject(subject)).thenReturn(expected);

        List<TutorSubject> actual = tutorSubjectService.findBySubject(subject);

        assertEquals(expected, actual);
        verify(tutorSubjectRepository).findBySubject(subject);
    }
}
