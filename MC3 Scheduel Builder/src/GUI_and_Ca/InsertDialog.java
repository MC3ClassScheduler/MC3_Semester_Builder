package GUI_and_Ca;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;


public class InsertDialog extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text morph;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public InsertDialog(Shell parent, int style, Text txt) {
		super(parent, style);
		morph = txt;
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
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
		shell = new Shell(getParent(), getStyle());
		shell.setSize(450, 300);
		shell.setText(getText());
		
		text = new Text(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL);
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.keyCode == 13){ 
					morph.setText(text.getText());
					shell.close();
				}
			}
		});
		text.setBounds(10, 26, 424, 236);
		
		Label lblCopyAndPaste = new Label(shell, SWT.NONE);
		lblCopyAndPaste.setBounds(42, 5, 392, 15);
		lblCopyAndPaste.setText("Copy and paste the text into the field and press 'Enter.'");
		
		
	}

}
