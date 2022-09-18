package com.github.yuri0x7c1.vaadin.addon.bslayout;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.github.yuri0x7c1.vaadin.addon.bslayout.BsColumn.Size;

public class BsLayoutTest {
    @Test
    public void testSizeAttributes() {
    	BsContainer layout = new BsContainer();
    	BsRow row = layout.addRow();
    	BsColumn column = row.addColumn();
    	column.setSize(Size.MD);

    	assertTrue(column.getElement().hasAttribute(Size.MD.getAttrName(null)));
    }
}