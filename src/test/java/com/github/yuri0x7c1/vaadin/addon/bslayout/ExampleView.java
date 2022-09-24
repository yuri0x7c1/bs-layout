package com.github.yuri0x7c1.vaadin.addon.bslayout;

import com.github.yuri0x7c1.vaadin.addon.bslayout.BsColumn.Offset;
import com.github.yuri0x7c1.vaadin.addon.bslayout.BsColumn.Size;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * @author yuri0x7c1
 */
@Route("")
public class ExampleView extends VerticalLayout {

	enum ExampleCssStyle {
		BORDER("border", "1px solid");

		private final String attr;
		private final String value;

		private ExampleCssStyle(String attr, String value) {
			this.attr = attr;
			this.value = value;
		}

		public String getAttr() {
			return attr;
		}

		public String getValue() {
			return value;
		}
	}

	private BsColumn addCssStyles(BsColumn column) {
		for (ExampleCssStyle s : ExampleCssStyle.values()) {
			column.getElement().getStyle().set(s.getAttr(), s.getValue());
		}
		return column;
	}

    public ExampleView() {
    	BsLayout container = new BsLayout()
			.withRow(new BsRow()
					.withColumn(addCssStyles(new BsColumn(new Label("Column 1-1")).withSize(Size.MD, 6)))
					.withColumn(addCssStyles(new BsColumn(new Label("Column 1-2")).withSize(Size.MD, 3)))
					.withColumn(addCssStyles(new BsColumn(new Label("Column 1-3")).withSize(Size.MD, 3)))
			)
			.withRow(new BsRow()
					.withColumn(addCssStyles(new BsColumn(new Label("Column 2-1")))
							.withSize(Size.MD, 6)
							.withOffset(Offset.MD, 6))
			);

    	add(container);
    }
}
