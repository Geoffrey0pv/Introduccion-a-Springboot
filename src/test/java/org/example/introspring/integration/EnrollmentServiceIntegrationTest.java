package org.example.introspring.integration;

import org.example.introspring.entity.Course;
import org.example.introspring.entity.Student;
import org.example.introspring.service.CourseService;
import org.example.introspring.service.EnrollmentsService;
import org.example.introspring.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EnrollmentServiceIntegrationTest {

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private EnrollmentsService enrollmentsService;
    // Asumiendo que hay un método getStudentsByCourseId(...) o similar

    private Course course;
    private Student s1;
    private Student s2;

    @BeforeEach
    void setup() {
        // Crear un curso
        course = new Course();
        course.setName("Curso de Prueba");
        course = courseService.createCourse(course);

        // Crear estudiantes
        s1 = new Student();
        s1.setName("Alice");
        s1.setCode("A001");
        s1.setProgram("SIS");
        studentService.createStudent(s1);

        s2 = new Student();
        s2.setName("Bob");
        s2.setCode("A002");
        s2.setProgram("SIS");
        studentService.createStudent(s2);

        // Inscribirlos en el curso
        enrollmentsService.enrollStudent(s1.getId(), course.getId());
        enrollmentsService.enrollStudent(s2.getId(), course.getId());
    }

    @Test
    @DisplayName("getEnrolledStudents_WhenCourseHasStudents_ShouldReturnStudentList")
    void getEnrolledStudents_WhenCourseHasStudents_ShouldReturnStudentList() {
        // Act
        List<Student> enrolled = enrollmentsService.getStudentsEnrolledInCourse(course.getId());
        // <- Este método lo debes implementar en tu service
        // con la lógica de:
        //   enrollmentRepository.findByCourse_Id(courseId)
        // y mapear a Student

        // Assert
        assertEquals(2, enrolled.size(), "Debería haber 2 estudiantes inscritos");
        // Podrías agregar más asserts para verificar nombres, IDs, etc.
    }
}
