package com.da.editor;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(true);
		layout.setFixed(false);
		
		//add view to the left:
		layout.addStandaloneView("com.da.editor.cnf.view", true, IPageLayout.LEFT, 0.3f, layout.getEditorArea());
		
		//add view to the top
		layout.addStandaloneView(View.ID, true, IPageLayout.BOTTOM, 0.7f, layout.getEditorArea());		

		
	}

}
