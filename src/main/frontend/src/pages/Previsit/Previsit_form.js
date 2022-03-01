import { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import patientService from "../../services/patient.service";
import { Link } from "react-router-dom";

const Previsit_form = () => {

    const [datedi, setdatedi] = useState('');
    const [comments, setComments] = useState('');
    const [ctChest, setCtChest] = useState('');
    const [bili, setBili] = useState('');
    const [date, setDate] = useState('');
    const [checkbox, setCheckbox] = useState('');
    const history = useNavigate();
    const { id } = useParams();

    const savePatient = (e) => {
        e.preventDefault();

        const patient = { datedi, comments, ctChest, bili, date, checkbox, id };

        if (id) {
            // if the patient is found, update record
            patientService.update(patient)
                .then(response => {
                    console.log('Patient data updated successfully', response.data);
                    history.push('/');
                })
                .catch(error => {
                    console.log('Something wrong', error);
                })

        } else {
            // patient not found 
            console.log('Patient not found');
        }
    }

    useEffect(() => {
        if (id) {

            patientService.get


        }
        return () => {
            cleanup
        };
    }, [input]);


    return ( 

     );
}

export default Previsit_form;