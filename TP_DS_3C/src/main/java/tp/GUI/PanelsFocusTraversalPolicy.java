package tp.GUI;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.util.List;

import javax.swing.JButton;

public class PanelsFocusTraversalPolicy extends FocusTraversalPolicy {
	
	private List<Component> order;
	private Component inicial;

	public PanelsFocusTraversalPolicy(List<Component> order, Component inicial) {
		this.order = order;
		this.inicial = inicial;
	}

	@Override
	public Component getComponentAfter(Container focusCycleRoot, Component aComponent) {
        return order.get((order.indexOf(aComponent) + 1) % order.size()); 
    }

	@Override
    public Component getComponentBefore(Container focusCycleRoot, Component aComponent) {
    	return order.get((order.size() + order.indexOf(aComponent) - 1) % order.size());
    }

	@Override
    public Component getFirstComponent(Container cntnr) {
        return order.get(0);
    }

	@Override
    public Component getLastComponent(Container cntnr) {
    	return order.get(order.size() - 1);
    }

	@Override
    public Component getDefaultComponent(Container cntnr) {
    	return order.get(order.indexOf(inicial));
    }

}
