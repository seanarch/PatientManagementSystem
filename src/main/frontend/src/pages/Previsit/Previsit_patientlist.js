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
        <div className="container">
            <br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br>
            <br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br>
            <h3>List of patient information</h3>
            <hr />
            <div>
                <h3>Text input component</h3>
                <textarea name='comment' rows="5" cols="30"></textarea>
                <br></br>
                <h3>Date input component</h3>
                <input type="date" id="datedi" />
                <br></br>
                <h3>Dropdown menu component</h3>
                <select>
                    <option>1</option>
                    <option>2</option>
                </select>
                <br></br>
                <h3>Checkbox component</h3>
                <input type="checkbox" id="" name="" />
                <br></br>


            </div>


        </div>

    )


}

export default Previsit_patientlist;