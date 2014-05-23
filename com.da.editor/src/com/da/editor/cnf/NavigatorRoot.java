package com.da.editor.cnf;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.PlatformObject;

public class NavigatorRoot extends PlatformObject {

	public Set<ParentNode> getParentNodes() {					
		ParentNode node = new ParentNode();
		node.setName("Hello World");
				
		ParentNode node2 = new ParentNode();
		node2.setName("Hallo Welt");
		
		Set<ParentNode> list = new HashSet<ParentNode>();
		list.add(node);		
		list.add(node2);		
		return list;
	}	
}
