import React from 'react';
import { Formik, Form } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl } from '@material-ui/core';
import TextField from '../../components/TextField/TextField';
import DatePicker from '../../components/Date/DatePicker';
import axios from "axios"; 

const INITIAL_VALUES = {
    FVCFEVInformation: {
        Date2: "2021-02-17",
        FVC: 10.10,
        FVCperc: 10,
        FEV1: 10.10,
        FEV1perc: 10,
        Ratio: 10,
        DLCO: 10,
    },
}

const FVCFEVInfo = () => {
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
                        <h3>FVC FEV Information</h3>
                        <Grid container spacing={3} width={'70vw'}>
                            <Grid item xs={12}>
                                <DatePicker
                                        fullWidth
                                        name="FVCFEVInformation.Date2"
                                        label="Date"
                                    />
                                </Grid>
                        
                            <Grid item xs={12}>
                                    <TextField
                                        name="FVCFEVInformation.FVC"
                                        label="FVC"
                                    />
                                </Grid>
                            <Grid item xs={12}>
                                    <TextField
                                        name="FVCFEVInformation.FVCperc"
                                        label="FVC%"
                                    />
                                </Grid>
                                <hr></hr>
                            <Grid item xs={12}>
                                    <TextField
                                        name="FVCFEVInformation.FEV1"
                                        label="FEV1"
                                    />
                                </Grid>
                                <hr></hr>
                            <Grid item xs={12}>
                                    <TextField
                                        name="FVCFEVInformation.FEV1perc"
                                        label="FEV%"
                                    />
                                </Grid>
                                <hr></hr>
                            <Grid item xs={12}>
                                    <TextField
                                        name="FVCFEVInformation.Ratio"
                                        label="Ratio"
                                    />
                                </Grid>
                                <hr></hr>
                            <Grid item xs={12}>
                                    <TextField
                                        name="FVCFEVInformation.DLCO"
                                        label="DLCO"
                                    />
                                </Grid>
                                <hr></hr>
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

export default FVCFEVInfo;