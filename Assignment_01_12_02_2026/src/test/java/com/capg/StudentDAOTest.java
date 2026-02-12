package com.capg;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StudentDAOTest {

    private EntityManagerFactory emf;
    private EntityManager em;
    private StudentDAO studentDAO;

    // Runs once before all tests
    @BeforeAll
    void setupFactory() {
        emf = Persistence.createEntityManagerFactory("dev"); // Use your persistence-unit name
    }

    // Runs before each test
    @BeforeEach
    void setup() {
        em = emf.createEntityManager();
        studentDAO = new StudentDAO(em);
    }

    // Runs after each test
    @AfterEach
    void tearDown() {
        if (em != null) {
            em.close();
        }
    }

    // Runs once after all tests
    @AfterAll
    void closeFactory() {
        if (emf != null) {
            emf.close();
        }
    }

    // 1️⃣ Test Save
    @Test
    void testSaveStudent() {
        Student student = new Student("John", "john@example.com", 85);
        studentDAO.saveStudent(student);

        assertNotNull(student.getId());
    }

    // 2️⃣ Test Find By ID
    @Test
    void testFindStudentById() {
        Student student = new Student("Alice", "alice@example.com", 90);
        studentDAO.saveStudent(student);

        Student found = studentDAO.findStudentById(student.getId());

        assertNotNull(found);
        assertEquals("Alice", found.getName());
    }

    // 3️⃣ Test Find All
    @Test
    void testFindAllStudents() {
        studentDAO.saveStudent(new Student("A", "a@example.com", 70));
        studentDAO.saveStudent(new Student("B", "b@example.com", 75));

        List<Student> students = studentDAO.findAllStudents();

        assertTrue(students.size() >= 2);
    }

    // 4️⃣ Test Update
    @Test
    void testUpdateStudent() {
        Student student = new Student("Tom", "tom@example.com", 60);
        studentDAO.saveStudent(student);

        student.setMarks(95);
        studentDAO.updateStudent(student);

        Student updated = studentDAO.findStudentById(student.getId());

        assertEquals(95, updated.getMarks());
    }

    // 5️⃣ Test Delete
    @Test
    void testDeleteStudent() {
        Student student = new Student("Mike", "mike@example.com", 80);
        studentDAO.saveStudent(student);

        studentDAO.deleteStudent(student.getId());

        Student deleted = studentDAO.findStudentById(student.getId());

        assertNull(deleted);
    }

    // 6️⃣ Test Student Count
    @Test
    void testStudentCount() {
        studentDAO.saveStudent(new Student("X", "x@example.com", 50));
        studentDAO.saveStudent(new Student("Y", "y@example.com", 55));

        List<Student> students = studentDAO.findAllStudents();

        assertTrue(students.size() >= 2);
    }
}
