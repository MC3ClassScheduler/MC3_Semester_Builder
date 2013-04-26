package Classes;

import java.util.Hashtable;

public class Course{

	private int courseNum;
	private int creditHours;
	private String courseName;
	private String section;
	private Double[] timeRange = new Double[2];
	private Hashtable<day, Double[]> courseTime = new Hashtable<day, Double[]>();
	
	private enum day{
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY 
	}
	
	public Course(){
		this.courseName = null;
		this.courseNum = 0;
		this.creditHours = 3;
	}

	public Course(int courseNum, int creditHours, String courseName) {
		super();
		this.courseNum = courseNum;
		this.creditHours = creditHours;
		this.courseName = courseName;
	}


	public Course(String courseName, String section, int courseNum, int creditHours){
		this.courseName = courseName;
		this.courseNum = courseNum;
		this.creditHours = creditHours;
	}
	public Course(String courseName, String section, int courseNum, int creditHours, day courseDay, Double[] timeRange){
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
	public Hashtable<day, Double[]> getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(Hashtable<day, Double[]> courseTime) {
		this.courseTime = courseTime;
	}
}
