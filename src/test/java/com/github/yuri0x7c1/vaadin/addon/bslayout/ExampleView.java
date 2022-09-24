package com.github.yuri0x7c1.vaadin.addon.bslayout;

import com.github.yuri0x7c1.vaadin.addon.bslayout.BsColumn.Offset;
import com.github.yuri0x7c1.vaadin.addon.bslayout.BsColumn.Size;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/** Test view for manual and automated testing of the component.
 *
 */
@Route("")
public class ExampleView extends VerticalLayout {

    public ExampleView() {
    	BsLayout container = new BsLayout()
			.withRow(new BsRow()
				.withColumn(new BsColumn(new Label("Column 1")).withSize(Size.MD, 6))
				.withColumn(new BsColumn(new Label("Column 2")).withSize(Size.MD, 3))
				.withColumn(new BsColumn(new Label("Column 3")).withSize(Size.MD, 3))
			)
			.withRow(new BsRow()
				.withColumn(new BsColumn(new Label("Column 4"))
					.withSize(Size.MD, 6)
					.withOffset(Offset.MD, 6))
			);

    	add(container);
    }
}