import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App.jsx";
import "./index.css";
import Login from "./components/Login/Login.jsx";
import {
  RouterProvider,
  createBrowserRouter,
  createRoutesFromElements,
  Route,
} from "react-router-dom";
import Register from "./components/Register/Register.jsx";
import Layout from "./components/Layout/Layout.jsx";
import { AuthProvider } from "./components/context/AuthContext";
import AdminHome from "./components/Admin/Home/AdminHome.jsx";
import UserHome from "./components/User/Home/UserHome.jsx";
import SellerHome from "./components/Seller/Home/SellerHome.jsx";
import { ThemeProvider } from "@material-tailwind/react";
import { Provider } from "react-redux";
import { store } from "./store/store.js";

const router = createBrowserRouter(
  createRoutesFromElements(
    <Route path="/" element={<Layout />}>
      <Route path="/" element={<Login />}></Route>
      <Route path="/login" element={<Login />}></Route>
      <Route path="/admin/home" element={<AdminHome />}></Route>
      <Route path="/user/home" element={<UserHome />}></Route>
      <Route path="/seller/home" element={<SellerHome />}></Route>
      <Route path="/register" element={<Register />}></Route>
    </Route>
  )
);

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <Provider store={store}>
      <ThemeProvider>
        <AuthProvider>
          <RouterProvider router={router} />
        </AuthProvider>
        {/* <App /> */}
      </ThemeProvider>
    </Provider>
  </React.StrictMode>
);
