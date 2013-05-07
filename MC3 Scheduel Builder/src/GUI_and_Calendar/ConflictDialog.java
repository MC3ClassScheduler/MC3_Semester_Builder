package GUI_and_Calendar;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
public class ConflictDialog extends Dialog {

	protected Object result;
	protected Shell shlError;
	private int conflictNum;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public ConflictDialog(Shell parent, int style, int cNum) {
		super(parent, style);
		setText("SWT Dialog");
		conflictNum = cNum;
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlError.open();
		shlError.layout();
		Display display = getParent().getDisplay();
		while (!shlError.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlError = new Shell(getParent(), getStyle());
		shlError.setSize(300, 175);
		shlError.setText("ERROR!!!!!!");
		
		Label lblSelectACourse = new Label(shlError, SWT.NONE);
		lblSelectACourse.setBounds(20, 42, 253, 35);
		lblSelectACourse.setText("Failed to add course! \nThis course conflicts with "+conflictNum+" course(s)!");
		
		Button CloseButton = new Button(shlError, SWT.NONE);
		CloseButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shlError.close();
			}
		});
		CloseButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		CloseButton.setBounds(106, 83, 75, 25);
		CloseButton.setText("Close");

	}
}