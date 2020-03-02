package fmi.informatics.homework8;

import java.util.*;

import com.sun.tools.javac.util.List;

import fmi.informatics.extending.Student;

public class StudensList {
	public static void main(String[] args) {

		sortStudents();
	}

	public static void sortStudents() {
		Scanner scanner = new Scanner(System.in);

		ArrayList<Student> randomStudents = new ArrayList<Student>();

		randomStudents.add(StudentGenerator.generateRandomStudent());
		randomStudents.add(StudentGenerator.generateRandomStudent());
		randomStudents.add(StudentGenerator.generateRandomStudent());
		randomStudents.add(StudentGenerator.generateRandomStudent());
		randomStudents.add(StudentGenerator.generateRandomStudent());

		getRandomStudents(randomStudents);

		System.out.println();
		System.out.println("Моля изберете В за възходящо или Н за низходящо сортиране!!!!");
		System.out.println();
		try {
			String aOrB = scanner.nextLine();
			if (aOrB.equals("В")) {
				System.out.println();
				System.out.println("Вие сортирахте СПЕЦЯЛНОСТ по ВЪЗХОДЯЩ  ред!!!");
				System.out.println();
				sortStudentsAscending(randomStudents);
				randomStudents.forEach((s) -> System.out
						.println("Име: " + s.getName() + ", Години: " + s.getAge() + ", ЕГН: " + s.getEgn()
								+ ", Университед: " + s.getUniversity() + ", Спецялност: " + s.getSpeciality()));

			} else if (aOrB.equals("Н")) {
				System.out.println();
				System.out.println("Вие сортирахте СПЕЦЯЛНОСТ по НИЗХОДЯЩ ред!!!");
				System.out.println();
				sortStudentsDescending(randomStudents);
				randomStudents.forEach((s) -> System.out
						.println("Име: " + s.getName() + ", Години: " + s.getAge() + ", ЕГН: " + s.getEgn()
								+ ", Университед: " + s.getUniversity() + ", Спецялност: " + s.getSpeciality()));
			} else {
				System.out.println("Вие избрахте сортиране по подразбиране!!!");
				randomStudents.forEach((s) -> System.out
						.println("Име: " + s.getName() + ", Години: " + s.getAge() + ", ЕГН: " + s.getEgn()
								+ ", Университед: " + s.getUniversity() + ", Спецялност: " + s.getSpeciality()));
			}
		} catch (Exception e) {
			System.err.println("ВНИМАНИЕ ТРЯБВА ДА ИЗБЕРЕТЕ БУКВА!!!!");
		}

		if (!(scanner.hasNext())) {
			scanner.close();
		}
	}

	public static void getRandomStudents(ArrayList<Student> randomStudents) {
		System.out.println("Рандом генериран списък със студенти!");

		randomStudents.forEach((s) -> System.out.println("Име: " + s.getName() + ", Години: " + s.getAge() + ", ЕГН: "
				+ s.getEgn() + ", Университед: " + s.getUniversity() + ", Спецялност: " + s.getSpeciality()));

	}

	public static void sortStudentsAscending(java.util.List<Student> randomStudents) {
		randomStudents.sort(Comparator.comparing(Student::getSpeciality));
	}

	public static void sortStudentsDescending(java.util.List<Student> randomStudents) {
		randomStudents.sort((a, b) -> b.getSpeciality().compareTo(a.getSpeciality()));
	}

}
