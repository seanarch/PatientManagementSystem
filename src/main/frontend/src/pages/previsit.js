import React from 'react';
import SearchPatient from '../components/SearchPatient';
import Axios_test from './Previsit/Axios_test';
//import Previsit_form from './Previsit/Previsit_form';
//import PatientData from "../data/patientsdata.json"
//import Previsit_search from './Previsit/Previsit_search';

const Previsit = () => {
    return (
        <div className='previsit' style={{
            display: 'flex', justifyContent:
                'center', alignItems: 'center', height: '37vh'
        }}>

            <Axios_test />
        </div>
    )
}

export default Previsit