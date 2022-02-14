import React from 'react'
import Patients from './Patients/Patients'

const Home = () => {
    return (
        <div style={{
            display: 'flex', justifyContent:
                'center', alignItems: 'center', height: '50vh', marginLeft: '37vh'
        }}>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

            <Patients />

        </div>
    )
}

export default Home