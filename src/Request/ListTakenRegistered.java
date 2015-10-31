package Request;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import Course.Course;
import Student.Student;

public class ListTakenRegistered extends Request {
	public ListTakenRegistered() {
		super();
	}

	@Override
	public void process(Student student, String command){
		if (command.equalsIgnoreCase("ListTaken")) {
			ArrayList<Course> taken = student.getPrevTaken();
			outputResult(student.getSID(), taken, command);
		}
	}
	
	public void outputResult(String SID, ArrayList<Course> courseList, String command) {
		File result = new File(".\\Result\\" + SID + "_" + command);
		try {
			FileOutputStream fos = new FileOutputStream(result);
			
			ArrayList<String> strResult = new ArrayList<String>();
			strResult.add(command);
			strResult.add("--------------------------------------------------");
			
			for (Course course:courseList) {
				String tmp = course.getCourseCode() + " " + course.getCourseTitle();
				strResult.add(tmp);
			}
			
			for (String str:strResult){
				fos.write(str.getBytes());
				fos.write("\n".getBytes());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
