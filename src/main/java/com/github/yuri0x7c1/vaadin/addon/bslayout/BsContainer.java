package com.github.yuri0x7c1.vaadin.addon.bslayout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@Tag("bs-container")
@JsModule("./bs-container.js")
public class BsContainer extends Component implements HasComponents, HasSize {

	public BsRow addRow(BsRow row) {
		add(row);
		return row;
	}

	public BsRow addRow() {
		return addRow(new BsRow());
	}

	public BsContainer withRow(BsRow row) {
		addRow(row);
		return this;
	}
}
