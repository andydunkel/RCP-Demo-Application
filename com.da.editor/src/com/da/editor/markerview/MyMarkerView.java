package com.da.editor.markerview;

import org.eclipse.ui.views.markers.MarkerSupportView;

public class MyMarkerView extends MarkerSupportView {

	public static final String MARKER_GENERATOR_ID = "com.da.editor.markerContentGenerator";
	
	public static String ID = "com.da.editor.markers.mymarkerview";
	
	public MyMarkerView() {
		super(MARKER_GENERATOR_ID);
	}
}
