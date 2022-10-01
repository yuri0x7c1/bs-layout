/*
 * Copyright 2021-2022 The original authors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.github.yuri0x7c1.vaadin.addon.bslayout;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

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

	private final Map<Size, Integer> defaultSizes = new LinkedHashMap<>();

	public BsRow[] addRows(BsRow ...rows) {
		for (BsRow row : rows) {
			if (!defaultSizes.isEmpty()) {
				row.setDefaultSizes(defaultSizes);
			}
			add(row);
		}
		return rows;
	}

	public BsRow addRow(BsRow row) {
		return addRows(row)[0];
	}

	public BsRow addRow() {
		return addRow(new BsRow());
	}

	public BsRow[] getRows() {
		return getChildren().filter(c -> c instanceof BsRow).toArray(BsRow[]::new);
	}

	private void applyDefaultSizes() {
		for (BsRow row : getRows()) {
			row.setDefaultSizes(getDefaultSizes());
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
