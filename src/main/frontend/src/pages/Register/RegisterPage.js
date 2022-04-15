import React from 'react'
import Patients from '../Patients/Patients';
import RegisterForm from './RegisterForm';
import DeathForm from './DeathForm';
import SearchForm from './SearchForm';
import PatientInfo from './PatientInfo';
import Patientanddeath from './Patientanddeath'; 
import SearchPatient from '../../components/SearchBar';

/* npm install reactstrap
 */
const Register = () => (
    <div>
       <SearchForm />
       <Patientanddeath/>
       <RegisterForm />
    </div>
);

export default Register;