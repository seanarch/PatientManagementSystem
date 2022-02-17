import React from 'react'
import Previsit_search from './Previsit/Previsit_search'
import PatientsList from '../components/PatientsList'
// import PatientData from "../data/patientsdata.json"
// import axios from "axios"

const db = PatientsList();

const Previsit = () => {
    return (
        <div className='previsit' style={{
            display: 'flex', justifyContent:
                'center', alignItems: 'center', height: '37vh'
        }}>

            <Previsit_search placeholder="Enter patient Firstname" data={db} />
        </div>
    )
}

export default Previsit