import React from 'react'
import {Outlet} from "react-router-dom";
import Login from '../Login/Login';

function Layout() {
  return (
    <div>
        <Outlet/>
    </div>
  )
}

export default Layout
