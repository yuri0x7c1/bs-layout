package com.github.yuri0x7c1.vaadin.addon.bslayout;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.github.yuri0x7c1.vaadin.addon.bslayout.BsColumn.Size;

/**
 *
 * @author yuri0x7c1
 *
 */
public class BsLayoutTest {
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

}