package com.da.editor.markerview;

import org.eclipse.ui.views.markers.MarkerField;
import org.eclipse.ui.views.markers.MarkerItem;

public class MyMarkerField extends MarkerField {

	public MyMarkerField() {
		super();
	}

	@Override
	public String getValue(MarkerItem item) {
		return "Test";
		//return item.getMarker().getResource().getProject().getName();  
	}

}
