package com.github.yuri0x7c1.vaadin.addon.bscard;

import com.github.yuri0x7c1.vaadin.addon.bslayout.BsColumn;
import com.github.yuri0x7c1.vaadin.addon.bslayout.BsContainer;
import com.github.yuri0x7c1.vaadin.addon.bslayout.BsRow;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/** Test view for manual and automated testing of the component.
 *
 */
@Route("")
public class ExampleView extends VerticalLayout {

    public ExampleView() {
    	BsContainer container = new BsContainer();
    	container.setWidth("100%");

    	BsRow row = new BsRow();

    	BsColumn col1 = new BsColumn();
    	col1.getElement().setAttribute("sm-4", "");
    	col1.add(new Label("Column 1"));
    	BsColumn col2 = new BsColumn();
    	col2.getElement().setAttribute("sm-4", "");
    	col2.add(new Label("Column 2"));
    	BsColumn col3 = new BsColumn();
    	col3.getElement().setAttribute("sm-4", "");
    	col3.add(new Label("Column 3"));

    	row.add(col1, col2, col3);
    	container.add(row);
    	add(container);
    }
}
