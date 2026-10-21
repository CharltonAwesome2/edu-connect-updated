package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.TutorProfile;
import za.ac.cput.domain.User;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ITutorProfileRepositoryTest {

    @Test
    void shouldExtendJpaRepository() {
        assertTrue(JpaRepository.class.isAssignableFrom(ITutorProfileRepository.class));
    }

    @Test
    void shouldDeclareFindByTutorProfileId() throws NoSuchMethodException {
        Method method = ITutorProfileRepository.class.getMethod("findByTutorProfileId", Long.class);
        assertListReturnType(method, TutorProfile.class);
    }

    @Test
    void shouldDeclareFindByUser() throws NoSuchMethodException {
        Method method = ITutorProfileRepository.class.getMethod("findByUser", User.class);
        assertListReturnType(method, TutorProfile.class);
    }

    private void assertListReturnType(Method method, Class<?> genericType) {
        assertEquals(List.class, method.getReturnType());
        Type returnType = method.getGenericReturnType();
        assertTrue(returnType instanceof ParameterizedType);
        Type actualType = ((ParameterizedType) returnType).getActualTypeArguments()[0];
        assertEquals(genericType, actualType);
    }
}
