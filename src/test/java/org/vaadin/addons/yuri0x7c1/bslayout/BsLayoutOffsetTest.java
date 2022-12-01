/*
 * Copyright 2021-2022 yuri0x7c1
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

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.vaadin.addons.yuri0x7c1.bslayout.BsColumn.Offset;

/**
 *
 * @author yuri0x7c1
 *
 */
public class BsLayoutOffsetTest {

    @Test
    public void testAddOffset() {
    	for (int i = 0; i <= 11; i++) {
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

    	column.setOffsets(0, 1, 2, 3, 4);

    	assertTrue(column.getElement().hasAttribute("offset-xs-0"));
    	assertTrue(column.getElement().hasAttribute("offset-sm-1"));
    	assertTrue(column.getElement().hasAttribute("offset-md-2"));
    	assertTrue(column.getElement().hasAttribute("offset-lg-3"));
    	assertTrue(column.getElement().hasAttribute("offset-xl-4"));
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

    	assertThrows(RuntimeException.class, () -> column.addOffset(Offset.SM, -1));
    	assertThrows(RuntimeException.class, () -> column.addOffset(Offset.SM, 12));
    }
}