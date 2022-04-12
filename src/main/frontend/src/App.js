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
import Endvisitform from './pages/Endvisit/Endvisitform';
import PatientDetails from './components/SeePatientDetails';
import { useContext, useEffect } from 'react';
import { AppContext } from './Context/AppContext';
 

function App() {
  const { isLoggedIn, setIsLoggedIn } = useContext(AppContext);

  //no need to sign in again if already signed in after refresh. Due to security this function may no be in favor
/*   useEffect(() => {
    const loginStatusInStorage = window.localStorage.getItem("login-status");
    setIsLoggedIn(loginStatusInStorage);
  }, []);  */

  return (
    <Router>

      <Navbar />

 
      <Routes>
        <Route exact path="/" element={<Home />} />
        <Route path="/register" element={ isLoggedIn ?  <Register /> :  <Navigate  to="/" /> } />
        <Route path="/previsit" element={isLoggedIn ?  <Previsit /> : <Navigate  to="/" /> }/>
        <Route path="/visit" element={isLoggedIn ?  <Visit /> :  <Navigate  to="/" /> }/>
        <Route path="/other" element={isLoggedIn ? <Other />:  <Navigate  to="/" /> } />
        <Route path="/endvisit" element={isLoggedIn ? <Endvisit />:  <Navigate  to="/" /> } />
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