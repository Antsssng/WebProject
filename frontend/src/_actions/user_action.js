// user_action.js

import axios from "axios";
import { LOGIN_USER, REGISTER_USER, AUTH_USER } from "./types";

export function registerUser(dataToSubmit) {
  const request = axios
    .post('/api/users/register', dataToSubmit)
    .then((res) => res.data);
  return {
    type: REGISTER_USER,
    payload: request,
  }
 }