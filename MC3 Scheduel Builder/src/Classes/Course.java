package Classes;

import java.util.Hashtable;

public class Course{

	private int courseNum;
	private String courseName;
	private int creditHours;
	private Double[] timeRange;
	private Hashtable<Day, Double[]> courseTime;
	
	public enum Day{
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
	    THURSDAY, FRIDAY, SATURDAY 
	}
	
	
	public Course(){
		this.courseName = null;
		this.courseNum = 0;
		this.creditHours = 3;
		Day i = Day.FRIDAY;
	}

	public Course(String courseName, int courseNum, int creditHours){
		this.courseName = courseName;
		this.courseNum = courseNum;
		this.creditHours = creditHours;
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
}
