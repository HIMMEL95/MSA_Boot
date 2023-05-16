import axios from "axios";
import React, { Component, useEffect, useState } from "react";
import axios from "axios";

function SetLogin() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  useEffect(() => {

    axios.post("/api/loginProcess.do", {
      member_id_num : id,
      password_enc: pw
    })
    .then(function(response) {
      console.log(response);
    }).catch(function(error) {
      console.log(error);
    });
    
    const StoredUserLoggedInformation = localStorage.getItem("isLoggedIn");

    if (StoredUserLoggedInformation === "LOGIN") {
      setIsLoggedIn(true);
    }
  }, []);

  const loginHandler = (id, pw) => {
    localStorage.setItem("isLoggedIn", "LOGIN");
    setIsLoggedIn(true);
  };

  const logoutHandler = () => {
    localStorage.removeItem("isLoggedIn");
    setIsLoggedIn(false);
  };
}

class LoginForm extends Component {
  state = {
    transactions: [],
  };

  submitData = (e) => {
    const { name, value } = e.target;
    var id = document.getElementById("inputId").value;
    var pw = document.getElementById("inputPw").value;
    this.setState({
      name: value,
    });
    alert(id + " " + pw);

    axios
      .post("localhost:3000/loginProcess.do", {
        id: id,
        pw: pw,
      })
      .then(function (response) {
        console.log(response);
      })
      .catch(function (error) {
        console.log(error);
      });
  };

  render() {
    const { getInput } = this.props;
    return (
      <form>
        <div className="row">
          <div className="mb-3">
            <label htmlFor="inputId" className="form-label">
              ID
            </label>
            <input
              type="text"
              className="form-control"
              id="inputId"
              placeholder="아이디를 입력하세요"
              onChange={this.props.getInput}
            />
          </div>
        </div>
        <div className="row">
          <div className="mb-3">
            <label htmlFor="inputPw" className="form-label">
              Password
            </label>
            <input
              type="password"
              className="form-control"
              id="inputPw"
              placeholder="비밀번호를 입력하세요"
              onChange={this.props.getInput}
            />
          </div>
        </div>
        <div className="row">
          <div className="mb-3">
            <button
              type="submit"
              className="btn btn-dark loginBtn"
              onClick={this.submitData}
            >
              Login
            </button>
          </div>
        </div>
      </form>
    );
  }
}

export default LoginForm;
