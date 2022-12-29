import React, {Component} from 'react';

export default class Loading extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div id="ftco-loader" className="img-center">
                <img src="tenor.gif"/>
            </div>
        );
    }
}