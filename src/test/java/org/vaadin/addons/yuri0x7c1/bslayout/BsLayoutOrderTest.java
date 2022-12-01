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
import org.vaadin.addons.yuri0x7c1.bslayout.BsColumn.Order;

/**
 *
 * @author yuri0x7c1
 *
 */
public class BsLayoutOrderTest {

    @Test
    public void testAddOrder() {
    	for (int i = 0; i <= 12; i++) {
        	BsLayout layout = new BsLayout();
        	BsRow row = layout.addRow();
        	BsColumn column = row.addColumn();

        	column.addOrder(Order.XS, i);
        	column.addOrder(Order.SM, i);
        	column.addOrder(Order.MD, i);
        	column.addOrder(Order.LG, i);
        	column.addOrder(Order.XL, i);

        	assertTrue(column.getElement().hasAttribute("order-xs-" + i));
        	assertTrue(column.getElement().hasAttribute("order-sm-" + i));
        	assertTrue(column.getElement().hasAttribute("order-md-" + i));
        	assertTrue(column.getElement().hasAttribute("order-lg-" + i));
        	assertTrue(column.getElement().hasAttribute("order-xl-" + i));
    	}
	}

    @Test
    public void testSetOrders() {
    	BsLayout layout = new BsLayout();
    	BsRow row = layout.addRow();
    	BsColumn column = row.addColumn();

    	column.setOrders(1, 2, 3, 4, 5);

    	assertTrue(column.getElement().hasAttribute("order-xs-1"));
    	assertTrue(column.getElement().hasAttribute("order-sm-2"));
    	assertTrue(column.getElement().hasAttribute("order-md-3"));
    	assertTrue(column.getElement().hasAttribute("order-lg-4"));
    	assertTrue(column.getElement().hasAttribute("order-xl-5"));
	}

    @Test
    public void testFirstAndLastOrders() {
    	BsLayout layout = new BsLayout();
    	BsRow row = layout.addRow();
    	BsColumn column = row.addColumn();

    	column.addOrderFirst(Order.XS);
    	column.addOrderLast(Order.LG);

    	assertTrue(column.getElement().hasAttribute("order-xs-first"));
    	assertTrue(column.getElement().hasAttribute("order-lg-last"));
    }

    @Test
    public void testOrderAttributeOvewrite() {
    	BsLayout layout = new BsLayout();
    	BsRow row = layout.addRow();
    	BsColumn column = row.addColumn();

    	column.addOrder(Order.SM, 3);
    	column.addOrder(Order.SM, 4);

    	assertFalse(column.getElement().hasAttribute("order-sm-3"));
    	assertTrue(column.getElement().hasAttribute("order-sm-4"));
    }

    @Test
    public void testOrderBoundaries() {
    	BsLayout layout = new BsLayout();
    	BsRow row = layout.addRow();
    	BsColumn column = row.addColumn();

    	assertThrows(RuntimeException.class, () -> column.addOrder(Order.SM, -1));
    	assertThrows(RuntimeException.class, () -> column.addOrder(Order.SM, 13));
    }
}