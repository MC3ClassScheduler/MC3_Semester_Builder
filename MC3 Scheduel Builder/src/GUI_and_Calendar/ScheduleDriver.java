package GUI_and_Calendar;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Composite;
//import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;

import Classes.Course;


public class ScheduleDriver {

	protected Shell shlMcScheduler;
	private Text txtXscript;
	private Text txtCoursePlan;
	private String currentCourseSelected;
	private Table table;
	private Course[] courseList;
	
	public void addCurrentCourse(List list, String course){
		if(list.getItem(0).equals("No Courses Selected")){
			list.remove(0);
			list.add(course);
		}
		else{
			list.add(course);
		}
		
		
	}
	public void removeCurrentCourse(List list, String Course){
		list.remove(Course);
		if(list.getItemCount() == 0)
			list.add("No Courses Selected");
	}
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ScheduleDriver window = new ScheduleDriver();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 * @throws FileNotFoundException 
	 */
	public void open() throws FileNotFoundException {
		Display display = Display.getDefault();
		createContents();
		shlMcScheduler.open();
		shlMcScheduler.layout();
		while (!shlMcScheduler.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public void addToCalendar(String courseName, double startTime, Table tab, String days){
		startTime = Math.round(startTime);
		String[] input = new String[8];
		
		//populates input with current info
		for(int i = 0; i < 8; i++){
			input[i] = tab.getItem((int)startTime-8).getText(i);
		}
			
		ArrayList<Integer> inDays = new ArrayList<Integer>();
		//checking the days of the course	
			for(int i = 0; i < days.length(); i++){
				switch(days.charAt(i)){
					case 'n': 	inDays.add(1);
								break;
					case 'm': 	inDays.add(2);
								break;
					case 't': 	inDays.add(3);
								break;
					case 'w': 	inDays.add(4);
								break;
					case 'r': 	inDays.add(5);
								break;
					case 'f': 	inDays.add(6);
								break;
					case 's': 	inDays.add(7);
								break;
				}
			}
		for(int num: inDays){
			input[num] = courseName;
		}
		
		//setting the time slot with the correct courses
		switch(((int)startTime)){
			case 8: 	tab.getItem(0).setText(input);
						break;
			case 9: 	tab.getItem(1).setText(input);
						break;
			case 10:	tab.getItem(2).setText(input);
						break;
			case 11:	tab.getItem(3).setText(input);
						break;
			case 12:	tab.getItem(4).setText(input);
						break;
			case 13:	tab.getItem(5).setText(input);
						break;
			case 14:	tab.getItem(6).setText(input);
						break;
			case 15:	tab.getItem(7).setText(input);
						break;
			case 16:	tab.getItem(8).setText(input);
						break;
			case 17:	tab.getItem(9).setText(input);
						break;
			case 18:	tab.getItem(10).setText(input);
						break;
			case 19:	tab.getItem(11).setText(input);
						break;
			case 20:	tab.getItem(12).setText(input);
						break;
			case 21:	tab.getItem(13).setText(input);
						break;
			case 22:	tab.getItem(14).setText(input);
						break;
		}
	}
	
	
	public void removeFromCalendar(){
		
	}
	/**
	 * Create contents of the window.
	 * @throws FileNotFoundException 
	 */
	protected void createContents() throws FileNotFoundException {
		shlMcScheduler = new Shell();
		shlMcScheduler.setSize(803, 401);
		shlMcScheduler.setText("MC3 Scheduler");
		courseList = new Course().getCoursesFromFile();
		
		//MENU BAR
		Menu MenuBar = new Menu(shlMcScheduler, SWT.BAR);
		shlMcScheduler.setMenuBar(MenuBar);
		
				//FILE
				MenuItem FileMenu = new MenuItem(MenuBar, SWT.CASCADE);
				FileMenu.setText("File");
		
					Menu FileCascade = new Menu(FileMenu);
					FileMenu.setMenu(FileCascade);
		
						MenuItem mntmSave = new MenuItem(FileCascade, SWT.NONE);
						mntmSave.setText("Save");
		
						MenuItem mntmOpen = new MenuItem(FileCascade, SWT.NONE);
						mntmOpen.setText("Open");
		
						MenuItem mntmExit = new MenuItem(FileCascade, SWT.NONE);
						mntmExit.addSelectionListener(new SelectionAdapter() {
							@Override
							public void widgetSelected(SelectionEvent e) {
								shlMcScheduler.close();
							}
						});	
						mntmExit.setText("Exit");
		
					
				//INSERT
				MenuItem InsertMenu = new MenuItem(MenuBar, SWT.CASCADE);
				InsertMenu.setText("Insert");
		
					Menu InsertCascade = new Menu(InsertMenu);
					InsertMenu.setMenu(InsertCascade);
		
						MenuItem InsertTranscript = new MenuItem(InsertCascade, SWT.NONE);
						InsertTranscript.addSelectionListener(new SelectionAdapter() {
							@Override
							public void widgetSelected(SelectionEvent e) {
									final InsertDialog dial = new InsertDialog(shlMcScheduler, 1, txtXscript);
									dial.open();
									
							}
							});
					InsertTranscript.setText("Insert Transcript");
		
						MenuItem InsertCoursePlan = new MenuItem(InsertCascade, SWT.NONE);
						InsertCoursePlan.addSelectionListener(new SelectionAdapter() {
							@Override
							public void widgetSelected(SelectionEvent e) {
									final InsertDialog dial = new InsertDialog(shlMcScheduler, 1, txtCoursePlan);
									dial.open();
							}
							});
					InsertCoursePlan.setText("Insert Course Plan");
		
		//WINDOW TABS
		TabFolder WindowTab = new TabFolder(shlMcScheduler, SWT.NONE);
		WindowTab.setBounds(0, 0, 565, 343);
		
			//TRANSCRIPT TAB
				TabItem TranscriptTab = new TabItem(WindowTab, SWT.NONE);
				TranscriptTab.setText("Transcript");
			
					Composite TranscriptWindow = new Composite(WindowTab, SWT.NONE);
					TranscriptTab.setControl(TranscriptWindow);
			
						txtXscript = new Text(TranscriptWindow, SWT.BORDER | SWT.READ_ONLY | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL);
						txtXscript.setEditable(false);
						txtXscript.setText("Insert your Transcript!");
						txtXscript.setBounds(0, 0, 557, 315);
		
					
			//COURSE PLAN TAB
				TabItem CoursePlanTab = new TabItem(WindowTab, SWT.NONE);
				CoursePlanTab.setText("Course Plan");
			
					Composite CoursePlanWindow = new Composite(WindowTab, SWT.NONE);
					CoursePlanTab.setControl(CoursePlanWindow);
					
					txtCoursePlan = new Text(CoursePlanWindow, SWT.BORDER | SWT.READ_ONLY | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL);
					txtCoursePlan.setText("Insert your Course Plan");
					txtCoursePlan.setEditable(false);
					txtCoursePlan.setBounds(0, 0, 557, 315);
		
				
			//COURSE LIST TAB
				TabItem CourseListTab = new TabItem(WindowTab, SWT.NONE);
				CourseListTab.setText("Course List");
			
					Composite CourseListWindow = new Composite(WindowTab, SWT.NONE);
					CourseListTab.setControl(CourseListWindow);
					
					final List cList = new List(CourseListWindow, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
					cList.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							
							if(cList.getSelection().length>=1){
								currentCourseSelected = cList.getSelection()[0];
							}
						}
					});
					cList.setBounds(0, 0, 557, 315);
					for(Course cls: courseList){
						cList.add(cls.toString());
					}
				
				
			//Calendar Tab
				TabItem CalendarTab = new TabItem(WindowTab, SWT.NONE);
				CalendarTab.setText("Calendar");
				
				Composite CalenderWindow = new Composite(WindowTab, SWT.NONE);
				CalenderWindow.setEnabled(false);
				CalendarTab.setControl(CalenderWindow);
				
				table = new Table(CalenderWindow, SWT.BORDER | SWT.FULL_SELECTION);
				table.setLinesVisible(true);
				table.setBounds(0, 0, 557, 315);
				table.setHeaderVisible(true);
				
						TableColumn tblclmnTime = new TableColumn(table, SWT.NONE);
						tblclmnTime.setWidth(45);
						tblclmnTime.setText("Time");
						
						TableColumn SunColumn = new TableColumn(table, SWT.NONE);
						SunColumn.setWidth(73);
						SunColumn.setText("Sunday");
						
						TableColumn MonColumn = new TableColumn(table, SWT.NONE);
						MonColumn.setWidth(73);
						MonColumn.setText("Monday");
						
						TableColumn TueColumn = new TableColumn(table, SWT.NONE);
						TueColumn.setWidth(73);
						TueColumn.setText("Tuesday");
						
						TableColumn WedsColumn = new TableColumn(table, SWT.NONE);
						WedsColumn.setWidth(73);
						WedsColumn.setText("Wednesday");
						
						TableColumn ThuColumn = new TableColumn(table, SWT.NONE);
						ThuColumn.setWidth(73);
						ThuColumn.setText("Thursday");
						
						TableColumn FriColumn = new TableColumn(table, SWT.NONE);
						FriColumn.setWidth(72);
						FriColumn.setText("Friday");
						
						TableColumn SatColumn = new TableColumn(table, SWT.NONE);
						SatColumn.setWidth(71);
						SatColumn.setText("Saturday");
		
									TableItem eightAM = new TableItem(table, 0);
									eightAM.setText(new String[]{"8 AM", "", "", "", "", "", "", ""});
				
									TableItem nineAM = new TableItem(table, 0);
									nineAM.setText(new String[]{"9 AM", "", "", "", "", "", "", ""});
									
									TableItem tenAM = new TableItem(table, 0);
									tenAM.setText(new String[]{"10 AM", "", "", "", "", "", "", ""});
									
									TableItem elevenAM = new TableItem(table, 0);
									elevenAM.setText(new String[]{"11 AM", "", "", "", "", "", "", ""});
									
									TableItem twelvePM = new TableItem(table, 0);
									twelvePM.setText(new String[]{"12 PM", "", "", "", "", "", "", ""});
									
									TableItem onePM = new TableItem(table, 0);
									onePM.setText(new String[]{"1 PM", "", "", "", "", "", "", ""});
									
									TableItem twoPM = new TableItem(table, 0);
									twoPM.setText(new String[]{"2 PM", "", "", "", "", "", "", ""});
									
									TableItem threePM = new TableItem(table, 0);
									threePM.setText(new String[]{"3 PM", "", "", "", "", "", "", ""});
									
									TableItem fourPM = new TableItem(table, 0);
									fourPM.setText(new String[]{"4 PM", "", "", "", "", "", "", ""});
									
									TableItem fivePM = new TableItem(table, 0);
									fivePM.setText(new String[]{"5 PM", "", "", "", "", "", "", ""});
									
									TableItem sixPM = new TableItem(table, 0);
									sixPM.setText(new String[]{"6 PM", "", "", "", "", "", "", ""});
									
									TableItem sevenPM = new TableItem(table, 0);
									sevenPM.setText(new String[]{"7 PM", "", "", "", "", "", "", ""});
									
									TableItem eightPM = new TableItem(table, 0);
									eightPM.setText(new String[]{"8 PM", "", "", "", "", "", "", ""});
									
									TableItem ninePM = new TableItem(table, 0);
									ninePM.setText(new String[]{"9 PM", "", "", "", "", "", "", ""});
									
									TableItem tenPM = new TableItem(table, 0);
									tenPM.setText(new String[]{"10 PM", "", "", "", "", "", "", ""});
		
				
			
				
		//
		Label LabelSelectedCourses = new Label(shlMcScheduler, SWT.NONE);
		LabelSelectedCourses.setLocation(621, 2);
		LabelSelectedCourses.setSize(112, 15);
		LabelSelectedCourses.setText("Selected Courses");
		
		Composite SelectedCoursesWindow = new Composite(shlMcScheduler, SWT.NONE);
		SelectedCoursesWindow.setBounds(571, 23, 206, 310);
		
		final List selectedList = new List(SelectedCoursesWindow, SWT.BORDER);
		selectedList.setBounds(0, 0, 206, 269);
		selectedList.add("No Courses Selected");
		
		Button btnRemoveCourse = new Button(SelectedCoursesWindow, SWT.NONE);
		btnRemoveCourse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				try{
					removeCurrentCourse(selectedList, selectedList.getSelection()[0]);
					//removeFromCalendar
				}
				catch(ArrayIndexOutOfBoundsException error){
					final ErrorDialog err = new ErrorDialog(shlMcScheduler, 1);
					err.open();
				}
			}
		});
		btnRemoveCourse.setBounds(111, 275, 95, 25);
		btnRemoveCourse.setText("Remove Course");
		
		Button btnAddCourse = new Button(SelectedCoursesWindow, SWT.NONE);
		btnAddCourse.setBounds(0, 275, 95, 25);
		btnAddCourse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				try{
					addCurrentCourse(selectedList, cList.getSelection()[0]);
					addToCalendar(cList.getSelection()[0], 8.5, table, "mwf");
				}
				catch(ArrayIndexOutOfBoundsException error){
					final ErrorDialog err = new ErrorDialog(shlMcScheduler, 1);
					err.open();
				}
			}
		});
		btnAddCourse.setText("Add Course");

	}
	public Course[] getCoursesFromFile() throws FileNotFoundException{
		Scanner in = new Scanner(new FileReader("Course List.txt"));
		ArrayList<String> courseLines = new ArrayList<String>();
		int count = 0;
		Course[] Courses = new Course[6];
		while(in.hasNextLine()){courseLines.add(in.nextLine());}
		
		for(String i: courseLines){
			in = new Scanner(i);
			in.useDelimiter(",");
			
			Courses[count].setCourseCode(in.next());
			Courses[count].setCourseNum(in.nextInt());
			Courses[count].setSection(in.next());
			Courses[count].setCourseName(in.next());
			Courses[count].setBuilding(in.next());
			Courses[count].setRoomNum(in.nextInt());
			Courses[count].setDays(in.next());
			Courses[count].setTimeRange(in.nextDouble(),in.nextDouble());
			count++;
		}
		return Courses;
		
	}
}
