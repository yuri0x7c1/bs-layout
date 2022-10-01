package com.github.yuri0x7c1.vaadin.addon.bslayout;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.github.yuri0x7c1.vaadin.addon.bslayout.BsColumn.Size;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

/**
 *
 * @author yuri0x7c1
 *
 */
@Tag("bs-row")
@JsModule("./bs-layout/bs-row.js")
public class BsRow extends Component implements HasComponents, HasStyle {

	private final Map<Size, Integer> defaultSizes = new HashMap<>();

	public BsColumn[] addColumns(BsColumn ...columns) {
		for (BsColumn column : columns) {
			add(column);
			if (!defaultSizes.isEmpty()) {
				for (Size size : defaultSizes.keySet()) {
					if (defaultSizes.get(size) != 0) {
						column.addSize(size, defaultSizes.get(size));
					}
					else {
						column.addSize(size);
					}
				}
			}
		}
		return columns;
	}

	public BsColumn addColumn(BsColumn column) {
		return addColumns(column)[0];
	}

	public BsColumn addColumn() {
		return addColumn(new BsColumn());
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
		defaultSizes.put(size, 0);
	}

	public void addDefaultSize(Size size, int sizeValue) {
		Size.validateSizeValue(sizeValue);
		defaultSizes.put(size, sizeValue);
	}

	public BsRow withColumns(BsColumn ...columns) {
		addColumns(columns);
		return this;
	}

	public BsRow withColumn(BsColumn column) {
		addColumn(column);
		return this;
	}

	public BsRow withDefaultSizes(Map<Size, Integer> defaultSizes) {
		setDefaultSizes(defaultSizes);
		return this;
	}

	public BsRow withDefaultSizes(int xs, int sm, int md, int lg, int xl) {
		setDefaultSizes(xs, sm, md, lg, xl);
		return this;
	}

	public BsRow withDefaultSize(Size size) {
		addDefaultSize(size);
		return this;
	}

	public BsRow withDefaultSize(Size size, int sizeValue) {
		addDefaultSize(size, sizeValue);
		return this;
	}
}
