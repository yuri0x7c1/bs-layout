
import { LitElement, html } from 'lit';
import { BsLayoutCss } from './bs-layout.css.js';

export class BsLayout extends LitElement {

    static get styles() {
		return BsLayoutCss;
    }

    render() {
        return html`
            <slot></slot>
        `;
    }
};

if(!window.customElements.get('bs-layout'))
    window.customElements.define('bs-layout', BsLayout);

