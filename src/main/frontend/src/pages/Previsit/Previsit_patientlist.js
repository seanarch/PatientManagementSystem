import React from "react";
import patientService from "../../services/patient.service";
import * as Yup from "yup";
import 'bootstrap/dist/css/bootstrap.min.css';
import { useFormik } from "formik";

const Previsit_patientlist = () => {
    // Use traditional way instead of formik

    // const [patients, setPatients] = useState([]);
    // const [comments, setcomments] = useState('');
    // const [textinput, setTextinput] = useState('');
    // const [date, setDate] = useState('');
    // const [dropdown, setDropdown] = useState('');
    // const [checkbox, setCheckbox] = useState('');



    // useEffect(() => {
    //     patientService.getAll()
    //         .then(response => {
    //             console.log('Printing patients data', response.data);
    //             setPatients(response.data);
    //         })
    //         .catch(error => {
    //             console.log('Something wrong', error);
    //         })

    // }, [])

    // console.log(comments);
    // console.log(textinput);
    // console.log(date);
    // console.log(dropdown);
    // console.log(checkbox);


    const formik = useFormik({

        initialValues: {
            comments: "",
            textinput: "",
            datedi: "",
            dropdown: "",
            checkbox: "",
        },
        // added validation
        validationSchema: Yup.object({
            comments: Yup.string().max(15, "Must be 15 characters or less").required("Required"),
        }),
        onSubmit: (values) => {
            console.log(values);
        },
    });

    console.log(formik.errors);


    return (
        <div className="container">
            <br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br>
            <br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br>
            <br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br>
            <h3>List of patient information</h3>
            <hr />
            <form onSubmit={formik.handleSubmit}>

                <div className="input-container">
                    <h3>Textarea input component</h3>
                    <textarea
                        id="comments"
                        name="comments"
                        rows="5" cols="30"
                        onChange={formik.handleChange}
                        value={formik.values.comments}></textarea>
                    {/* added error message */}
                    {formik.errors.comments ? <p>{formik.errors.comments}</p> : null}
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

                        <button type="submit" className="btn btn-primary">Save changes</button>
                    </div>
                </div>

            </form>


        </div>

    )


}

export default Previsit_patientlist;