package Scanners;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * @author Matthew D'Amore
 *
 */
//test
//test
public class ProgramEvalReader{

	private static Scanner reader;
	private String courseP;
	private ArrayList<String> courseEvalLines;
	
    //hello
	/**
	 * 
	 * @param The Course Evaluation taken from an input
	 */
	public ProgramEvalReader(String a)
	{
		this.courseEvalLines = getLines(a);
		this.courseP = a;
	}
	
	public String getCourseP() {
		return courseP;
	}

	public void setCourseP(String courseP) {
		this.courseP = courseP;
		this.courseEvalLines = getLines(courseP);
	}

	public ArrayList<String> getCourseEvalLines() {
		return courseEvalLines;
	}


	/**
	 * @param transcript
	 * @return Returns the Program Evaluations Slit into separate lines
	 */
	protected  ArrayList<String> getLines(String transcript){
		ArrayList<String>  lines = new ArrayList<String>();
		reader = new Scanner(transcript);
		
		while(reader.hasNextLine())
				lines.add(reader.nextLine());
		
		//Removes unnecessary lines of text
		lines.remove(" "); lines.remove(" \n");
		lines.remove("\t"); lines.remove("");
		
		return lines;
	}
	
	/**
	 * Takes in the Course Evaluation broken up by line and parses through it to give
	 * back the Institutional GPA and the Overall GPA
	 * @param courseP
	 * 
	 * @return Institutional and Overall GPA as Array List
	 */
	public ArrayList<String> getGpaInfo(){
		ArrayList<String> GpaInfo = new ArrayList<String>();
		
		for(String i: this.courseEvalLines){
			if(i.contains("Institutional GPA:")) GpaInfo.add(i);
			if(i.contains("Overall GPA:")) GpaInfo.add(i);
		}
		
		return this.courseEvalLines;
	}
	
	/**
	 * Takes in the Course Evaluation broken up  by line and parses through it to give
	 * back the Credit info of the eval.
	 * @param courseP
	 * @return Institutional and Overall credits as Array List
	 */
	public ArrayList<String> getCreditInfo(){
		ArrayList<String> courseInfo = new ArrayList<String>();
		
		for(String i: this.courseEvalLines){
			if(i.contains("Institutional Credits:"))	courseInfo.add(i);
			if(i.contains("Overall Credits:")) 			courseInfo.add(i);
		}
		
		return courseInfo;
		
	}
	
	/**
	 * 
	 * @return Returns the Classes needed for the Computer Science major.
	 */
	public ArrayList<String> getNeededMajorCourses(){
		ArrayList<String> MCNeeded = new ArrayList<String>();
		
		Pattern MajorCouse = Pattern.compile("(\\d)" + "(.)" + "(\\s)" + "(MAT\\*|CIS\\*)", Pattern.CASE_INSENSITIVE);		

		for(String i: this.courseEvalLines){
			Matcher matcher = MajorCouse.matcher(i);
			if(matcher.find()) MCNeeded.add(i);
		}
			
		return MCNeeded;
	}
	
	/**
	 * 
	 * @return Returns the General education areas that still need to be taken
	 */ 
	public ArrayList<String> getNeededGenEds(){
		ArrayList<String> neededGenEds = new ArrayList<String>();
		
		for(String i: courseEvalLines)
			if(i.contains("Not started")) neededGenEds.add(i);
		
		return neededGenEds;
	}
}
