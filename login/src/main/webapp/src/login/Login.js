import React, { Component, useEffect } from "react";
import "bootstrap/dist/css/bootstrap.css";
import "./Login.css";
import logo from "./MZC_logo.svg";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faGoogle } from "@fortawesome/free-brands-svg-icons";
import { faFacebook } from "@fortawesome/free-brands-svg-icons";
import LoginForm from "./LoginForm";

class Login extends Component {
  constructor() {
    super();
    this.state = {
      inputValue: { idValue: "", pwValue: "" },
    };
  }

  handleInput = (e) => {
    const { name, value } = e.target;
    this.setState({
      inputValue: { ...this.state.inputValue, [name]: value },
    });
    console.log(e.target.value);
  };

  render() {
    return (
      <div className="App container-lg">
        <header className="App-header">
          <div>
            <div className="card" style={{ width: "50rem" }}>
              <div className="card-body">
                <h5 className="card-title">Login</h5>
                <div className="row">
                  <div className="col">
                    <LoginForm getInput={this.handleInput} />
                    <div className="row">
                      <div className="mb-3">
                        <a href="#" className="btn forgetBtn">
                          Forgot your password?
                        </a>
                      </div>
                    </div>
                    <div className="row">
                      <div className="col mb-3">
                        <a
                          href="#"
                          className="btn btn-icon btn-secondary btn-google btn-lg w-100"
                        >
                          <FontAwesomeIcon icon={faGoogle} className="me-2" />
                          Google
                        </a>
                      </div>
                      <div className="col mb-3">
                        <a
                          href="#"
                          className="btn btn-icon btn-secondary btn-facebook btn-lg"
                        >
                          <FontAwesomeIcon icon={faFacebook} className="me-2" />
                          Facebook
                        </a>
                      </div>
                    </div>
                  </div>
                  <div className="col img">
                    <img src={logo} className="App-logo" alt="logo" />
                  </div>
                </div>
              </div>
            </div>
          </div>
        </header>
      </div>
    );
  }
}

// function Login() {
//   return (
//     <div className="App container-lg">
//       <header className="App-header">
//         <div>
//           <div className="card" style={{ width: "50rem" }}>
//             <div className="card-body">
//               <h5 className="card-title">Login</h5>
//               <div className="row">
//                 <div className="col">
//                   <LoginForm onSave={this.handleCreate} />
//                   <div className="row">
//                     <div className="mb-3">
//                       <a href="#" className="btn forgetBtn">
//                         Forgot your password?
//                       </a>
//                     </div>
//                   </div>
//                   <div className="row">
//                     <div className="col mb-3">
//                       <a
//                         href="#"
//                         className="btn btn-icon btn-secondary btn-google btn-lg w-100"
//                       >
//                         <FontAwesomeIcon icon={faGoogle} className="me-2" />
//                         Google
//                       </a>
//                     </div>
//                     <div className="col mb-3">
//                       <a
//                         href="#"
//                         className="btn btn-icon btn-secondary btn-facebook btn-lg"
//                       >
//                         <FontAwesomeIcon icon={faFacebook} className="me-2" />
//                         Facebook
//                       </a>
//                     </div>
//                   </div>
//                 </div>
//                 <div className="col img">
//                   <img src={logo} className="App-logo" alt="logo" />
//                 </div>
//               </div>
//             </div>
//           </div>
//         </div>
//       </header>
//     </div>
//   );
// }

export default Login;
