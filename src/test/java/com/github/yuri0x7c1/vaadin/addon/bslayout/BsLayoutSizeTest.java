package com.github.yuri0x7c1.vaadin.addon.bslayout;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.github.yuri0x7c1.vaadin.addon.bslayout.BsColumn.Size;

/**
 *
 * @author yuri0x7c1
 *
 */
public class BsLayoutSizeTest {

    @Test
    public void testAddSize0() {
    	BsLayout layout = new BsLayout();
    	BsRow row = layout.addRow();
    	BsColumn column = row.addColumn();
    	column.addSize(Size.XS);
    	column.addSize(Size.SM);
    	column.addSize(Size.MD);
    	column.addSize(Size.LG);
    	column.addSize(Size.XL);

    	assertTrue(column.getElement().hasAttribute("xs"));
    	assertTrue(column.getElement().hasAttribute("sm"));
    	assertTrue(column.getElement().hasAttribute("md"));
    	assertTrue(column.getElement().hasAttribute("lg"));
    	assertTrue(column.getElement().hasAttribute("xl"));
    }

    @Test
    public void testAddSize() {
    	for (int i = 1; i <= 12; i++) {
        	BsLayout layout = new BsLayout();
        	BsRow row = layout.addRow();
        	BsColumn column = row.addColumn();

        	column.addSize(Size.XS, i);
        	column.addSize(Size.SM, i);
        	column.addSize(Size.MD, i);
        	column.addSize(Size.LG, i);
        	column.addSize(Size.XL, i);

        	assertTrue(column.getElement().hasAttribute("xs-" + i));
        	assertTrue(column.getElement().hasAttribute("sm-" + i));
        	assertTrue(column.getElement().hasAttribute("md-" + i));
        	assertTrue(column.getElement().hasAttribute("lg-" + i));
        	assertTrue(column.getElement().hasAttribute("xl-" + i));
    	}
	}

    @Test
    public void testAddSizeAuto() {
    	BsLayout layout = new BsLayout();
    	BsRow row = layout.addRow();
    	BsColumn column = row.addColumn();
    	column.addSizeAuto(Size.XS);
    	column.addSizeAuto(Size.SM);
    	column.addSizeAuto(Size.MD);
    	column.addSizeAuto(Size.LG);
    	column.addSizeAuto(Size.XL);

    	assertTrue(column.getElement().hasAttribute("xs-auto"));
    	assertTrue(column.getElement().hasAttribute("sm-auto"));
    	assertTrue(column.getElement().hasAttribute("md-auto"));
    	assertTrue(column.getElement().hasAttribute("lg-auto"));
    	assertTrue(column.getElement().hasAttribute("xl-auto"));
	}

    @Test
    public void testSetSizes() {
    	BsLayout layout = new BsLayout();
    	BsRow row = layout.addRow();
    	BsColumn column = row.addColumn();

    	column.setSizes(12, 6, 4, 3, 2);

    	assertTrue(column.getElement().hasAttribute("xs-12"));
    	assertTrue(column.getElement().hasAttribute("sm-6"));
    	assertTrue(column.getElement().hasAttribute("md-4"));
    	assertTrue(column.getElement().hasAttribute("lg-3"));
    	assertTrue(column.getElement().hasAttribute("xl-2"));
	}

    @Test
    public void testSizeAttributeOvewrite() {
    	BsLayout layout = new BsLayout();
    	BsRow row = layout.addRow();
    	BsColumn column = row.addColumn();

    	column.addSize(Size.SM);
    	column.addSizeAuto(Size.SM);
    	column.addSize(Size.SM, 3);
    	column.addSize(Size.SM, 4);

    	assertFalse(column.getElement().hasAttribute("sm"));
    	assertFalse(column.getElement().hasAttribute("sm-auto"));
    	assertFalse(column.getElement().hasAttribute("sm-3"));
    	assertTrue(column.getElement().hasAttribute("sm-4"));
    }

    @Test
    public void testSizeBoundaries() {
    	BsLayout layout = new BsLayout();
    	BsRow row = layout.addRow();
    	BsColumn column = row.addColumn();

    	assertThrows(RuntimeException.class, () -> column.addSize(Size.SM, 0));
    	assertThrows(RuntimeException.class, () -> column.addSize(Size.SM, 13));
    }

    @Test
    public void testLayoutAddDefaultSize() {
    	BsLayout layout = new BsLayout();
    	layout.addDefaultSize(Size.XS, 12);
    	BsRow row = layout.addRow();
    	BsColumn column = row.addColumn();

    	assertTrue(column.getElement().hasAttribute("xs-12"));
    }
}
