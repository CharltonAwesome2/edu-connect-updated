package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Availability;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.DayOfWeek;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AvailabilityRepositoryTest {

    @Test
    void shouldExtendJpaRepository() {
        assertTrue(JpaRepository.class.isAssignableFrom(AvailabilityRepository.class));
    }

    @Test
    void shouldDeclareFindAllByDayOfWeek() throws NoSuchMethodException {
        Method method = AvailabilityRepository.class.getMethod("findAllByDayOfWeek", DayOfWeek.class);
        assertListReturnType(method, Availability.class);
    }

    private void assertListReturnType(Method method, Class<?> genericType) {
        assertEquals(List.class, method.getReturnType());
        Type returnType = method.getGenericReturnType();
        assertTrue(returnType instanceof ParameterizedType);
        Type actualType = ((ParameterizedType) returnType).getActualTypeArguments()[0];
        assertEquals(genericType, actualType);
    }
}
