
import { LitElement, html } from 'lit';
import { BsRowCss } from './bs-row.css.js';

export class BsRow extends LitElement {

    static get styles() {
        return BsRowCss;
    }

    render() {
        return html`
            <slot></slot>
        `;
    }
};

if(!window.customElements.get('bs-row'))
    window.customElements.define('bs-row', BsRow);
