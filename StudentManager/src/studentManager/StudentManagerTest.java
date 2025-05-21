package studentManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentManagerTest {
	StudentManager std_manager;

	@BeforeEach
	void setUp() throws Exception {
		std_manager = new StudentManager();
	}
	
	void testAddStudent(String name) {
		std_manager.addStudent(name);
		assertTrue(std_manager.hasStudent(name));
	}
	
	@Test
	void testAddStudents() {
		testAddStudent("Amy");
		testAddStudent("Bob");
		testAddStudent("Carl");
	}

	@Test
	void testRemoveAmy() {
		testAddStudents();
		std_manager.removeStudent("Amy");
		
		assertFalse(std_manager.hasStudent("Amy"));
	}
	
	@Test
	void testAddExistStudent() {
		testAddStudents();
		
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, 
				() -> std_manager.addStudent("Amy"));
	    System.out.println(e.getMessage());
	}
	
	@Test
	void testRemoveEmptyStudent() {
		
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, 
				() -> std_manager.removeStudent("Amy"));
		System.out.println(e.getMessage());
	}

}
