import React, {Component} from 'react';
import Loading from "./Loading"

class ResultsProcess extends Component{
    constructor(props){
        super(props);
        this.state={
            similarityData:[],
            tfidfResults:[],
            viewPath:"",
            similarities:[],
            marks:'',
            selectedDocNo:0,
            reader: new FileReader(),
            isLoading: true
        };
        this.onChange = this.onChange.bind(this);
        this.addMarks = this.addMarks.bind(this);
        this.changeHandler = this.changeHandler.bind(this);
    }


    componentDidMount() {
        this.setState({isLoading: true});
        fetch('http://127.0.0.1:5000/process')
            .then(response => response.json())
            .then(data=>{
                console.log(data);
                const similarity = data.info[0];
                const exactPath = "uploads"+similarity.file.split("uploads")[1];
                this.setState({
                    similarityData: data.info,
                    similarities:data.info[0].info,
                    tfIdfResults: data.tfidResult,
                    viewPath:exactPath,
                    selectedDocNo:0,
                    isLoading: false
                });
            });
    }

    changeHandler = event=>
        this.setState({[event.target.name]: event.target.value});

    onChange(x,event){
        console.log(x);
        const similarity = this.state.similarityData[x];
        const exactPath = "uploads"+similarity.file.split("uploads")[1];
        this.setState({
            similarities:similarity.info,
            viewPath:exactPath,
            selectedDocNo:x
        });
    }

    addMarks(x,marks,event){
        event.preventDefault();
        console.log(x);
        console.log(marks)
    }

    render(){

        const {similarityData,similarities, tfIdfResults,selectedDocNo, isLoading} = this.state;
        if (isLoading) {
            return (
                <Loading/>
            );
        }
        console.log("dataList", this.state.similarityData);
        const keys = Object.keys(similarityData);
        let docs = [];
        let termsList = [];
        for(let x=0;x<keys.length;x++){
            const fileName = similarityData[x].file;
            console.log(fileName);
            const exactFileName = fileName.split("uploads/")[1];
            const exactPath = "uploads"+fileName.split("uploads")[1];
            console.log(exactPath);
            const sim = similarities[x];


            docs.push(<li className="list-group-item" onClick={()=>this.onChange(x)}><b>{exactFileName}</b>
                <hr/>
            <b>Similarity Score</b> {((sim+1)*100/2).toFixed(2)}%
            </li>)
        }
        let docTermsList = [];
        if(tfIdfResults!==undefined) {

            const terms = tfIdfResults[selectedDocNo];
            const termKeys = Object.keys(terms);
            // let docTermsList = []
            termKeys.forEach(key => {
                if (terms[key] < 0.2 && terms[key]>0.1) {
                    docTermsList.push(
                        <li>
                            {key}
                        </li>);
                }
            })
        }



        const path = "http://localhost:3000/"+this.state.viewPath;
        return(
            <div>
                <div className="row">
                    <div id="codeFrameContainer" className="col-md-7">
                        <iframe id="codeFrame" src={path}> </iframe>
                    </div>
                    <div className="col-md-2">
                        <h6 className="header-1" align="center">Similar Terms</h6>
                        <ul>
                            {
                                docTermsList.map(doc=>{
                                    return doc
                                })
                            }
                        </ul>
                    </div>
                    <div id="sidebarContainer" className="col-md-3">
                        <h6 className="header-2" align="center"> Documents </h6>
                        <ul id="listLinks" className="list-group">
                            {
                                docs.map(doc=>{
                                    return doc
                                })
                            }
                            {/*{fullSimilarityData}*/}
                        </ul>
                    </div>
            </div>
            </div>


        )
    }
}

export default  ResultsProcess