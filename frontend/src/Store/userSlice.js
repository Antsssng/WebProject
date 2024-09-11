import { createSlice } from '@reduxjs/toolkit'

export const userSlice = createSlice({
    name: "user",
    initialState : {
        name: "",
        id: "",
        isLoading : false,
        isLogin : null,
    },
    reducer : {
        loginUser: (state, action) => {
        },

        cleanUser: (state) => {
        },
    },
})

export const {loginUser, cleanUser} = userSlice.actions;
export default userSlice.reducer;