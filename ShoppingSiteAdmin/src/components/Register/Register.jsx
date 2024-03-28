import React, { useState } from "react";
import { NavLink, Navigate } from "react-router-dom";
import { request } from "../../Helpers/axiosHelper";
import { userApi } from "../../Helpers/UserApi";

function Register() {
  const [user, setUser] = useState({
    username: "",
    name: "",
    email: "",
    password: "",
    cnfpassword: "",
    userType: "User",
  });

  const [isRegister, setIsRegister] = useState(false);

  const onChangeHandler = (event) => {
    event.preventDefault();
    let name = event.target.name;
    let value = event.target.value;
    setUser({ ...user, [name]: value });
    console.log("State is : " + JSON.stringify(user));
  };

  const handleChange = (e) => {
    e.preventDefault();
    console.log(e.target.value);
    setUser({ ...user, userType: e.target.value });
  };

  const onSubmitRegister = async (e) => {
    e.preventDefault();
    console.log("On Form submit is called");
    console.log("Submit onSubmitLogin is called");
    // request("POST", "/register", user);
    console.log("*** User is : " + JSON.stringify(user));
    const response = await userApi.signup(user);
    console.log("****** Response : " + JSON.stringify(response.data));

    if (response.data && response.data.accessToken) {
      console.log("***** response.data : " + response.data);
      console.log(
        "***** response.data.accessToken : " + response.data.accessToken
      );
      setIsRegister(true);
    }
  };

  if (isRegister) {
    return <Navigate to={"/login"} />;
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
          Sign Up to your account
        </h2>
      </div>

      <div className="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
        <form className="space-y-6" onSubmit={onSubmitRegister} method="POST">
          <div>
            <label
              htmlFor="username"
              className="block text-sm font-medium leading-6 text-gray-900"
            >
              User Name
            </label>
            <div className="mt-2">
              <input
                id="username"
                name="username"
                type="text"
                autoComplete="username"
                required
                className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                onChange={onChangeHandler}
              />
            </div>
          </div>

          <div>
            <label
              htmlFor="name"
              className="block text-sm font-medium leading-6 text-gray-900"
            >
              Name
            </label>
            <div className="mt-2">
              <input
                id="name"
                name="name"
                type="text"
                autoComplete="name"
                required
                className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                onChange={onChangeHandler}
              />
            </div>
          </div>

          <div>
            <label
              htmlFor="email"
              className="block text-sm font-medium leading-6 text-gray-900"
            >
              Email address
            </label>
            <div className="mt-2">
              <input
                id="email"
                name="email"
                type="email"
                autoComplete="email"
                required
                className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                onChange={onChangeHandler}
              />
            </div>
          </div>

          <div>
            <label
              htmlFor="password"
              className="block text-sm font-medium leading-6 text-gray-900"
            >
              Password
            </label>
            <div className="mt-2">
              <input
                id="password"
                name="password"
                type="password"
                autoComplete="current-password"
                required
                className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                onChange={onChangeHandler}
              />
            </div>
          </div>

          <div>
            <label
              htmlFor="cnfpassword"
              className="block text-sm font-medium leading-6 text-gray-900"
            >
              Confirm Password
            </label>
            <div className="mt-2">
              <input
                id="cnfpassword"
                name="cnfpassword"
                type="password"
                autoComplete="current-password"
                required
                className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                onChange={onChangeHandler}
              />
            </div>
          </div>

          <div>
            <label>
              Select User:
              <select value={user.userType} onChange={handleChange}>
                <option value="ADMIN">Admin</option>
                <option defaultValue value="USER">
                  User
                </option>
                <option value="SELLER">Seller</option>
              </select>
            </label>
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
          Need Login?{" "}
          <NavLink
            to={"/login"}
            className="font-semibold leading-6 text-indigo-600 hover:text-indigo-500"
          >
            Login
          </NavLink>
        </p>
      </div>
    </div>
  );
}

export default Register;
