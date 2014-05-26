package com.da.editor;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import com.da.editor.markerview.MyMarkerView;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(true);
		layout.setFixed(false);
		
		//add view to the left:
		layout.addStandaloneView("com.da.editor.cnf.view", true, IPageLayout.LEFT, 0.3f, layout.getEditorArea());
		
		//bottom folder with two views
        IFolderLayout bottom = layout.createFolder("bottom", IPageLayout.BOTTOM, 0.70f, layout.getEditorArea());  

        bottom.addView(View.ID);
        bottom.addView("org.eclipse.pde.runtime.LogView");			
        bottom.addView(MyMarkerView.ID);
	}

}
