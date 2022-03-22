import React from 'react';
import { Formik, Form } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl, Slider } from '@material-ui/core';
import TextField from '../../components/TextField/TextField';
import DatePicker from '../../components/Date/DatePicker';
import axios from "axios"; 
import Collapsible from 'react-collapsible';


const INITIAL_VALUES = {
    DetailedInformation: {
        Date1: "2021-03-17",
        Bili: "10.1",
        Alb: "10.1",
        PTINR: "10.1",
        Ascites: 10.10,
        HepaticEnch: "String",
        CPScore: 3,
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
                        <Collapsible trigger="[+]">
                        <br></br>
                        <Grid container spacing={3} width={'70vw'}>
                            <Grid item xs={6}>
                                <DatePicker
                                        fullWidth
                                        name="DetailedInformation.Date1"
                                        label="Date"
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                        name="DetailedInformation.Bili"
                                        label="Bilirubin"
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                        name="DetailedInformation.Alb"
                                        label="Alb"
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                        name="DetailedInformation.PTINR"
                                        label="PTINR"
                                    />
                                </Grid>


                            <Grid item xs={6}>
                                    <TextField
                                        name="DetailedInformation.HepaticEnch"
                                        label="HepaticEnch"
                                    />
                                </Grid>
                            {/* <Grid item xs={12}>
                                    <TextField
                                        name="DetailedInformation.CPScore"
                                        label="Cognitive Performance Scale"
                                    />
                                </Grid> */}

                            <Grid item xs={6}>
                                    <TextField
                                        name="DetailedInformation.ChildPugh"
                                        label="ChildPugh"
                                    />
                                </Grid>

                            <Grid item xs={12}>
                                <h5>Cognitive Performance Scale</h5>
                                <Slider
                                    aria-label="Temperature"
                                    defaultValue={INITIAL_VALUES.DetailedInformation.CPScore}
                                    valueLabelDisplay="auto"
                                    step={1}
                                    marks
                                    min={0}
                                    max={10}
                                    />
                                                                    
                                </Grid>
                                <hr></hr>

                                <Grid item xs={12}>
                                    <Button color='primary' type="submit">Save</Button>
                                </Grid>
                            </Grid>
                        </Collapsible>
                    </Form>
                )}
            </Formik>
        </div>
    </Container>
    )
}

export default DetailedInfo;