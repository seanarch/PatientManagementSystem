import React from 'react'
import Previsit_search from './Previsit/Previsit_search'
import PatientData from "../data/patientsdata.json"

const Previsit = () => {
    return (
        <div className='previsit' style={{
            display: 'flex', justifyContent:
                'center', alignItems: 'center', height: '37vh'
        }}>

            <Previsit_search placeholder="Enter patient Firstname" data={PatientData} />
        </div>
    )
}

export default Previsit