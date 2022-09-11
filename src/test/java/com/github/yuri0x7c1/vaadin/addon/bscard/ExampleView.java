package com.github.yuri0x7c1.vaadin.addon.bscard;

import com.github.yuri0x7c1.vaadin.addon.bslayout.BsColumn;
import com.github.yuri0x7c1.vaadin.addon.bslayout.BsColumn.Size;
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

    	BsRow row = container.addRow();
    	BsColumn col1 = row.addColumn();
    	col1.add(new Label("Column 1"));
    	col1.setSize(Size.SM, 4);

    	BsColumn col2 = row.addColumn();
    	col2.add(new Label("Column 2"));
    	col2.setSize(Size.SM, 4);

    	BsColumn col3 = row.addColumn();
    	col3.add(new Label("Column 3"));
    	col3.setSize(Size.SM, 4);

    	add(container);
    }
}
