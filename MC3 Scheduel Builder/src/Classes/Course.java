package Classes;

import java.util.ArrayList;
import java.util.Arrays;
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


	public Course(int courseNum, int creditHours, String courseName) {
		this.courseNum = courseNum;
		this.creditHours = creditHours;
		this.courseName = courseName;
	}

	public Course() {
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


	public Course[] getCoursesFromFile() throws FileNotFoundException{
		Scanner in = new Scanner(new FileReader("Course List.txt"));
		ArrayList<String> courseLines = new ArrayList<String>();
		int count = 0;
		Course[] Courses = new Course[6];
		while(in.hasNextLine()){courseLines.add(in.nextLine());}
		
		for(String i: courseLines){
			in.useDelimiter(",");
			
			Courses[count].courseCode   = in.next();
			Courses[count].courseNum    = in.nextInt();
			Courses[count].section      = in.next();
			Courses[count].courseName   = in.next();
			Courses[count].building     = in.next();
			Courses[count].roomNum      = in.nextInt();
			Courses[count].days         = in.next();
			Courses[count].timeRange[0] = in.nextDouble();
			Courses[count].timeRange[1] = in.nextDouble();
			count++;
		}
		return Courses;
		
	}

	@Override
	public String toString() {
		return "Course [courseNum=" + courseNum + ", creditHours="
				+ creditHours + ", roomNum=" + roomNum + ", courseCode="
				+ courseCode + ", courseName=" + courseName + ", section="
				+ section + ", building=" + building + ", days=" + days
				+ ", timeRange=" + Arrays.toString(timeRange) + ", courseTime="
				+ courseTime + "]";
	}
}
