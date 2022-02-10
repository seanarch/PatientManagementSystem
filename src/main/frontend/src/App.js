import React, {useState,useEffect} from "react";
import logo from './logo.svg';
import './App.css';
import axios from "axios";

const Patients = () =>{
    
    const [patients, setPatients] =  useState([]);
    
    const fetchPatients = () => {
        axios.get("http://localhost:8080/api/patient/").then(res => {            
            setPatients(res.data);
            
        });
    };
    
    useEffect(() => {
        fetchPatients();
    }, []);
    
    return patients.map((patients, index) => {
        return(
            <div key={index}>
                <h1>{patients.uli}</h1>
                        <p>
                            {patients.firstname}
                            {patients.lastname}                       
                        </p>        
            
            </div>
            );
    });
};

function App() {
  return (
    <div className="App">
     <Patients/>
    </div>
  );
}

export default App;
