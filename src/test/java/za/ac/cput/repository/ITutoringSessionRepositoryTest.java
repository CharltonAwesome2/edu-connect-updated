package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.TutoringSession;
import za.ac.cput.domain.User;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ITutoringSessionRepositoryTest {

    @Test
    void shouldExtendJpaRepository() {
        assertTrue(JpaRepository.class.isAssignableFrom(ITutoringSessionRepository.class));
    }

    @Test
    void shouldDeclareFindByTutoringSessionId() throws NoSuchMethodException {
        Method method = ITutoringSessionRepository.class.getMethod("findByTutoringSessionId", Long.class);
        assertListReturnType(method, TutoringSession.class);
    }

    @Test
    void shouldDeclareFindByTutorProfile() throws NoSuchMethodException {
        Method method = ITutoringSessionRepository.class.getMethod("findByTutorProfile", TutorProfile.class);
        assertListReturnType(method, TutoringSession.class);
    }

    @Test
    void shouldDeclareFindByStudent() throws NoSuchMethodException {
        Method method = ITutoringSessionRepository.class.getMethod("findByStudent", User.class);
        assertListReturnType(method, TutoringSession.class);
    }

    private void assertListReturnType(Method method, Class<?> genericType) {
        assertEquals(List.class, method.getReturnType());
        Type returnType = method.getGenericReturnType();
        assertTrue(returnType instanceof ParameterizedType);
        Type actualType = ((ParameterizedType) returnType).getActualTypeArguments()[0];
        assertEquals(genericType, actualType);
    }
}
