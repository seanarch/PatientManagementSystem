import React from 'react';
import './App.css';
import Navbar from './components/Navbar';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './pages';
import Register from './pages/register';
import Previsit from './pages/previsit';
import Visit from './pages/visit';
import Other from './pages/other';
import Endvisit from './pages/endvisit';



function App() {
  return (
    <Router>
      <Navbar />

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/register" element={<Register />} />
        <Route path="/previsit" element={<Previsit />} />
        <Route path="/visit" element={<Visit />} />
        <Route path="/other" element={<Other />} />
        <Route path="/endvisit" element={<Endvisit />} />
      </Routes>
    </Router>
  );
}

export default App;
