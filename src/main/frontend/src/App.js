import React from 'react';
import './App.css';
import Navbar from './components/Navbar';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
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


function App() {
  return (
    <Router>
      <Navbar />

      <AppState>
        <Routes>
          <Route exact path="/" element={<Home />} />
          <Route path="/register" element={<Register />} />
          <Route path="/previsit" element={<Previsit />} />
          <Route path="/visit" element={<Visit />} />
          <Route path="/other" element={<Other />} />
          <Route path="/endvisit" element={<Endvisit />} />
          <Route path="/signin" element={<LoginForm />} />
          <Route path="/details" element={<PatientDetails />} />
          <Route path="*" element={<NotFound />} />
        </Routes>
      </AppState>

    </Router>
  );
}

export default App;