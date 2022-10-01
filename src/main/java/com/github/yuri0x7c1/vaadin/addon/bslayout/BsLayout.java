package com.github.yuri0x7c1.vaadin.addon.bslayout;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.github.yuri0x7c1.vaadin.addon.bslayout.BsColumn.Size;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

/**
 *
 * @author yuri0x7c1
 *
 */
@Tag("bs-layout")
@JsModule("./bs-layout/bs-layout.js")
public class BsLayout extends Component implements HasComponents, HasSize, HasStyle {

	private final Map<Size, Integer> defaultSizes = new HashMap<>();

	public BsRow[] addRows(BsRow ...rows) {
		for (BsRow row : rows) {
			add(row);
			if (!defaultSizes.isEmpty()) {
				row.setDefaultSizes(defaultSizes);
			}
		}
		return rows;
	}

	public BsRow addRow(BsRow row) {
		return addRows(row)[0];
	}

	public BsRow addRow() {
		return addRow(new BsRow());
	}

	public Map<Size, Integer> getDefaultSizes() {
		return Collections.unmodifiableMap(defaultSizes);
	}

	public void setDefaultSizes(Map<Size, Integer> defaultSizes) {
		this.defaultSizes.clear();
		this.defaultSizes.putAll(defaultSizes);
	}

	public void setDefaultSizes(int xs, int sm, int md, int lg, int xl) {
		addDefaultSize(Size.XS, xs);
		addDefaultSize(Size.SM, sm);
		addDefaultSize(Size.MD, md);
		addDefaultSize(Size.LG, lg);
		addDefaultSize(Size.XL, xl);
	}

	public void addDefaultSize(Size size) {
		defaultSizes.put(size, Size.NO_SIZE_ATRR_NAME_INDEX);
	}

	public void addDefaultSize(Size size, int sizeValue) {
		Size.validateSizeValue(sizeValue);
		defaultSizes.put(size, sizeValue);
	}

	public BsLayout withRows(BsRow ...rows) {
		addRows(rows);
		return this;
	}

	public BsLayout withRow(BsRow row) {
		addRow(row);
		return this;
	}

	public BsLayout withDefaultSizes(Map<Size, Integer> defaultSizes) {
		setDefaultSizes(defaultSizes);
		return this;
	}

	public BsLayout withDefaultSizes(int xs, int sm, int md, int lg, int xl) {
		setDefaultSizes(xs, sm, md, lg, xl);
		return this;
	}

	public BsLayout withDefaultSize(Size size) {
		addDefaultSize(size);
		return this;
	}

	public BsLayout withDefaultSize(Size size, int sizeValue) {
		addDefaultSize(size, sizeValue);
		return this;
	}
}
