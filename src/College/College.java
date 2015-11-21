package college;
import java.util.*;

import Major.Major;
import Setup.Admin;
import Course.Course;


public abstract class College {
	//comment
	private String collegeName = "";
	private ArrayList<Major> majorList = new ArrayList<Major>();
	private ArrayList<Course> collegeReqList = new ArrayList<Course>();
	
	public College(String college) {
		String[] collegeInfo = college.split(" ");
		collegeName = collegeInfo[0];
		
		ArrayList<Major> majors = Admin.getMajorList();
		for (String majorName:collegeInfo[1].split("/")) {
			for (Major major:majors) {
				if (major.getName().equals(majorName)){
					majorList.add(major);
				}
			}
		}
		
		
		
		ArrayList<Course> courses = Admin.getCourseList();
		for (Course course:courses){
			if (course.getColOrMaj().contains(collegeName)) {
				collegeReqList.add(course);
			}
		}
	}
	
	public String getName(){
		return collegeName;
	}
	
	public ArrayList<Major> getMajorList(){
		return majorList;
	}
	
	public ArrayList<Course> getCollegeReqList(){
		return collegeReqList;
	}
}
