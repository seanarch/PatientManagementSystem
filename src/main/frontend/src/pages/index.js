import React from 'react'
import Patients from './Patients/Patients'

const Home = () => {
    return (
        <div style={{
            display: 'flex', justifyContent:
                'center', alignItems: 'center', height: '50vh', marginLeft: '37vh'
        }}>

            <Patients />

        </div>
    )
}

export default Home