import React from "react";
import { useState, useEffect } from "react";
import patientService from "../../services/patient.service";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Link } from 'react-router-dom';
import { useFormik } from "formik";

const Previsit_patientlist = () => {
    const [patients, setPatients] = useState([]);
    // const [comments, setcomments] = useState('');
    // const [textinput, setTextinput] = useState('');
    // const [date, setDate] = useState('');
    // const [dropdown, setDropdown] = useState('');
    // const [checkbox, setCheckbox] = useState('');

    const formik = useFormik({

        initialValues: {
            comments: "",
            textinput: "",
            datedi: "",
            dropdown: "",
            checkbox: "",
        },
    })

    console.log(formik.values);


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

    // console.log(comments);
    // console.log(textinput);
    // console.log(date);
    // console.log(dropdown);
    // console.log(checkbox);
    return (
        <div className="container">
            <br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br>
            <br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br>
            <br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br>
            <h3>List of patient information</h3>
            <hr />
            <form>

                <div className="input-container">
                    <h3>Textarea input component</h3>
                    <textarea
                        id="comments"
                        name="comments"
                        rows="5" cols="30"
                        onChange={formik.handleChange}
                        value={formik.values.comments}></textarea>
                    <hr />
                    <br></br>
                    <h3>Text input component</h3>
                    <input type="text"
                        name="textinput"
                        onChange={formik.handleChange}
                        value={formik.values.textinput} />
                    <hr />
                    <br></br>
                    <h3>Date input component</h3>
                    <input type="date" name="datedi"
                        onChange={formik.handleChange}
                        value={formik.values.datedi} />
                    <hr />
                    <br></br>
                    <h3>Dropdown menu component</h3>
                    <select name="dropdown"
                        onChange={formik.handleChange}
                        value={formik.values.dropdown}>
                        <option value="1">1</option>
                        <option value="2">2</option>
                    </select>
                    <hr />
                    <br></br>
                    <h3>Checkbox component</h3>
                    <input type="checkbox" id="checkbox" name="checkbox"
                        onChange={formik.handleChange}
                        value={formik.values.checkbox} />
                    <hr />
                    <br></br>
                    <div>

                        <button className="btn btn-primary">Submit</button>
                    </div>
                </div>

            </form>


        </div>

    )


}

export default Previsit_patientlist;