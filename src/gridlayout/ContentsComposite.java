package gridlayout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * The Class ContentsComposite.
 * 
 * @author Subash Janarthanan
 * 
 */
public class ContentsComposite extends Composite {
	
	/** The button one. */
	Button buttonOne = null;
	
	/** The txt input. */
	Text txtInput = null;
	
	/** The button two. */
	Button buttonTwo = null;

	/** The state. */
	boolean state = true;

	/**
	 * Instantiates a new contents composite.
	 *
	 * @param parent the parent
	 * @param style the style
	 */
	public ContentsComposite(Composite parent, int style) {
		super(parent, style);

		GridLayout layout = new GridLayout(1, false);
		setLayout(layout);

		buttonOne = new Button(this, SWT.PUSH);
		buttonOne.setText("upper Button");

		txtInput = new Text(this, SWT.BORDER);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, false);
		data.exclude = false;
		txtInput.setLayoutData(data);

		buttonTwo = new Button(this, SWT.PUSH);
		buttonTwo.setText("lower Button");

		buttonOne.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {

				GridData griddata = (GridData) txtInput.getLayoutData();
				griddata.exclude = state;
				txtInput.setVisible(!state);
				txtInput.getParent().layout(false);
				state = !state;
			}
		});
	}

}
