import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import {BrowserRouter} from "react-router-dom";
import Header from "./Components/Header";
import Footer from "./Components/Footer";
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from "redux";
import {thunk} from "redux-thunk";
import Reducer from "./_reducers/index.js";
import promiseMiddleware from "redux-promise";

const createStoreWithMiddleware = applyMiddleware(
  promiseMiddleware,
  thunk
)(createStore);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
    <Provider store={createStoreWithMiddleware(
                      Reducer,
                      window.__REDUX_DEVTOOLS_EXTENSION__ &&
                        window.__REDUX_DEVTOOLS_EXTENSION__())}>
        <Header/>
            <App/>
        <Footer/>
    </Provider>
  </BrowserRouter>
);

