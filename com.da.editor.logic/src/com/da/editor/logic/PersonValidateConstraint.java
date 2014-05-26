package com.da.editor.logic;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

import demomodel.Person;

public class PersonValidateConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();		
		EMFEventType eType = ctx.getEventType();
		
		// In the case of batch mode.
		if (eType == EMFEventType.NULL) {
			if (eObj instanceof Person) {
				//Validate Person
				Person p = (Person) eObj;
				
				if (p.getName() == null || p.getName().length() == 0) {
					return ctx.createFailureStatus(new Object[] {eObj.eClass().getName()});
				}				
			} 
		}
		
		return ctx.createSuccessStatus();		
	}
}
