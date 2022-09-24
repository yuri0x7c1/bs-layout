package com.github.yuri0x7c1.vaadin.addon.bslayout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

/**
 *
 * @author yuri0x7c1
 *
 */
@Tag("bs-container")
@JsModule("./bs-container.js")
public class BsLayout extends Component implements HasComponents, HasSize {

	public BsRow addRow(BsRow row) {
		add(row);
		return row;
	}

	public BsRow addRow() {
		return addRow(new BsRow());
	}

	public BsLayout withRow(BsRow row) {
		addRow(row);
		return this;
	}
}
