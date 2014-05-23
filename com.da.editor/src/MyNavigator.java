import org.eclipse.ui.navigator.CommonNavigator;

import com.da.editor.cnf.NavigatorRoot;


public class MyNavigator extends CommonNavigator {

	public MyNavigator() {
	
	}

	@Override
	protected Object getInitialInput() {
		return new NavigatorRoot();
	}
	
}
