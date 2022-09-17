package com.github.yuri0x7c1.vaadin.addon.bslayout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@Tag("bs-row")
@JsModule("./bs-row.js")
public class BsRow extends Component implements HasComponents {

	public BsColumn addColumn(BsColumn column) {
		add(column);
		return column;
	}

	public BsColumn addColumn() {
		return addColumn(new BsColumn());
	}

	public BsRow withColumn(BsColumn column) {
		addColumn(column);
		return this;
	}
}
