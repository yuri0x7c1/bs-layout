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
			if (sizeValue < 1 || sizeValue > 12) {
				throw new RuntimeException("Size value must be in range [1-12]!");
			}
			return attrPrefix + "-" + sizeValue;
		}
	}

	public enum Offset {
		XS("offset-xs"), SM("offset-xm"), MD("offset-md"), LG("offset-lg"), XL("offset-xl");

		private final String attrPrefix;

		Offset(String attrPrefix) {
			this.attrPrefix = attrPrefix;
		}

		public String getAttrPrefix() {
			return attrPrefix;
		}

		private String getAttrName(int offsetValue) {
			if (offsetValue < 1 || offsetValue > 12) {
				throw new RuntimeException("Offset value must be in range [1-12]!");
			}
			return attrPrefix + "-" + offsetValue;
		}
	}

	public BsColumn() {}

	public BsColumn(Component... components) {
		add(components);
	}

	public void setSize(Size size) {
		setSize(size, null);
	}

	public void setSize(Size size, Integer sizeValue) {
		getElement().setAttribute(size.getAttrName(sizeValue), "");
	}

	public void setSizes(int xs, int sm, int md, int lg, int xl) {
		setSize(Size.XS, xs);
		setSize(Size.SM, sm);
		setSize(Size.MD, md);
		setSize(Size.LG, lg);
		setSize(Size.XL, xl);
	}


	public void setOffset(Offset offset, int offsetValue) {
		getElement().setAttribute(offset.getAttrName(offsetValue), "");
	}

	public void setOffsets(int xs, int sm, int md, int lg, int xl) {
		setOffset(Offset.XS, xs);
		setOffset(Offset.SM, sm);
		setOffset(Offset.MD, md);
		setOffset(Offset.LG, lg);
		setOffset(Offset.XL, xl);
	}

	public BsColumn withSize(Size size) {
		setSize(size, null);
		return this;
	}

	public BsColumn withSize(Size size, Integer sizeValue) {
		setSize(size, sizeValue);
		return this;
	}

	public BsColumn withSizes(int xs, int sm, int md, int lg, int xl) {
		setSizes(xs, sm, md, lg, xl);
		return this;
	}

	public BsColumn withOffset(Offset offset, Integer offsetValue) {
		setOffset(offset, offsetValue);
		return this;
	}

	public BsColumn withOffsets(int xs, int sm, int md, int lg, int xl) {
		setOffsets(xs, sm, md, lg, xl);
		return this;
	}
}
