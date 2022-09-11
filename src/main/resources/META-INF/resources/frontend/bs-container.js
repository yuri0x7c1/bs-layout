
import { LitElement, html } from 'lit-element';
import { BsContainerCss } from './bs-container.css.js';

export class BsContainer extends LitElement {

    static get styles() {
		return BsContainerCss;
    }

    render() {
        return html`
            <slot></slot>
        `;
    }
};

if(!window.customElements.get('bs-container'))
    window.customElements.define('bs-container', BsContainer);

