package GUI_and_Ca;

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


public class ScheduleDriver {

	protected Shell shell;

	//protected SubTest temp;
	private Text SelectedCoursesText;
	private Text txtInsertYourTranscript;
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(803, 401);
		shell.setText("SWT Application");
		final InsertDialog dial = new InsertDialog(shell, 1);
		
		
		//MENU BAR
		Menu MenuBar = new Menu(shell, SWT.BAR);
		shell.setMenuBar(MenuBar);
		
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
								shell.close();
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
									dial.open();
									
							}
						});
					InsertTranscript.setText("Insert Transcript");
		
					MenuItem InsertCoursePlan = new MenuItem(InsertCascade, SWT.NONE);
					InsertCoursePlan.setText("Insert Course Plan");
		
					MenuItem InsertCourseList = new MenuItem(InsertCascade, SWT.NONE);
					InsertCourseList.setText("Insert a Course List");
		
		//WINDOW TABS
		TabFolder WindowTab = new TabFolder(shell, SWT.NONE);
		WindowTab.setBounds(0, 0, 565, 343);
		
			//TRANSCRIPT TAB
			TabItem TranscriptTab = new TabItem(WindowTab, SWT.NONE);
			TranscriptTab.setText("Transcript");
		
				Composite TranscriptWindow = new Composite(WindowTab, SWT.NONE);
				TranscriptTab.setControl(TranscriptWindow);
		
					txtInsertYourTranscript = new Text(TranscriptWindow, SWT.BORDER);
					txtInsertYourTranscript.setText("Insert your Transcript!");
					txtInsertYourTranscript.setBounds(0, 0, 557, 315);
		
					
			//COURSE PLAN TAB
			TabItem CoursePlanTab = new TabItem(WindowTab, SWT.NONE);
			CoursePlanTab.setText("Course Plan");
		
				Composite CoursePlanWindow = new Composite(WindowTab, SWT.NONE);
				CoursePlanTab.setControl(CoursePlanWindow);
		
				
			//COURSE LIST TAB
			TabItem CourseListTab = new TabItem(WindowTab, SWT.NONE);
			CourseListTab.setText("Course List");
		
				Composite CourseListWindow = new Composite(WindowTab, SWT.NONE);
				CourseListTab.setControl(CourseListWindow);
		
				
				
		Label LabelSelectedCourses = new Label(shell, SWT.NONE);
		LabelSelectedCourses.setLocation(626, 10);
		LabelSelectedCourses.setSize(112, 15);
		LabelSelectedCourses.setText("Selected Courses");
		
		Composite SelectedCoursesWindow = new Composite(shell, SWT.NONE);
		SelectedCoursesWindow.setBounds(571, 23, 206, 310);
		
		SelectedCoursesText = new Text(SelectedCoursesWindow, SWT.BORDER);
		SelectedCoursesText.setBounds(10, 10, 186, 290);

	}
}
