package GUI_and_Calendar;

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


public class ScheduleDriver {

	protected Shell shlMcScheduler;
	private Text txtXscript;
	private Text txtCoursePlan;
	private String currentCourseSelected;
	private Table table;
	
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
	 */
	public void open() {
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

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMcScheduler = new Shell();
		shlMcScheduler.setSize(803, 401);
		shlMcScheduler.setText("MC3 Scheduler");
		
		
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
				
				//EDIT
				MenuItem EditMenu = new MenuItem(MenuBar, SWT.CASCADE);
				EditMenu.setText("Edit");
		
					Menu EditCascade = new Menu(EditMenu);
					EditMenu.setMenu(EditCascade);
		
					
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
		
					MenuItem InsertCourseList = new MenuItem(InsertCascade, SWT.NONE);
					InsertCourseList.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
						}
					});
					InsertCourseList.setText("Insert a Course List");
		
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
						currentCourseSelected = cList.getSelection()[0];
					}
				});
				cList.setBounds(0, 0, 557, 315);
				cList.add("MATH TEST");
				cList.add("SCIENCE TEST");
				
				TabItem CalendarTab = new TabItem(WindowTab, SWT.NONE);
				CalendarTab.setText("Calendar");
				
				Composite CalenderWindow = new Composite(WindowTab, SWT.NONE);
				CalenderWindow.setEnabled(false);
				CalendarTab.setControl(CalenderWindow);
				
				table = new Table(CalenderWindow, SWT.BORDER | SWT.FULL_SELECTION);
				table.setBounds(0, 0, 557, 315);
				table.setHeaderVisible(true);
				table.setLinesVisible(true);
				
				TableColumn SunColumn = new TableColumn(table, SWT.NONE);
				SunColumn.setWidth(79);
				SunColumn.setText("Sunday");
				
				TableColumn MonColumn = new TableColumn(table, SWT.NONE);
				MonColumn.setWidth(79);
				MonColumn.setText("Monday");
				
				TableColumn TueColumn = new TableColumn(table, SWT.NONE);
				TueColumn.setWidth(79);
				TueColumn.setText("Tuesday");
				
				TableColumn WedsColumn = new TableColumn(table, SWT.NONE);
				WedsColumn.setWidth(79);
				WedsColumn.setText("Wednesday");
				
				TableColumn ThuColumn = new TableColumn(table, SWT.NONE);
				ThuColumn.setWidth(79);
				ThuColumn.setText("Thursday");
				
				TableColumn FriColumn = new TableColumn(table, SWT.NONE);
				FriColumn.setWidth(79);
				FriColumn.setText("Friday");
				
				TableColumn SatColumn = new TableColumn(table, SWT.NONE);
				SatColumn.setWidth(79);
				SatColumn.setText("Saturday");
		
				
			
				
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
				}
				catch(ArrayIndexOutOfBoundsException error){
					final ErrorDialog err = new ErrorDialog(shlMcScheduler, 1);
					err.open();
				}
			}
		});
		btnAddCourse.setText("Add Course");

	}
}
