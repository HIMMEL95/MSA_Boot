import axios from "axios";
import React, { Component, useEffect, useState } from "react";

function LoginForm() {
  useEffect(() => {
    var id = document.getElementById("inputId").value;
    var pw = document.getElementById("inputPw").value;

    axios.post("/api/loginProcess.do", {
      member_id_num : id,
      password_enc: pw
    })
    .then(function(response) {
      console.log(response);
    }).catch(function(error) {
      console.log(error);
    });

  }, []);


  function submitData (e) {
    var id = document.getElementById("inputId").value;
    var pw = document.getElementById("inputPw").value;
    alert(id + " " + pw);

    axios
      .post("/api/loginProcess.do", {
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
          />
        </div>
      </div>
      <div className="row">
        <div className="mb-3">
          <button
            type="submit"
            className="btn btn-dark loginBtn"
            onClick={submitData}
          >
            Login
          </button>
        </div>
      </div>
    </form>
  );
}

export default LoginForm;
