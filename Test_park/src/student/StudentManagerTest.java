package student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class StudentManagerTest {

	StudentManager manager;
	
	@BeforeEach
	void setUp() {
		manager = new StudentManager();
	}

	@Test
	void testAddStudent() {
		manager.addStudent("abc");
		assertTrue(manager.hasStudent("abc"));
	}

	@Test
	void testRemoveStudent() {
		manager.addStudent("abc");
		manager.removeStudent("abc");
		assertFalse(manager.hasStudent("abc"));
	}

	@Test
	void testDuplicateAddStudent() {
		manager.addStudent("abc");	
		assertThrows(IllegalArgumentException.class, () -> manager.addStudent("abc"));
	}
	
	@Test
	void testNonExistStudent() {
		assertThrows(IllegalArgumentException.class, () -> manager.removeStudent("abc"));
	}
	
	
}
