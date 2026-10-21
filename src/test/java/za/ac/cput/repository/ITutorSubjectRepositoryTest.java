package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Subject;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutorSubject;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ITutorSubjectRepositoryTest {

    @Test
    void shouldExtendJpaRepository() {
        assertTrue(JpaRepository.class.isAssignableFrom(ITutorSubjectRepository.class));
    }

    @Test
    void shouldDeclareFindByTutorSubjectId() throws NoSuchMethodException {
        Method method = ITutorSubjectRepository.class.getMethod("findByTutorSubjectId", Long.class);
        assertListReturnType(method, TutorSubject.class);
    }

    @Test
    void shouldDeclareFindByTutorProfile() throws NoSuchMethodException {
        Method method = ITutorSubjectRepository.class.getMethod("findByTutorProfile", TutorProfile.class);
        assertListReturnType(method, TutorSubject.class);
    }

    @Test
    void shouldDeclareFindBySubject() throws NoSuchMethodException {
        Method method = ITutorSubjectRepository.class.getMethod("findBySubject", Subject.class);
        assertListReturnType(method, TutorSubject.class);
    }

    private void assertListReturnType(Method method, Class<?> genericType) {
        assertEquals(List.class, method.getReturnType());
        Type returnType = method.getGenericReturnType();
        assertTrue(returnType instanceof ParameterizedType);
        Type actualType = ((ParameterizedType) returnType).getActualTypeArguments()[0];
        assertEquals(genericType, actualType);
    }
}
