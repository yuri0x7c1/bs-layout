package com.github.yuri0x7c1.vaadin.addon.bslayout;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
			applyDefaultSizes();
			add(column);
		}
		return columns;
	}

	public BsColumn addColumn(BsColumn column) {
		return addColumns(column)[0];
	}

	public BsColumn addColumn() {
		return addColumn(new BsColumn());
	}

	public BsColumn[] getColumns() {
		return getChildren().filter(c -> c instanceof BsColumn).toArray(BsColumn[]::new);
	}

	private void applyDefaultSizes() {
		for (BsColumn column : getColumns()) {
			for (Size size : defaultSizes.keySet()) {
				if (defaultSizes.get(size) != Size.NO_SIZE_ATRR_NAME_INDEX) {
					column.addSize(size, defaultSizes.get(size));
				}
				else {
					column.addSize(size);
				}
			}
		}
	}

	public Map<Size, Integer> getDefaultSizes() {
		return Collections.unmodifiableMap(defaultSizes);
	}

	public void setDefaultSizes(Map<Size, Integer> defaultSizes) {
		Objects.requireNonNull(defaultSizes);
		this.defaultSizes.clear();
		this.defaultSizes.putAll(defaultSizes);
		applyDefaultSizes();
	}

	public void setDefaultSizes(int xs, int sm, int md, int lg, int xl) {
		Map<Size, Integer> defaultSizes = new HashMap<>();
		defaultSizes.put(Size.XS, xs);
		defaultSizes.put(Size.SM, sm);
		defaultSizes.put(Size.MD, md);
		defaultSizes.put(Size.LG, lg);
		defaultSizes.put(Size.XL, xl);
		setDefaultSizes(defaultSizes);
	}

	public void addDefaultSize(Size size) {
		defaultSizes.put(size, Size.NO_SIZE_ATRR_NAME_INDEX);
		applyDefaultSizes();
	}

	public void addDefaultSize(Size size, int sizeValue) {
		Size.validateSizeValue(sizeValue);
		defaultSizes.put(size, sizeValue);
		applyDefaultSizes();
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
