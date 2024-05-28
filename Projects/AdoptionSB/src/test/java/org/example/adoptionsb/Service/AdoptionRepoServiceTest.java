package org.example.adoptionsb.Service;

import org.example.adoptionsb.Classes.Adopter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles({"h2"})
@SpringBootTest
@Transactional
@Tag("integration")
class AdoptionRepoServiceTest {
    private Adopter adopter;
    private Adopter adopter2;

    @Autowired
    private AdoptionRepoService adoptionRepoService;

    @BeforeEach
    public void setup() {
        adopter = new Adopter("Angel", "8594781526", null);
        adopter2 = new Adopter("Miguel", "4579548514", null);
    }

    @Test
    public void testGetAll() {
        Adopter newAdopter = adoptionRepoService.addAdopter(adopter);
        Adopter result = adoptionRepoService.findById(newAdopter.getIdAdopter());

        assertEquals(adopter.getAdopterName(), result.getAdopterName());
        assertEquals(10, adoptionRepoService.getAllAdopters().size());
        System.out.println("result = " + result);
    }

    @Test
    public void testDeleteAdopter() {
        Adopter adopter1 = adoptionRepoService.addAdopter(adopter);
        Course course2 = courseService.createCourse(code2, title2);

        assertEquals(5, courseService.getAllCourses().size());

        courseService.deleteCourse(course1.getId());

        List<Course> courses = courseService.getAllCourses();
        assertEquals(4, courses.size());
        assertEquals(title2, courseService.getCourse(course2.getId()).getTitle());
    }
}