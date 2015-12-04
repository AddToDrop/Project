package setup;

import java.util.ArrayList;

import major.Major;
import session.Session;
import college.College;
import course.Course;

public class Main {
	public static void main(String[] args) {
		Admin admin = Admin.getInstance();
		admin.startSetup();
		admin.getRequest();
	}

}
