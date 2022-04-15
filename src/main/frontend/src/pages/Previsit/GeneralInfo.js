import React from 'react';
import { Formik, Form } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl } from '@material-ui/core';
import TextField from '../../components/TextField/TextField';
import DatePicker from '../../components/Date/DatePicker';
import { TextareaAutosize } from '@mui/base';
import axios from "axios"; 
import Collapsible from 'react-collapsible';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const INITIAL_VALUES = {
    GeneralInformation: {
        DateDI: "2021-02-17",
        CTchest: "1",
        Comments: "Some comments here Some comments here Some comments here Some comments here",
    },
}

function GeneralInfo() {

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
                        <Collapsible  trigger="General Information" triggerTagName='h3'  overflowWhenOpen="inherit" >
                        <br></br>
                        <Grid container spacing={3} width={'70vw'} >
                            <Grid item xs={6}>
                                <DatePicker
                                        fullWidth
                                        name="GeneralInformation.DateDI"
                                        label="Date Diagnosed"
                                    />
                                </Grid>
                                <Grid item xs={6}>
                                    <TextField
                                        name="GeneralInformation.CTchest"
                                        label="Computed Tomography (CT) Chest"
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
                                    <Button color='primary' type="submit" onClick={notify}>Save</Button>
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

export default GeneralInfo;

 