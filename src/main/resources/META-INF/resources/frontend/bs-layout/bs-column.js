
import { LitElement, html, css } from 'lit';
import { BsColumnExtraSmallCss } from './bs-column-xs.css.js';
import { BsColumnSmallCss } from './bs-column-sm.css.js';
import { BsColumnMediumCss } from './bs-column-md.css.js';
import { BsColumnLargeCss } from './bs-column-lg.css.js';
import { BsColumnExtraLargeCss } from './bs-column-xl.css.js';

export class BsColumn extends LitElement {

    static get styles() {
        return [
			css`
				:host {box-sizing: border-box;}
			`,
            BsColumnExtraSmallCss,
            BsColumnSmallCss,
            BsColumnMediumCss,
            BsColumnLargeCss,
            BsColumnExtraLargeCss
        ];
    }

    render() {
        return html`
            <slot></slot>
        `;
    }
};

if(!window.customElements.get('bs-column'))
    window.customElements.define('bs-column', BsColumn);
