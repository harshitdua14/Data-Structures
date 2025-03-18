package linked_list.singly_linked_list.student_record;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentList studentList = new StudentList();

        studentList.addAtBeginning(101, "Alice", 20, "A");
        studentList.addAtEnd(102, "Bob", 21, "B");
        studentList.addAtPosition(2, 103, "Charlie", 22, "A+");

        studentList.displayAll();

        studentList.searchByRollNo(102);

        studentList.updateGrade(101, "A+");
        studentList.displayAll();

        studentList.deleteByRollNo(103);
        studentList.displayAll();
	}

}
