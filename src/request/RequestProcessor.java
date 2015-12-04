package request;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import course.Course;
import student.Student;

public class RequestProcessor {
	public void processRequest(Student student, String command, String courseInput){
		if (command.equalsIgnoreCase("ListTaken") || command.equalsIgnoreCase("ListRegistered")){
			ListTakenRegistered request = new ListTakenRegistered();
			request.process(student, command, courseInput);
		} else if (command.equalsIgnoreCase("ListAllAvailable")) {
			ListAllAvailable request = new ListAllAvailable();
			request.process(student, command, courseInput);
		} else if (command.equalsIgnoreCase("ListPossibleSchedule")){
			ListPossibleSchedule request = new ListPossibleSchedule();
			request.process(student, command, courseInput);
		} else {
			outputInvalidCommand(student.getSID(), command);
		}
	
	}
	
	public void outputInvalidCommand(String SID, String command) {
		File result = new File(".\\Result\\" + SID + "_" + command + ".txt");
		try {
			FileOutputStream fos = new FileOutputStream(result);
			
			fos.write("Invalid command".getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
