import React, {Component} from "react";
import Loading from "./Loading"
import './upload.scss';

class DocumentUpload extends Component{

    constructor(props){
        super(props);
        this.state = {selectedFile: null, isLoading: false};
        this.onSubmit = this.onSubmit.bind(this);
        this.changeHandler = this.changeHandler.bind(this);
    }

    changeHandler = event =>{
        this.setState({
            selectedFile: event.target.files
        })
    };

    onSubmit(event){
        event.preventDefault();
        this.setState({isLoading:true});
        const data = new FormData();
        for(let x = 0; x<this.state.selectedFile.length; x++){
            data.append('file', this.state.selectedFile[x])
        }
        fetch("http://127.0.0.1:5000/upload", {
            method: "POST",
            body: data
        }).then(response =>{
            console.log(response.json());
            window.location = "ResultProcess"
        });

    }

    render() {
        const {isLoading} = this.state;
        if (isLoading) {
            return (
                <Loading/>
            );
        }
        return(


        <div className="frame">
            <form onSubmit={this.onSubmit}>
                <div className="center">
                    <div className="bar" />
                        <div className="title">Drop file to upload</div>
                        <div className="dropzone">
                            <div className="content">
                                <img src="https://100dayscss.com/codepen/upload.svg" className="upload" />
                                <span className="filename" />
                                <input type="file" className="input" multiple onChange={this.changeHandler}/>
                            </div>
                        </div>

                    <img src="https://100dayscss.com/codepen/syncing.svg" className="syncing" />
                    <img src="https://100dayscss.com/codepen/checkmark.svg" className="done" />
                    <button className="upload-btn">Upload file</button>
                </div>
            </form>

        </div>

        )

    }
}

export default DocumentUpload