import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import {BrowserRouter} from "react-router-dom";
import Header from "./Components/Header";
import Footer from "./Components/Footer";
import { Provider } from 'react-redux';
import store from './Store/store.js';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
    <Provider store = {store}>
        <Header/>
            <App/>
        <Footer/>
    </Provider>
  </BrowserRouter>
);

