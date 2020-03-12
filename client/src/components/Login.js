import React, {Component} from 'react';
import axios from 'axios';

class Login extends Component{

    state={
        username:null,
        password:null
    }

    handleChange = (e) => {
        this.setState({
            [e.target.id]: e.target.value
        })
    }

    handleSubmit = (e) => {
        e.preventDefault();
        this.sendData();     
    }

    sendData = () => {
        let  authorization = 'Basic ' + btoa(this.state.username+':'+this.state.password);
        axios({
            'method': 'post',
            'url': 'http://localhost:8080/login',
            'headers': {
                'Content-Type': 'application/json', 
                authorization
            }
        })
        .then( (response) =>{
            window.sessionStorage.setItem('AuthKey',authorization);
            window.sessionStorage.setItem('Auth',true);
            this.props.history.push("/");
            window.location.reload();  
        });
    }


    render(){
        return(
            <div>
                <form onSubmit={this.handleSubmit}>
                    <label>
                    Username:
                    <input type="text" id="username" onChange={this.handleChange}/>
                    </label>
                    <label>
                    Password:
                    <input type="text" id="password" onChange={this.handleChange}/>
                    </label>
                    <input type="submit" value="Wyślij"/>
                </form>

            </div>
        )
    }

}
export default Login;