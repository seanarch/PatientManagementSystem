import React from 'react';
import { Formik, Form } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl, Slider } from '@material-ui/core';
import TextField from '../../components/TextField/TextField';
import DatePicker from '../../components/Date/DatePicker';
import axios from "axios"; 
import Collapsible from 'react-collapsible';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


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

function DetailedInfo() {

    const notify = () => {
     
        toast.success('Successfully saved!', {
          position: toast.POSITION.TOP_RIGHT,
          autoClose: 2000
        })
    }

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
                        <Collapsible trigger="Detailed Information" triggerTagName='h3'  overflowWhenOpen="inherit">
                        <br></br>
                        <Grid container spacing={3} width={'70vw'} >
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
                                        label="Bilirubin (BR)"
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                        name="DetailedInformation.Alb"
                                        label="Albumin (Alb)"
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                        name="DetailedInformation.PTINR"
                                        label="Prothrombin time (PTINR)"
                                    />
                                </Grid>


                            <Grid item xs={6}>
                                    <TextField
                                        name="DetailedInformation.HepaticEnch"
                                        label="Hepatic Encephalopathy (HepaticEnch)"
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

                            <Grid item xs={12} >
                                <h5>Cognitive Performance Scale</h5>
                                <br/><br/>
                                <Slider
                                    
                                    valueLabelDisplay="on"
                                    step={1}
                                    marks
                                    min={0}
                                    max={10}
                                    name="DetailedInformation.CPScore"
                                    label="CPScore"
                                    
                                    />
                                                                    
                                </Grid>
                                <hr></hr>

                                <Grid item xs={12}>
                                    <Button color='primary' type="submit"  onClick={notify}>Save</Button>
                                    <ToastContainer />
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