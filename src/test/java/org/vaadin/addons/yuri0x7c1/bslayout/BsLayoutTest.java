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

package org.vaadin.addons.yuri0x7c1.bslayout;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.vaadin.addons.yuri0x7c1.bslayout.BsColumn;
import org.vaadin.addons.yuri0x7c1.bslayout.BsLayout;
import org.vaadin.addons.yuri0x7c1.bslayout.BsRow;

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
