package request;

import student.Student;

public abstract class Request {
	public abstract void process(Student student, String command);
}
