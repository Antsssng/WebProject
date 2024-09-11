import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './Home';
import Page from './Page';
import RegisterPage from './Components//RegisterPage'

const App = () => {
    return (
        <div className="App">
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/page" element={<Page/>}/>
                <Route path="/register" element={<RegisterPage/>}/>
            </Routes>
        </div>
    );
}

export default App;