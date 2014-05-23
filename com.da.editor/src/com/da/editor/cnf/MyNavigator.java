package com.da.editor.cnf;
import org.eclipse.ui.navigator.CommonNavigator;


public class MyNavigator extends CommonNavigator {

	public MyNavigator() {
	
	}

	@Override
	protected Object getInitialInput() {
		return new NavigatorRoot();
	}
	
}
