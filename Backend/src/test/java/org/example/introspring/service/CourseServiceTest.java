package org.example.introspring.service;

import org.example.introspring.entity.Course;
import org.example.introspring.entity.Professor;
import org.example.introspring.repository.CourseRepository;
import org.example.introspring.repository.ProfessorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Arrays;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CourseServiceTest {

    /*
    //Cargamos una simulación de la capa repository
    @Mock
    private CourseRepository courseRepository;

    //Inyectamos el mock a CourseService teniendo en cuenta la dependencia que tiene
    @InjectMocks
    private CourseServiceImpl courseService;

    @Test
    void getAllCourses_WhenCalled_ReturnsCourseList() {
        // Arrange
        // Creamos la información que simularemos que nos devolverá la capa de Repository
        Professor professor = new Professor();
        professor.setId(1L);
        professor.setName("Alice Andrew");

        Course course1 = new Course();
        course1.setId(1L);
        course1.setProfessor(professor);
        course1.setName("Computación en Internet II");

        Course course2 = new Course();
        course2.setId(2L);
        course2.setProfessor(professor);
        course2.setName("Ingeniería de Software IV");

        // Aquí en donde simulamos con Mockito el retorno del elemento de repositoy
        // La estructura es when( llamado a repository ) -> thenReturn( se devuelve la información simulada )
        when(courseRepository.findAll()).thenReturn(Arrays.asList(course1, course2));

        // Act
        // Aquí probamos ahora sí el método que deseamos testear
        List<Course> courses = courseService.getAllCourses();

        // Assert
        // Finalmente verificamos que todo esté ok
        assertEquals(2, courses.size());
        assertEquals("Computación en Internet II", courses.get(0).getName());
        assertEquals("Ingeniería de Software IV", courses.get(1).getName());
    }

    @Test
    void getCourseById_WhenExists_ReturnsCourse() {
        // Arrange
        Professor professor = new Professor();
        professor.setId(1L);
        professor.setName("Alice Andrew");

        Course course = new Course();
        course.setId(1L);
        course.setProfessor(professor);
        course.setName("Computación en internet II");

        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));

        // Act
        Course result = courseService.getCourseById(1L);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Computación en internet II", result.getName());
    }

    @Test
    void getCourseById_WhenNotExists_ThrowsException() {
        // Arrange
        when(courseRepository.findById(1L)).thenReturn(Optional.empty());
        // Act y Assert
        assertThrows(RuntimeException.class, () -> courseService.getCourseById(1L));
    }

    @Test
    void deleteCourse_WhenCalled_DeletesSuccessfully() {
        // Arrange
        long courseId = 1L;
        doNothing().when(courseRepository).deleteById(courseId);
        when(courseRepository.existsById(courseId)).thenReturn(true);
        // Act
        courseService.deleteCourse(courseId);
        // Assert
        verify(courseRepository, times(1)).deleteById(courseId);
    }

    @Autowired
    private ProfessorRepository professorRepository;

    private Professor professor;

    @BeforeEach
    void setup() {
        professor = new Professor();
        professor.setName("Alice Andrew");
        professor = professorRepository.save(professor);
    }

    @Test
    void createCourse_WhenValid_ReturnsSavedCourse() {
        // Arrange
        Course course = new Course();
        course.setName("Computación en Internet II");
        course.setProfessor(professor);

        // Act
        Course savedCourse = courseService.createCourse(course);

        // Assert
        assertNotNull(savedCourse.getId());
        assertEquals("Computación en Internet II", savedCourse.getName());
        assertNotNull(savedCourse.getProfessor());
        assertEquals(professor.getId(), savedCourse.getProfessor().getId());

        // Verificar que realmente está en la BD
        Course foundCourse = courseRepository.findById(savedCourse.getId()).orElse(null);
        assertNotNull(foundCourse);
        assertEquals("Computación en Internet II", foundCourse.getName());
    }
    @AfterEach
    void cleanup() {
        courseRepository.deleteAll();
        professorRepository.deleteAll();
    }

    @Test
     */
}
