package linked_list.singly_linked_list.student_record;

class StudentList {
    private Student head;

    // Add at the beginning
    public void addAtBeginning(int rollNo, String name, int age, String grade) {
        Student newStudent = new Student(rollNo, name, age, grade);
        if(head == null) {
        	head = newStudent;
        }
        newStudent.next = head;
        head = newStudent;
    }

    // Add at the end
    public void addAtEnd(int rollNo, String name, int age, String grade) {
        Student newStudent = new Student(rollNo, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    // Add at a specific position (1-based index)
    public void addAtPosition(int position, int rollNo, String name, int age, String grade) {
        if (position < 1) {
            System.out.println("Invalid position");
            return;
        }
        Student newStudent = new Student(rollNo, name, age, grade);
        if (position == 1) {
            newStudent.next = head;
            head = newStudent;
            return;
        }
        Student temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    // Delete by roll number
    public void deleteByRollNo(int rollNo) {
        Student temp = head, prev = null;
        
        if (temp == null) {
            System.out.println("Student with Roll No " + rollNo + " not found.");
            return;
        }
        
        if (temp != null && temp.rollNo == rollNo) {
            head = temp.next;
            System.out.println("Student with Roll No " + rollNo + " deleted.");
            return;
        }

        while (temp != null && temp.rollNo != rollNo) {
            prev = temp;
            temp = temp.next;
        }

     
        prev.next = temp.next;
        System.out.println("Student with Roll No " + rollNo + " deleted.");
    }

    // Search by roll number
    public void searchByRollNo(int rollNo) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                System.out.println("Found: Roll No: " + temp.rollNo + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll No " + rollNo + " not found.");
    }

    // Update grade by roll number
    public void updateGrade(int rollNo, String newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                temp.grade = newGrade;
                System.out.println("Grade updated for Roll No " + rollNo);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll No " + rollNo + " not found.");
    }

    // Display all student records
    public void displayAll() {
        Student temp = head;
        if (temp == null) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("Student Records:");
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNo + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}