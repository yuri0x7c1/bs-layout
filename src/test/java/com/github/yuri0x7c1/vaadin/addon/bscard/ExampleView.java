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
    	BsContainer container = new BsContainer()
			.withRow(new BsRow()
				.withColumn(new BsColumn(new Label("Column 1")).withSize(Size.MD, 6))
				.withColumn(new BsColumn(new Label("Column 2")).withSize(Size.MD, 3))
				.withColumn(new BsColumn(new Label("Column 3")).withSize(Size.MD, 3))
			);

    	add(container);
    }
}
