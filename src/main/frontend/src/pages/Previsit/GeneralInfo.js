import React, { useState } from "react";
import patientService from "../../services/patient.service";
import * as Yup from "yup";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Formik, Form, Field, ErrorMessage } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl } from '@material-ui/core';
import TextField from '../../components/TextField/TextFeild';
import DatePicker from '../../components/Date/DatePicker';
import axios from "axios";
import { TextArea } from "semantic-ui-react";

const INITIAL_VALUES = {
    GeneralInformation: {
        DateDI: "2021-02-17",
        CTchest: "1",
        Comments: "Some comments here",
    },
}

const GeneralInfo = () => {
    return (
        <Container maxWidth="md">
        <div className='container' style={{
            display: 'flex', justifyContent:
                'center', alignItems: 'center', marginTop: '50px'
        }}>
            <Formik initialValues={{ ...INITIAL_VALUES }} onSubmit={values => {
                console.log(values) 
            }}
>
                {props => (
                    <Form>
                        <h3>General Information</h3>
                        <Grid container spacing={3} width={'70vw'}>
                            <Grid item xs={12}>
                                <DatePicker
                                        fullWidth
                                        name="GeneralInformation.DateDI"
                                        label="DateDI"
                                    />
                                </Grid>
                                <Grid item xs={12}>
                                    <TextField
                                        name="GeneralInformation.CTchest"
                                        label="CTchest"
                                    />
                                </Grid>
                                <Grid item xs={12}> 
                                    <TextField  
                                        name="GeneralInformation.Comments"
                                        label="Comments"
                                    />
                                </Grid>

                                 

                                <Grid item xs={12}>
                                    <Button color='primary' type="submit">Save</Button>
                                </Grid>
                            </Grid>
                        
                    </Form>
                )}
            </Formik>
        </div>
    </Container>
    )
}

export default GeneralInfo;

 