package com.da.editor.cnf;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;


public class MyNavigatorContentProvider implements ITreeContentProvider {

	@Override
	public void dispose() {

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof NavigatorRoot) {
			NavigatorRoot root = (NavigatorRoot) parentElement;
			return root.getParentNodes().toArray();
		}
		return null;
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof NavigatorRoot) {
			NavigatorRoot root = (NavigatorRoot) element;
			if (root.getParentNodes().size() > 0) {
				return true;
			} else {
				return false;
			}
		}
		
		return false;
	}

}
