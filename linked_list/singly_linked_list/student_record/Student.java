package linked_list.singly_linked_list.student_record;

public class Student {
	 int rollNo;
	 String name;
	 int age;
	 String grade;
	Student next;
	Student(int rollNo,String name,int age,String grade){
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.next = null;
	}
	
}
