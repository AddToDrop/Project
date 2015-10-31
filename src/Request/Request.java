package Request;

import Student.Student;

public abstract class Request {
	public abstract void process(Student student, String command);
}
