package com.github.yuri0x7c1.vaadin.addon.bslayout;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.github.yuri0x7c1.vaadin.addon.bslayout.BsColumn.Offset;

/**
 *
 * @author yuri0x7c1
 *
 */
public class BsLayoutOffsetTest {

    @Test
    public void testAddOffset() {
    	for (int i = 1; i <= 11; i++) {
        	BsLayout layout = new BsLayout();
        	BsRow row = layout.addRow();
        	BsColumn column = row.addColumn();

        	column.addOffset(Offset.XS, i);
        	column.addOffset(Offset.SM, i);
        	column.addOffset(Offset.MD, i);
        	column.addOffset(Offset.LG, i);
        	column.addOffset(Offset.XL, i);

        	assertTrue(column.getElement().hasAttribute("offset-xs-" + i));
        	assertTrue(column.getElement().hasAttribute("offset-sm-" + i));
        	assertTrue(column.getElement().hasAttribute("offset-md-" + i));
        	assertTrue(column.getElement().hasAttribute("offset-lg-" + i));
        	assertTrue(column.getElement().hasAttribute("offset-xl-" + i));
    	}
	}

    @Test
    public void testSetOffsets() {
    	BsLayout layout = new BsLayout();
    	BsRow row = layout.addRow();
    	BsColumn column = row.addColumn();

    	column.setOffsets(1, 2, 3, 4, 6);

    	assertTrue(column.getElement().hasAttribute("offset-xs-1"));
    	assertTrue(column.getElement().hasAttribute("offset-sm-2"));
    	assertTrue(column.getElement().hasAttribute("offset-md-3"));
    	assertTrue(column.getElement().hasAttribute("offset-lg-4"));
    	assertTrue(column.getElement().hasAttribute("offset-xl-6"));
	}

    @Test
    public void testOffsetAttributeOvewrite() {
    	BsLayout layout = new BsLayout();
    	BsRow row = layout.addRow();
    	BsColumn column = row.addColumn();

    	column.addOffset(Offset.SM, 3);
    	column.addOffset(Offset.SM, 4);

    	assertFalse(column.getElement().hasAttribute("offset-sm-3"));
    	assertTrue(column.getElement().hasAttribute("offset-sm-4"));
    }

    @Test
    public void testOffsetBoundaries() {
    	BsLayout layout = new BsLayout();
    	BsRow row = layout.addRow();
    	BsColumn column = row.addColumn();

    	assertThrows(RuntimeException.class, () -> column.addOffset(Offset.SM, 0));
    	assertThrows(RuntimeException.class, () -> column.addOffset(Offset.SM, 12));
    }
}