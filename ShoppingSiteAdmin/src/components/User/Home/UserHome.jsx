import React from "react";
import { useAuth } from "../../context/AuthContext";
import {NavLink} from "react-router-dom";

function UserHome() {
  const { getUser, userIsAuthenticated, userLogout } = useAuth();
  const user = getUser()

  const removeUser = () => {
    userLogout();
  } 

  return (
    <div>
      <h1>User Home Componnent is called.</h1>
      <p>{JSON.stringify(user)}</p>
      <NavLink onClick={removeUser} to={"/"}>Logout</NavLink>
    </div>
  );
}

export default UserHome;
