package com.da.editor.logic;
import org.eclipse.emf.validation.model.IClientSelector;


public class ValidationDelegateClientSelector implements IClientSelector {

	public static boolean running = false;
	
	@Override
	public boolean selects(Object object) {
		return running;
	}

}
