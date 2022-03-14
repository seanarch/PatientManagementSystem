import React from 'react';
import { Formik, Form } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl } from '@material-ui/core';
import TextField from '../../components/TextField/TextField';
import DatePicker from '../../components/Date/DatePicker';
import axios from "axios"; 


const INITIAL_VALUES = {
    DetailedInformation: {
        Date1: "2021-03-17",
        Bili: "2021-04-17",
        Alb: "2021-05-17",
        PTINR: "2021-06-17",
        Ascites: 10.10,
        HepaticEnch: "String",
        CPScore: 10,
        ChildPugh: "S",
    },
}

const DetailedInfo = () => {
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
                        <h3>Detailed Information</h3>
                        <Grid container spacing={3} width={'70vw'}>
                            <Grid item xs={12}>
                                <DatePicker
                                        fullWidth
                                        name="DetailedInformation.Date1"
                                        label="Date"
                                    />
                                </Grid>
                            <Grid item xs={12}>
                                <DatePicker
                                        fullWidth
                                        name="DetailedInformation.Bili"
                                        label="Bili"
                                    />
                                </Grid>
                            <Grid item xs={12}>
                                <DatePicker
                                        fullWidth
                                        name="DetailedInformation.Alb"
                                        label="Alb"
                                    />
                                </Grid>
                            <Grid item xs={12}>
                                <DatePicker
                                        fullWidth
                                        name="DetailedInformation.PTINR"
                                        label="PTINR"
                                    />
                                </Grid>
                            <Grid item xs={12}>
                                    <TextField
                                        name="DetailedInformation.HepaticEnch"
                                        label="HepaticEnch"
                                    />
                                </Grid>
                            <Grid item xs={12}>
                                    <TextField
                                        name="DetailedInformation.CPScore"
                                        label="CPScore"
                                    />
                                </Grid>
                            <Grid item xs={12}>
                                    <TextField
                                        name="DetailedInformation.ChildPugh"
                                        label="ChildPugh"
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

export default DetailedInfo;