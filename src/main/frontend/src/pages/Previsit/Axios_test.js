import React, { useState } from "react";
import patientService from "../../services/patient.service";
import * as Yup from "yup";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Formik, Form, Field, ErrorMessage } from 'formik';
import axios from "axios";


const onSubmit = values => {
    console.log('Form submission data', values)
}

const validationSchema = Yup.object({
    comments: Yup.string().required('Required field'), 
    date1: Yup.date()
    .min(new Date('01-01-2019'))
    .max(new Date())
    .required(),
    date2: Yup.date()
        .min(new Date('01-01-2019'))
        .max(new Date())
        .required(),
    fvc: Yup.string().required('Required field')
    .matches(/^[0-9]+$/, "Must be only digits")
    .min(2, 'Must be exactly 2 digits')
    .max(2, 'Must be exactly 2 digits'),
    he: Yup.string()
    .oneOf(['Yes', 'No'])
    .required('Please either select YES or No'),
    datedi: Yup.date()
    .required('Date is required'),
    ctChest: Yup.string()
    .ensure()
    .oneOf(['Yes', 'No'])
    .required('Please either select YES or No'),
    
})

 

export default function Axios_test() {

    

    const [datadi, setDatadi] = useState('');
    const [comments, setComments] = useState('');
    
    axios
        .get("http://localhost:3010/patients")
        .then(data => setComments(data.data[0].Comments))
        .catch(error => console.log(error));
    
    console.log('comments', comments);
    
         


    const initialValues = {

        datedi: "",
        ctChest: "No",
        comments: "Some text here",
        date1: "2019-11-21",
        bili: "19-Nov-21",
        alb: "19-Nov-21",
        ptInr: "19-Nov-21",
        ascites: "1",
        he: "Yes",
        cpScore: "1",
        childPugh: "1",
        date2: "",
        fvc: "",
        fvcPercent: "",
        fev1: "",
        fev1Percent: "",
        ratio: ""
    }
  return (
    
        <Formik
            initialValues={initialValues}
            validationSchema={validationSchema}
            onSubmit={onSubmit}>
            
            <Form>
                <br></br><br></br><br></br><br></br>
                <br></br><br></br><br></br><br></br>
                <br></br> <br></br> <br></br>  
                <div className="form-control">
                    <label previsitform='datedi'>Datedi</label>
                    <br></br>
                    <Field type="date" id="datedi" name="datedi" />
                    <ErrorMessage name="datedi" />
                </div>
                <br></br><br></br>
                <div className="form-control">
                <label previsitform='ctChest'>CT Chest</label>
                <br></br>
                <Field as="select" id="ctChest" name="ctChest">
                    <option value="" label="Select an option" />
                    <option value="Yes" label="Yes" />
                    <option value="No" label="No" />
                </Field>
                <ErrorMessage name="ctChest" />
                </div>
                <br></br><br></br>
                <div className="form-control">
                <label previsitform='comments'>Comments</label>
                <br></br>
                <Field as="textarea" id="comments" name="comments" />
                <ErrorMessage name="comments" />
                </div>
                <br></br><br></br><br></br> 
                <div className="form-control">
                    <label previsitform='date1'>Date1</label>
                    <br></br>
                    <Field type="date" id="date1" name="date1" />
                    <ErrorMessage name="date1" />
                </div>
                <br></br><br></br>
                <div className="form-control">
                    <label previsitform='fvc'>FVC</label>
                    <br></br>
                    <Field type="fvc" id="fvc" name="fvc" />
                    <ErrorMessage name="fvc" />
                </div>
                <br></br> <br></br> <br></br>  
                <button type='submit'>Submit</button>
            </Form>



        </Formik>
    

  )
}


 