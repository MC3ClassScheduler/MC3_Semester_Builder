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


	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

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
	public void setTimeRange(double nextDouble, double nextDouble2) {
		timeRange[0] = nextDouble;
		timeRange[1] = nextDouble2;	
	}
	public Hashtable<Day, Double[]> getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(Hashtable<Day, Double[]> courseTime) {
		this.courseTime = courseTime;
	}

	@Override
	public String toString() {
		return courseCode + "*" + courseNum + "*" + section + " " + courseName + " " + building +
				" " + roomNum + " " + days + " " + timeRange[0] + " " + timeRange[1];
	}
	
	public boolean conflict(Course c){
		if(this.days.contains("M") && c.days.contains("M")){
			if(this.timeRange[0] < c.timeRange[1] && this.timeRange[1] > c.timeRange[0]) return false;
			else return true;
		}
		if(this.days.contains("T") && c.days.contains("T")){
			if(this.timeRange[0] < c.timeRange[1] && this.timeRange[1] > c.timeRange[0]) return false;
			else return true;
		}
		if(this.days.contains("W") && c.days.contains("W")){
			if(this.timeRange[0] < c.timeRange[1] && this.timeRange[1] > c.timeRange[0]) return false;
			else return true;
		}
		if(this.days.contains("R") && c.days.contains("R")){
			if(this.timeRange[0] < c.timeRange[1] && this.timeRange[1] > c.timeRange[0]) return false;
			else return true;
		}
		if(this.days.contains("F") && c.days.contains("F")){
			if(this.timeRange[0] < c.timeRange[1] && this.timeRange[1] > c.timeRange[0]) return false;
			else return true;
		}
		if(this.days.contains("S") && c.days.contains("S")){
			if(this.timeRange[0] < c.timeRange[1] && this.timeRange[1] > c.timeRange[0]) return false;
			else return true;
		}
		if(this.days.contains("N") && c.days.contains("N")){
			if(this.timeRange[0] < c.timeRange[1] && this.timeRange[1] > c.timeRange[0]) return false;
			else return true;
		}
		else return false;
	}
}

