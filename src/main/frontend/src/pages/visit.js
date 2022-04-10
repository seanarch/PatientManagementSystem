import React from 'react'
import Fhxdetail from './Visit/Fhxdetail';
import ORinfo from './Visit/ORinfo';
import RTGIinfo from './Visit/RTGIinfo'; 
import SearchBar from '../components/SearchBar';
import Symptoms from './Visit/Symptoms';
import Patientchallenges from './Visit/Patientchallenges';


const visit = () => (
    <div>
 
        
        <SearchBar/>
        <ORinfo />
        <Fhxdetail />
        <Patientchallenges />
        <RTGIinfo />  
        <Symptoms />

 
    </div>
);

export default visit;