import React from 'react';
import SearchPatient from '../components/SearchPatient';
//import PatientData from "../data/patientsdata.json"
//import Previsit_search from './Previsit/Previsit_search';

const Previsit = () => {
    return (
        <div className='previsit' style={{
            display: 'flex', justifyContent:
                'center', alignItems: 'center', height: '37vh'
        }}>

            <SearchPatient />
        </div>
    )
}

export default Previsit