package Classes;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import Scanners.ProgramEvalReader;
/** 
 * @author damore1405
 *Course Object that contains Course data, such as the number of the course, as well as a Hashtable of the days of the week
 *that the course occurs, to be used to display course information on the calendar GUI
 */
public class Course{

	private int courseNum;
	private int creditHours;
	private int roomNum;
	private String courseCode;
	private String courseName;
	private String section;
	private String building;
	private String days;
	private enum Day {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}
	private Double[] timeRange = new Double[2];
	private Hashtable<Day, Double[]> courseTime = new Hashtable<Day, Double[]>();
	
	public Course() throws FileNotFoundException{
		Scanner in = new Scanner(new FileReader("Course List.txt"));
		ArrayList<String> courses = new ArrayList<String>();
		while(in.hasNextLine()){courses.add(in.nextLine());}
		
		for(String i: courses){
			in.useDelimiter(",");
			courseCode = in.next();
			courseNum = in.nextInt();
			section = in.next();
			courseName = in.next();
			building = in.next();
			roomNum = in.nextInt();
			days = in.next();
			timeRange[0] = in.nextDouble();
			timeRange[1] = in.nextDouble();
		}

	}

	public Course(int courseNum, int creditHours, String courseName) {
		this.courseNum = courseNum;
		this.creditHours = creditHours;
		this.courseName = courseName;
	}

	public Course(String courseName, String section, int courseNum, int creditHours){
		this.courseName = courseName;
		this.courseNum = courseNum;
		this.creditHours = creditHours;
	}
	
	public Course(String courseName, String section, int courseNum, int creditHours, Day courseDay, Double[] timeRange){
		this.courseName = courseName;
		this.courseNum = courseNum;
		this.creditHours = creditHours;
		courseTime.put(courseDay, timeRange);
	}

    public int getCourseNum(){
        return this.courseNum;
    }
	public int getCreditHours(){
        return this.creditHours;
    }
    public String getCourseName(){
        return this.courseName;
    }
    public void setCourseNum(int courseNum){
        this.courseNum = courseNum;
    }
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    public void setCreditHours(int creditHours){
        this.creditHours = creditHours;
    }
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public Double[] getTimeRange() {
		return timeRange;
	}
	public void setTimeRange(Double[] timeRange) {
		this.timeRange = timeRange;
	}
	public Hashtable<Day, Double[]> getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(Hashtable<Day, Double[]> courseTime) {
		this.courseTime = courseTime;
	}

}
