import React from 'react';
import { Formik, Form } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl } from '@material-ui/core';
import TextField from '../../components/TextField/TextField';
import DatePicker from '../../components/Date/DatePicker';

const today = new Date(); 
const date = today.setDate(today.getDate()); 
const ymddate = new Date(date).toISOString().split('T')[0] // yyyy-mm-dd
 
const firstname = "John";

const INITIAL_VALUES = {
    PatientInformation: {
        Lastname: "",
        Firstname: {firstname}.firstname,
        Sex: "",
        Birthday: "",
        ULI: "",
        TG: "",
        Location: ""
    },
    NewPatientConsult: {
        Date: {ymddate}.ymddate
    },
}

console.log(ymddate)
console.log(firstname)

const RegisterForm = () => {
    return (

        <Container maxWidth="md">
            <div className='container' style={{
                display: 'flex', justifyContent:
                    'center', alignItems: 'center', marginTop: '50px'
            }}>
                <Formik initialValues={{ ...INITIAL_VALUES }} onSubmit={values => {
                    console.log(values)//once submit, provide value for back end
                }}
>
                    {props => (
                        <Form>
                            <h3>Create New Patient</h3>
                            <Grid container spacing={3} width={'70vw'}>
                                <Grid item xs={6}>
                                    <TextField
                                        label="Lastname"
                                        name="PatientInformation.Lastname"
                                        fullWidth
                                    />
                                    </Grid>
                                    <Grid item xs={6}>
                                        <TextField
                                            label="Firstname"
                                            name="PatientInformation.Firstname"
                                        />
                                    </Grid>

                                    <Grid item xs={6} >
                                    <FormControl fullWidth>
                                        <InputLabel id="demo-simple-select">Sex</InputLabel>
                                        <Select
                                            label="Sex"
                                            name="PatientInformation.Sex"
                                            id="demo-simple-select"
                                            value={props.values.PatientInformation.Sex}
                                            onChange={props.handleChange}
                                            labelId="demo-simple-select-label"
      
                                        >
                                            <MenuItem value={"M"}>Male</MenuItem>
                                            <MenuItem value={"F"}>Female</MenuItem>

                                        </Select>
                                        </FormControl>
                                    </Grid>

                                    <Grid item xs={6}>
                                        <DatePicker
                                            fullWidth
                                            name="PatientInformation.Birthday"
                                            label="Birthday"
                                        />
                                    </Grid>

                                    <Grid item xs={6}>
                                        <TextField
                                            label="ULI"
                                            name="PatientInformation.ULI"
                                            required
                                        />
                                    </Grid>


                                    <Grid item xs={6}>
                                        <TextField
                                            label="TG"
                                            name="PatientInformation.TG"
                                        />
                                    </Grid>

                                    <Grid item xs={6}>
                                        <TextField
                                            label="Location"
                                            name="PatientInformation.Location"
                                        />
                                    </Grid>

                                    <Grid item xs={6}>
                                        <DatePicker
                                            fullWidth
                                            name="NewPatientConsult.Date"
                                            label="New Patient Date"
                                        />
                                    </Grid>

                                    <Grid item xs={12}>
                                        <Button color='primary' type="submit">Create</Button>
                                    </Grid>
                                </Grid>
                            
                        </Form>
                    )}
                </Formik>
            </div>
        </Container>
    )
}

export default RegisterForm;