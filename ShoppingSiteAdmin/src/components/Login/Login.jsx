import React, { useEffect, useState } from "react";
import { Link, NavLink, Navigate } from "react-router-dom";
import { request } from "../../Helpers/axiosHelper";
import { useAuth } from "../context/AuthContext";
import { userApi } from "../../Helpers/UserApi";
import { parseJwt } from "../../Helpers/JwtHelpers";
import { useDispatch, useSelector } from "react-redux";
import { addToUser } from "../../reducers/userReducer";
const Login = () => {
  const Auth = useAuth();
  const dispatch = useDispatch();

  const isLoggedIn = Auth.userIsAuthenticated();

  const [user, setUser] = useState({
    username: "",
    password: "",
  });

  const [isRes, setIsRes] = useState(false);

  const [isError, setIsError] = useState(false);

  const onLoginHandler = async (e) => {
    e.preventDefault();
    console.log("Submit onLoginHandler is called");

    try {
      console.log(user);
      const response = await userApi.authenticate(user.username, user.password);
      console.log(response.data);

      const { accessToken } = response.data;
      const data = parseJwt(accessToken);
      const authenticatedUser = { data, accessToken };

      dispatch(addToUser(authenticatedUser));

      // localStorage.setItem('user', JSON.stringify(user))
      Auth.userLogin(authenticatedUser);

      setIsError(false);
    } catch (e) {
      console.error(e);
      setIsError(true);
    }
    // request("POST", "/auth/authenticate", user)
    // .then((res) => {
    //   console.log(res.data);
    // }).catch((error) => {
    //   console.error(error);
    // });
  };

  const handleOnChange = (e) => {
    e.preventDefault();
    const name = e.target.name;
    const value = e.target.value;
    setUser({ ...user, [name]: value });
    console.log(user);
  };

  useEffect(() => {
    console.log("Use Effect is called" + isRes);

    const testAPI = async () => {
      if (!isRes) {
        const res = await userApi.apiTest();
        // res.then((res) => {
        console.log(res.data);
        // });
        // request("GET", "/shopping/test/test/test", {})
        //   .then((res) => {
        //     console.log(res.data);
        //     setIsRes(true);
        //   })
        //   .catch((e) => {
        //     console.error(e);
        //   });
      }
    };
    testAPI();
  }, []);

  if (isLoggedIn) {
    const user = Auth.getUser();
    console.log(user);
    if (user.data.rol[0] == "ADMIN") {
      return <Navigate to={"/admin/home"} />;
    } else if (user.data.rol[0] == "SELLER") {
      return <Navigate to={"/seller/home"} />;
    } else {
      return <Navigate to={"/user/home"} />;
    }
  }

  return (
    <div className="flex min-h-full flex-1 flex-col justify-center px-6 py-12 lg:px-8">
      <div className="sm:mx-auto sm:w-full sm:max-w-sm">
        <img
          className="mx-auto h-10 w-auto"
          src="https://tailwindui.com/img/logos/mark.svg?color=indigo&shade=600"
          alt="Your Company"
        />
        <h2 className="mt-10 text-center text-2xl font-bold leading-9 tracking-tight text-gray-900">
          Sign in to your account
        </h2>
      </div>

      <div className="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
        <form className="space-y-6" onSubmit={onLoginHandler} method="POST">
          <div>
            <label
              htmlFor="username"
              className="block text-sm font-medium leading-6 text-gray-900"
            >
              Email address
            </label>
            <div className="mt-2">
              <input
                id="username"
                name="username"
                type="text"
                autoComplete="username"
                required
                className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                onChange={handleOnChange}
              />
            </div>
          </div>

          <div>
            <div className="flex items-center justify-between">
              <label
                htmlFor="password"
                className="block text-sm font-medium leading-6 text-gray-900"
              >
                Password
              </label>
              <div className="text-sm">
                <a
                  href="#"
                  className="font-semibold text-indigo-600 hover:text-indigo-500"
                >
                  Forgot password?
                </a>
              </div>
            </div>
            <div className="mt-2">
              <input
                id="password"
                name="password"
                type="password"
                autoComplete="current-password"
                required
                className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                onChange={handleOnChange}
              />
            </div>
          </div>

          <div>
            <button
              type="submit"
              className="flex w-full justify-center rounded-md bg-indigo-600 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
            >
              Sign in
            </button>
          </div>
        </form>

        <p className="mt-10 text-center text-sm text-gray-500">
          Not a member?{" "}
          <NavLink
            to={"/register"}
            className="font-semibold leading-6 text-indigo-600 hover:text-indigo-500"
          >
            Sign Up
          </NavLink>
        </p>
      </div>
    </div>
  );
}

export default Login;
