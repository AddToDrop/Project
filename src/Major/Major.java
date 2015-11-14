package Major;
import java.util.*;

import Setup.Admin;
import Course.Course;
import Course.MajorElectiveReq;
import Course.MajorReq;

public abstract class Major {
	String majorName = "";
	private ArrayList<Course> majorReqList = new ArrayList<Course>();
	private ArrayList<Course> majorElecReq = new ArrayList<Course>();
	
	public Major (String name) {
		majorName = name;
		
		ArrayList<Course> courses = Admin.getCourseList();
		ArrayList<Course> courseForMajor = new ArrayList<Course>();
		
		for (Course course:courses){
			if (course.getColOrMaj().contains(majorName)) {
				courseForMajor.add(course);
			}
		}
		
		for (Course course:courseForMajor){
			if (course instanceof MajorReq) {
				majorReqList.add(course);
			} else if (course instanceof MajorElectiveReq){
				majorElecReq.add(course);
			} else {
				System.out.println("Not majorReq nor majorElecReq");
			}
		}
		
	}
	
	public String getName(){
		return majorName;
	}
	
	public ArrayList<Course> getMajorReqList(){
		return majorReqList;
	}
	
	public ArrayList<Course> getMajorElecReq(){
		return majorElecReq;
	}
}