package GUI_and_Calendar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import Scanners.ProgramEvalReader;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.TableColumn;

public class MC3SB_Interface {

	private String tranS;
	private String courseP;
	protected Shell shell;
	private Text transcript;
	private Text coursePlan;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MC3SB_Interface window = new MC3SB_Interface();
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
		shell.setSize(588, 693);
		shell.setText("MC3 Scheduel Builder");
		
		transcript = new Text(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL);
		transcript.setBounds(10, 48, 228, 322);
		
		coursePlan = new Text(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL);
		coursePlan.setBounds(244, 49, 329, 595);
		
		Label lblTranscript = new Label(shell, SWT.NONE);
		lblTranscript.setBounds(10, 28, 55, 15);
		lblTranscript.setText("Transcript");
		
		Label lblCoursePlan = new Label(shell, SWT.NONE);
		lblCoursePlan.setBounds(244, 28, 78, 15);
		lblCoursePlan.setText("Course Plan");
		
		Button sender = new Button(shell, SWT.NONE);
		sender.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				courseP = coursePlan.getText();
				tranS = transcript.getText();
				ProgramEvalReader a = new ProgramEvalReader(courseP);
			//	for(String i: a.getLines(courseP)){
			//		System.out.println(i + ",");
			//	}
				System.out.println(a.getNeededGenEds());
			//	Course test = new Course();
				
				
			}
		});
		
		
		sender.setBounds(438, 10, 107, 25);
		sender.setText("TAKE IT IN DEEP");
	}
	
	public String getCoursePlan(){
		return courseP;
	}
	public String getTranscript(){
		return tranS;
	}
}
