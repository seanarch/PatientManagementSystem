import React from "react";
import { useState, useEffect } from "react";
import patientService from "../../services/patient.service";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Link } from 'react-router-dom';

const Previsit_patientlist = () => {
    const [patients, setPatients] = useState([]);

    useEffect(() => {
        patientService.getAll()
            .then(response => {
                console.log('Printing patients data', response.data);
                setPatients(response.data);
            })
            .catch(error => {
                console.log('Something wrong', error);
            })

    }, [])

    return (
        <div className="">
            <h3>List of patient information</h3>


        </div>

    )


}

export default Previsit_patientlist;