package request;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import course.Course;
import session.Session;
import setup.Admin;
import student.Student;

public class ListTakenRegistered extends Request {
	public ListTakenRegistered() {
		super();
	}

	@Override
	public void process(Student student, String command, String courseInput){
		if (command.equalsIgnoreCase("ListTaken")) {
			ArrayList<Course> taken = student.getPrevTaken();
			outputTaken(student.getSID(), taken, command);
		} else if (command.equalsIgnoreCase("ListRegistered")) {
			ArrayList<Session> registered = student.getRegistered();
			outputRegistered(student.getSID(), registered, command);
		}
	}
	
	public void outputTaken(String SID, ArrayList<Course> courseList, String command) {
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
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
				fos.write(System.getProperty("line.separator").getBytes());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void outputRegistered(String SID, ArrayList<Session> sessionList, String command) {
		Admin admin = Admin.getInstance();
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		try {
			FileOutputStream fos = new FileOutputStream(result);
			
			ArrayList<String> strResult = new ArrayList<String>();
			strResult.add(command);
			strResult.add("--------------------------------------------------");
			
			for (Session session:sessionList) {
				String tmp = session.getCourseCode() + " " + admin.getCourse(session.getCourseCode()).getCourseTitle() + System.getProperty("line.separator") + 
						"CRN: " + session.getCRN() + System.getProperty("line.separator") + 
						"Time: " + session.getDayStr() + " " + session.getStart() + "-" + session.getEnd() + System.getProperty("line.separator");
				strResult.add(tmp);
			}
			
			for (String str:strResult){
				fos.write(str.getBytes());
				fos.write(System.getProperty("line.separator").getBytes());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
