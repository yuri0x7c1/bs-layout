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

package com.github.yuri0x7c1.vaadin.addon.bslayout;

import com.github.yuri0x7c1.vaadin.addon.bslayout.BsColumn.Offset;
import com.github.yuri0x7c1.vaadin.addon.bslayout.BsColumn.Size;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * @author yuri0x7c1
 */
@Route("")
public class ExampleView extends VerticalLayout {

    public ExampleView() {
    	BsLayout layout = new BsLayout().withRows(
			new BsRow().withColumns(
				new BsColumn(new Label("Column 1-1")).withSize(Size.MD, 6),
				new BsColumn(new Label("Column 1-2")).withSize(Size.MD, 3),
				new BsColumn(new Label("Column 1-3")).withSize(Size.MD, 3)
			),
			new BsRow().withColumn(
				new BsColumn(new Label("Column 2-1"))
					.withSize(Size.MD, 6)
					.withOffset(Offset.MD, 6)
			)
		);

    	add(layout);
    }
}
