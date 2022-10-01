package com.github.yuri0x7c1.vaadin.addon.bslayout;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BsLayoutTest {

	@Test
	public void testAddRowAndAddColumn() {
    	BsLayout layout = new BsLayout();
    	BsRow row1 = layout.addRow();
    	row1.addColumn();
    	row1.addColumn();

    	BsRow row2 = layout.addRow(new BsRow());
    	row2.addColumn(new BsColumn());
    	row2.addColumn(new BsColumn());

    	assertEquals(layout.getRows().length, 2);
    	assertEquals(row1.getColumns().length, 2);
    	assertEquals(row2.getColumns().length, 2);
	}

	@Test
	public void testAddRowsAndAddColumns() {
    	BsLayout layout = new BsLayout();
    	BsRow rows[]  = layout.addRows(new BsRow(), new BsRow());
    	for (BsRow row : rows) {
    		row.addColumns(new BsColumn(), new BsColumn());
    	}

    	assertEquals(layout.getRows().length, 2);
    	for (BsRow row : rows) {
    		assertEquals(row.getColumns().length, 2);
    	}
	}
}
