import React from 'react';
import { Formik, Form } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl } from '@material-ui/core';
import TextField from '../../components/TextField/TextField';
import DatePicker from '../../components/Date/DatePicker';
import { TextareaAutosize } from '@mui/base';
import axios from "axios"; 

const INITIAL_VALUES = {
    GeneralInformation: {
        DateDI: "2021-02-17",
        CTchest: "1",
        Comments: "Some comments here Some comments here Some comments here Some comments here",
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
                                        fullWidth
                                        label="Comments"
                                        name="GeneralInformation.Comments"
                                        multiline
                                        rows={4}
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

 