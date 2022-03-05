import React from 'react'
import Patients from './Patients/Patients';
import { useFormik } from 'formik';
import { Form, FormGroup, Label, Input, Button } from 'reactstrap';

/* npm install reactstrap
 */
const Register = () => {

    const registerForm = useFormik({
        initialValues: {
            NewPatientConsult: {
                Date: ""
            },
            Death: {
                Date: "",
                Detail: "",
            }
        },
        onSubmit: (values) => {
            console.log(values)
            //once submit, provide value for back end
        }
    });

    return (
        <div className='container' style={{
            display: 'flex', justifyContent:
                'center', alignItems: 'center', height: '50vh'
        }}>
            <Form style={{ width: '70vw' }} onSubmit={registerForm.handleSubmit}>

                <FormGroup>
                    <Label>NP</Label>
                    <Input
                        required
                        name="NewPatientConsult.Date"
                        type="date"
                        onChange={registerForm.handleChange}
                        value={registerForm.values.NewPatientConsult.Date}
                    />

                </FormGroup>

                <FormGroup>
                    <Label>Death</Label>
                    <Input
                        name="Death.Date"
                        type="date"
                        onChange={registerForm.handleChange}
                        value={registerForm.values.Death.Date}
                    />
                </FormGroup>
                <FormGroup>
                    <Input
                        name="Death.Detail"
                        type="text"
                        onChange={registerForm.handleChange}
                        value={registerForm.values.Death.Detail}
                    />
                </FormGroup>
                <Button color='primary' type="submit">Submit</Button>
            </Form>

            {/*   <Patients /> */}

        </div>
    )
};
export default Register;