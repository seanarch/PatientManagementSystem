import React from 'react';
import './App.css';
import Navbar from './components/Navbar';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { Navigate } from 'react-router-dom';
import { AppState } from './Context/AppContext';
import Home from './pages/index';
import Register from './pages/Register/RegisterPage';
import Previsit from './pages/Previsit/PrevisitPage';
import Visit from './pages/visit';
import Other from './pages/Other/other';
import Endvisit from './pages/endvisit';
import NotFound from './pages/NotFound';
import LoginForm from './pages/LoginForm';
import PatientDetails from './components/SeePatientDetails';
import { useContext, useEffect } from 'react';
import { AppContext } from './Context/AppContext';

function App() {
  const { isLoggedIn, setIsLoggedIn } = useContext(AppContext);

  useEffect(() => {
    const loginStatusInStorage = window.localStorage.getItem("login-status");
    setIsLoggedIn(loginStatusInStorage);
  }, []); 

  return (
    <Router>

      <Navbar />

      <Routes>
        <Route exact path="/" element={<Home />} />
        <Route path="/register" element={<Register />} />
        <Route path="/previsit" element={<Previsit />} />
        <Route path="/visit" element={<Visit />} />
        <Route path="/other" element={<Other />} />
        <Route path="/endvisit" element={<Endvisit />} />
        <Route path="/signin" element=
          {
            //if use is logged in, link to welcome page
            isLoggedIn ? <Navigate replace to="/" /> : <LoginForm />
          } />
        <Route path="/details" element={<PatientDetails />} />
        <Route path="*" element={<NotFound />} />
      </Routes>

    </Router>
  );
}

export default App;