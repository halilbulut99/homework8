package fmi.informatics.homework8;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.List;

import fmi.informatics.extending.Student;

class JunitTestsTest {

	
	List<Student> randomStudents = 
			(List<Student>) Arrays.asList(
		new Student(),
		new Student()
	);
	
	public String sort(String one, String two) {
		randomStudents.get(0).setName("Халил");
		randomStudents.get(1).setName("Булут");

		randomStudents.sort((a, b) -> {
			return a.getName().compareTo(b.getName());
		});
		return randomStudents.get(0).getName()+randomStudents.get(1).getName();
	}

	@Test
	public void testSorting() {
		String result = sort(randomStudents.get(0).getName(), randomStudents.get(1).getName());
		String expectedResult = randomStudents.get(0).getName()+randomStudents.get(1).getName();

		assertEquals(expectedResult, result);
	}
	
	
	
	
}