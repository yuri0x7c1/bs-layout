package com.github.yuri0x7c1.vaadin.addon.bscard;

import com.github.yuri0x7c1.vaadin.addon.bslayout.BsContainer;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/** Test view for manual and automated testing of the component.
 *
 */
@Route("")
public class ExampleView extends VerticalLayout {

    public ExampleView() {
    	BsContainer container = new BsContainer();
    }
}
