import { createSlice, nanoid } from "@reduxjs/toolkit";
const user = JSON.parse(localStorage.getItem('user'));
console.log("user is " + user);
const initialState = {
  users: {
    user
  },
};

export const userSlice = createSlice({
  name: "user",
  initialState,
  reducers: {
    addToUser: (state, action) => {
      console.log("In Reducer is : " + JSON.stringify(action.payload));
      //   state.users.push(action.payload);
      return { ...state, users: { ...state.users, ...action.payload } };
    },
    removeUser: (state, action) => {
      return { ...state, users: {}};
    }
  },
});

export const { addToUser, removeUser, updateUser } = userSlice.actions;
export default userSlice.reducer;
