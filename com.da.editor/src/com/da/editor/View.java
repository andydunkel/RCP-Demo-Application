package com.da.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.da.editor.logic.ValidationDelegateClientSelector;

import demomodel.DemomodelFactory;
import demomodel.Person;

public class View extends ViewPart {
	public View() {
	}
	public static final String ID = "com.da.editor.view";

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		parent.setLayout(null);
		
		Button btnExecuteBatchValidation = new Button(parent, SWT.NONE);
		btnExecuteBatchValidation.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				doValidation();
			}
		});
		btnExecuteBatchValidation.setBounds(10, 10, 170, 23);
		btnExecuteBatchValidation.setText("Execute Batch Validation");
	}

	protected void doValidation() {
		ValidationDelegateClientSelector.running = true;

		IBatchValidator validator = (IBatchValidator)ModelValidationService.getInstance()
			.newValidator(EvaluationMode.BATCH);
		validator.setIncludeLiveConstraints(true);
		
		//create Person without name:
		Person p = DemomodelFactory.eINSTANCE.createPerson();				
		Person p1 = DemomodelFactory.eINSTANCE.createPerson();
		Person p2 = DemomodelFactory.eINSTANCE.createPerson();
		
		p2.setName("Andy");
		
		List<Person> listPersons = new ArrayList<Person>();
		listPersons.add(p);
		listPersons.add(p1);
		listPersons.add(p2);
		
		IStatus status = validator.validate(listPersons);
		
		if (!status.isOK()) {
			MessageDialog.openError(getSite().getShell(), "Error", status.getMessage());
		}
		ValidationDelegateClientSelector.running = false;
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		
	}
}