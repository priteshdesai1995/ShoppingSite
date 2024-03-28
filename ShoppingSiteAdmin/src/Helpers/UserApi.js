import axios from "axios";

import { config } from "../Constants";
import { parseJwt } from "./JwtHelpers";

export const userApi = {
  authenticate,
  signup,
  numberOfUsers,
  numberOfOrders,
  getUsers,
  deleteUser,
  getUserMe,
  getTest,
  apiTest,
};

function apiTest() {
  const data = "TEst";

  const username = "TEst";
  const password = "TEst";
  // return instance.post('/shopping/auth/auth/test/' + data);

  return instance.post(
    "/shopping/auth/auth/testbody",
    {"username":"TEstCheck"} ,
    {
      headers: {
        "Content-type": "application/json"
      },
    }
  );

  // return instance.post('/shopping/auth/auth/test');
}

function authenticate(username, password) {
  const request = { username: username, password: password };
  console.log("User details in the UserAPI : " + username + " " + password);
  return instance.post(
    "/shopping/auth/auth/authenticate",
    { username, password },
    {
      headers: {
        "Access-Control-Allow-Origin": "*",
        "Content-type": "application/json"
      },
    }
  );
}

function signup(user) {
  return instance.post("/shopping/auth/auth/signup", user, {
    headers: { "Content-type": "application/json" },
  });
}

function numberOfUsers() {
  return instance.get("/public/numberOfUsers");
}

function numberOfOrders() {
  return instance.get("/public/numberOfOrders");
}

function getUsers(user, username) {
  const url = username ? `/shopping/auth/api/users/${username}` : "/api/users";
  return instance.get(url, {
    headers: { Authorization: bearerAuth(user) },
  });
}

function deleteUser(user, username) {
  return instance.delete(`/shopping/auth/api/users/${username}`, {
    headers: { Authorization: bearerAuth(user) },
  });
}

function getUserMe(user) {
  return instance.get("/shopping/auth/api/users/me", {
    headers: { Authorization: bearerAuth(user) },
  });
}

function getTest(user) {
  return instance.get("/shopping/auth/api/users/test", {
    headers: { Authorization: bearerAuth(user) },
  });
}

// -- Axios

const instance = axios.create({
  withCredentials: true,
  baseURL: config.url.API_BASE_URL,
});

instance.interceptors.request.use(
  function (config) {
    // If token is expired, redirect user to login
    if (config.headers.Authorization) {
      const token = config.headers.Authorization.split(" ")[1];
      const data = parseJwt(token);
      console.log(data);
      console.log("Date.now() : " + Date.now());
      console.log("data.exp * 1000 : " + data.exp * 1000);
      if (Date.now() > data.exp * 1000) {
        window.location.href = "/login";
      }
    }
    return config;
  },
  function (error) {
    console.log(error);
    return Promise.reject(error);
  }
);

// -- Helper functions

function bearerAuth(user) {
  return `Bearer ${user.accessToken}`;
}
