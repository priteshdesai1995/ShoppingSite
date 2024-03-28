import React from "react";
import Header from "../Header/Header";
import { SidebarWithSearch } from "../Header/SidebarWithSearch";
import ContentDetailsPage from "../ContentDetailsPage/ContentDetailsPage";
import { useSelector } from "react-redux";

function AdminHome() {
  const userReducer = useSelector((state) => state.userReducer.users);
  console.log(JSON.stringify(userReducer));

  return (
    <div>
      <Header />
      <div style={{ display: "flex", width: "100%" }}>
        <SidebarWithSearch />
        <ContentDetailsPage>
          <h2>{userReducer.user.data.name}</h2>
          <h2>{userReducer.user.data.userId}</h2>
          <h2>{userReducer.user.data.preferred_username}</h2>
          <h2>{userReducer.user.data.email}</h2>
        </ContentDetailsPage>
      </div>
    </div>
  );
}

export default AdminHome;
