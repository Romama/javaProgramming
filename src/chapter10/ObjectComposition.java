package chapter10;

/**
 * 对象的组合与聚集
 * @author Administrator
 * 设计一个课程的类：每门课程都有一个名字以及选课的学生，能够为这个课程添加学生，并且可以从这个课程中删除学生。
 */
public class ObjectComposition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Course course = new Course("Math");
		course.addOneStudent("Roma");
		course.addOneStudent("Cuicui");
		course.addOneStudent("Rose");
		course.addOneStudent("Jack");
		
		String[] students = course.getStudents();
		
		for(int i = 0; i < students.length; i++)
			System.out.print(students[i] + " ");
		
		course.dropOneStudent("Cuicui");
		students = course.getStudents();
		
		for(int i = 0; i < students.length; i++)
			System.out.print(students[i] + " ");
	}
}

//设计课程类
class Course {
	
	private String courseName; //课程名
	
	private String[] students = new String[10]; //学生
	
	private int numOfStudents; //学生人数
	
	public Course(String courseName){ //构造方法
		this.courseName = courseName;
	}
	
	public String getCourseName(){
		return courseName;
	}
	
	public String[] getStudents(){
		return students;
	}
	
	public int getNumOfStudents(){
		return numOfStudents;
	}
	
	//添加一个学生
	public void addOneStudent(String name){
		students[numOfStudents] = name;
		numOfStudents++;
	}
	
	//删除一个学生
	public void dropOneStudent(String name){
		int i = 0;
		for(; i < numOfStudents && !students[i].equals(name); i++);//找到要删除的学生
		
		if(i < numOfStudents){ //已找到学生
			for(int j = i; j < numOfStudents - 1; j++){ //删除学生后，移动学生的位置
				students[j] = students[j + 1];
				students[j + 1] = null;
			}
			numOfStudents--;
		}
	}
}
