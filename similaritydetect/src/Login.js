import React, {Component} from "react";
import Loading from "./Loading"

class Login extends Component{

    constructor(props){
        super(props);
        this.state={username:'', password:'', isLoading:false};
        this.changeHandler = this.changeHandler.bind(this);
        this.handleLogin = this.handleLogin.bind(this);
    }

    changeHandler = event=>
        this.setState({[event.target.name]: event.target.value});


    handleLogin(event){
        event.preventDefault();
        this.setState({isLoading: true})
        const data= new FormData(event.target);
        const user = {
            email: this.state.email,
            password: this.state.password
        };
        console.log(user)
        fetch("http://127.0.0.1:5000/users/login", {
            method: "POST",
            body: JSON.stringify(user),
            headers:{
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
        }).then(response =>{
            console.log(response);
            if(response.status===200){
                response.json().then(data=>{
                    localStorage.setItem('usertoken', data.token);
                    window.location = "DocumentUpload";
                });
            }else if(response.status===404){
                alert("Incorrect Email/Password Combination!");
                window.location = "";
            }else{
                alert("User Doesn't Exist!");
                window.location = ""
            }
        })
            // .then(response =>{
        //     if(!response.error)
        //     return response.json()
        // }).then(data=>
        //     localStorage.setItem('usertoken',data.token);
        //     return data.token
        // })

    }

    render() {
        const {isLoading} = this.state;
        if (isLoading) {
            return (
                <Loading/>
            );
        }
        return (
            <div>
                <title>Login V3</title>
                <meta charSet="UTF-8" />
                <meta name="viewport" content="width=device-width, initial-scale=1" />
                <div className="limiter">
                    <div className="container-login100" style={{backgroundImage: 'url("images/bg-01.jpg")'}}>
                        <div className="wrap-login100">
                            <form className="login100-form validate-form" onSubmit={this.handleLogin} >
                <span className="login100-form-logo">
                  <i className="zmdi zmdi-search-in-file" />
                </span>
                                <span className="login100-form-title p-b-34 p-t-27">
                                        <h1>Plagiarism Detection</h1>
                                        <br/>
                                        <h4> Log in</h4>
                </span>
                                <div className="wrap-input100 validate-input" data-validate="Enter E-mail">
                                    <input className="input100" type="text" name="email" placeholder="E-mail" value={this.state.email} onChange={this.changeHandler} />
                                    <span className="focus-input100" data-placeholder="" />
                                </div>
                                <div className="wrap-input100 validate-input" data-validate="Enter password">
                                    <input className="input100" type="password" name="password" placeholder="Password" value={this.state.password} onChange={this.changeHandler} />
                                    <span className="focus-input100" data-placeholder="" />
                                </div>
                                <div className="contact100-form-checkbox">
                                    <input className="input-checkbox100" id="ckb1" type="checkbox" name="remember-me" />
                                    <label className="label-checkbox100" htmlFor="ckb1">
                                        Remember me
                                    </label>
                                </div>
                                <div className="container-login100-form-btn">
                                    <button className="login100-form-btn" type="submit">
                                        Login
                                    </button>
                                </div>
                                <div className="text-center p-t-90">
                                    <a className="txt1" href="#">
                                        Forgot Password?
                                    </a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div id="dropDownSelect1" />
                {/*===============================================================================================*/}
                {/*===============================================================================================*/}
                {/*===============================================================================================*/}
                {/*===============================================================================================*/}
                {/*===============================================================================================*/}
                {/*===============================================================================================*/}
                {/*===============================================================================================*/}
            </div>
        );
    }
}

export default Login;