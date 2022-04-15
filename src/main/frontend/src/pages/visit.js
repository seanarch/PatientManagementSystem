import React from 'react'
import Fhxdetail from './Visit/Fhxdetail';
import ORinfo from './Visit/ORinfo';
import RTGIinfo from './Visit/RTGIinfo'; 
import SearchBar from '../components/SearchBar';
import Symptoms from './Visit/Symptoms';
import Patientchallenges from './Visit/Patientchallenges';
import SearchForm from './Register/SearchForm';


const visit = () => (
    <div>
 
        
        <SearchForm/>
        <ORinfo />
        <Fhxdetail />
        <Patientchallenges />
        <RTGIinfo />  
        <Symptoms />

 
    </div>
);

export default visit;