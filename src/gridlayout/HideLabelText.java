package gridlayout;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

/**
 * The Class HideLabelText.
 * 
 * @author Subash Janarthanan
 * 
 */
public class HideLabelText {

	/** The shell. */
	protected Shell shell;
	
	/** The text. */
	private Text text;
	
	/** The text 1. */
	private Text text_1;
	
	/** The text 2. */
	private Text text_2;

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		try {
			HideLabelText window = new HideLabelText();
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
		shell.setSize(698, 399);
		shell.setText("SWT Application");
		
		Composite composite = new Composite(shell, SWT.BORDER);
		composite.setBounds(10, 10, 662, 109);
		GridData data = new GridData();
		data.exclude = false;
        data.horizontalAlignment = SWT.FILL;
		Label lblName = new Label(composite, SWT.BORDER | SWT.WRAP);
		lblName.setAlignment(SWT.CENTER);
		lblName.setBounds(10, 10, 65, 23);
		lblName.setText("Name");
		
		text = new Text(composite, SWT.BORDER);
		text.setBounds(81, 10, 567, 23);
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBounds(81, 39, 567, 21);
		text_1.setLayoutData(data);
		
		Label lblNewLabel = new Label(composite, SWT.BORDER);
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setBounds(10, 72, 65, 23);
		lblNewLabel.setText("Activate");
		
		Button button = new Button(composite, SWT.CHECK);
		button.setBounds(81, 70, 93, 21);
		
		Group grpAdress = new Group(shell, SWT.NONE);
		grpAdress.setText("Write Full Address");
		grpAdress.setBounds(7, 124, 668, 172);
		
		Composite composite_1 = new Composite(grpAdress, SWT.BORDER);
		composite_1.setBounds(3, 15, 662, 154);
		
		text_2 = new Text(composite_1, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
		text_2.setBounds(0, 10, 648, 140);
		text_2.setLayoutData(new GridData(GridData.FILL));
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(218, 314, 75, 25);
		btnNewButton.setText("Save");
		
		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
			}
		});
		btnCancel.setBounds(331, 314, 75, 25);
		btnCancel.setText("Cancel");
		
		Button btnResetData = new Button(shell, SWT.NONE);
		btnResetData.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				text.setText("");
				text_1.setText("");
				text_2.setText("");
				button.setEnabled(false);
				
			}
		});
		btnResetData.setBounds(441, 314, 75, 25);
		btnResetData.setText("Reset Data");
		
		Button btnCheckButton = new Button(shell, SWT.CHECK);
		btnCheckButton.setBounds(94, 316, 93, 21);
		
		btnCheckButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                Button b = (Button) e.widget;
                GridData data = (GridData) text_1.getLayoutData();
                data.exclude = b.getSelection();
                text_1.setVisible(!data.exclude);
                text_1.getParent().setRedraw(true);
                text_1.getParent().update();
                shell.layout(false);
            }
        });
		btnCheckButton.setText("Hide Text");
		

	}
}
