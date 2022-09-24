
import { css } from 'lit-element';

export const BsRowCss = css`

    :host {
        display: flex;
        flex-wrap: wrap;
        margin-right: -15px;
        margin-left: -15px;
        box-sizing: border-box;
    }

    :host([no-gutters]) {
        margin-right: 0;
        margin-left: 0;
    }

    :host([no-gutters]) ::slotted(*) {
        padding-right: 0;
        padding-left: 0;
    }
`;
