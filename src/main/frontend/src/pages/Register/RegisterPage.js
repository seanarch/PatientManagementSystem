import React from 'react'
import Patients from '../Patients/Patients';
import RegisterForm from './RegisterForm';
import DeathForm from './DeathForm';
import SearchForm from './SearchForm';
/* npm install reactstrap
 */
const Register = () => (
    <div>
        <SearchForm />
        <RegisterForm />
        <DeathForm />
    </div>
);

export default Register;