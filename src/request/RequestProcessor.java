package request;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import course.Course;
import student.Student;

public class RequestProcessor {
	private ListTakenRegistered listTakenRegistered = new ListTakenRegistered();
	private ListAllAvailable listAllAvailable = new ListAllAvailable();
	private ListPossibleSchedule listPossibleSchedule = new ListPossibleSchedule();
	private Request request;
	
	public RequestProcessor(){}
	
	public RequestProcessor(Request request) {
		if (request instanceof ListTakenRegistered) {
			listTakenRegistered = (ListTakenRegistered) request;
		} else if (request instanceof ListAllAvailable) {
			listAllAvailable = (ListAllAvailable) request;
		} else if (request instanceof ListPossibleSchedule) {
			listPossibleSchedule  = (ListPossibleSchedule) request;
		}
	}
	
	public void processRequest(Student student, String command, String courseInput){
		if (command.equalsIgnoreCase("ListTaken") || command.equalsIgnoreCase("ListRegistered")){
			listTakenRegistered.process(student, command, courseInput);
		} else if (command.equalsIgnoreCase("ListAllAvailable")) {			
			listAllAvailable.process(student, command, courseInput);
		} else if (command.equalsIgnoreCase("ListPossibleSchedule")){			
			listPossibleSchedule.process(student, command, courseInput);
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
