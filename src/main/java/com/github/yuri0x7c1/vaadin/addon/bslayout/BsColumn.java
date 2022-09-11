package com.github.yuri0x7c1.vaadin.addon.bslayout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@Tag("bs-column")
@JsModule("./bs-column.js")
public class BsColumn extends Component implements HasComponents {
	public enum Size {
		XS("xs"), SM("xm"), MD("md"), LG("lg"), XL("xl");

		private final String attrPrefix;

		Size(String attrPrefix) {
			this.attrPrefix = attrPrefix;
		}

		public String getAttrPrefix() {
			return attrPrefix;
		}

		private String getAttrName(Integer sizeValue) {
			if (sizeValue == null) return attrPrefix;
			return name().toLowerCase() + "-" + sizeValue;
		}
	}

	public BsColumn() {}

	public BsColumn(Component component) {
		add(component);
	}

	public void setSize(Size size) {
		setSize(size, null);
	}

	public void setSize(Size size, Integer sizeValue) {
		if (sizeValue != null && (sizeValue < 1 || sizeValue > 12)) {
			throw new RuntimeException("Size value must be in range [1-12]!");
		}
		getElement().setAttribute(size.getAttrName(sizeValue), "");
	}
}
