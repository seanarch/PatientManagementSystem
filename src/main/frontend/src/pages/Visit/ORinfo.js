import React from 'react';
import { Formik, Form, Field } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl, Checkbox } from '@material-ui/core';
import TextField from '../../components/TextField/TextField';
import DatePicker from '../../components/Date/DatePicker';
import axios from "axios"; 
import Collapsible from 'react-collapsible'; 
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
 

const INITIAL_VALUES = {
    ORInformation: {
	ORdate: "2020-10-10",
	Location: "location",
	OR: 10,
	Size: 10,
	Pathology: 10,
	Grade: "Grade",
	Margin: "Margin",
	T: "T string",
	N: "N string",
	Nve: "Nodes+ve string",
	Ntaken: "Nodes taken",
	M: "M string",
	Stage: "Stage string",
	LVSI: true,
	Peri: false,
	Pathology: 10,
    },
}

function ORinfo() {
    
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
                        <Collapsible trigger="OR Information" triggerTagName='h3'  overflowWhenOpen="inherit">
                      <br></br>
                        <Grid container spacing={3} width={'70vw'}>
                            <Grid item xs={6}>
                                <DatePicker
                                        fullWidth
                                        name="ORInformation.ORdate"
                                        label="OR Date"
                                    />
                                </Grid>

                            <Grid item xs={6}>
                                    <TextField
                                        name="ORInformation.Location"
                                        label="Location"
                                    />
                                </Grid>

                            <Grid item xs={6}>
                            <h5>LVSI</h5>
                                <label>
                                    <Field type="checkbox" name="ORInformation.LVSI" />
                                </label>
                            </Grid>

                            <Grid item xs={6}>
                            <h5>PeriNeur</h5>
                                <label>
                                    <Field type="checkbox" name="ORInformation.Peri" />
                                </label>
                            </Grid>
 
                            <Grid item xs={6}>                                 
                                    <TextField 
                                        name="ORInformation.T"
                                        label="T"
                                         />
                            </Grid>

                            <Grid item xs={6}>
                                    <TextField 
                                        name="ORInformation.N"
                                        label="N"
                                         />
                            </Grid>

                            <Grid item xs={6}>
                                    <TextField 
                                        name="ORInformation.Nve"
                                        label="N+ve"
                                         />
                            </Grid>

                            <Grid item xs={6}>
                                    <TextField 
                                        name="ORInformation.Ntaken"
                                        label="N Taken"
                                         />
                            </Grid>

                            <Grid item xs={6}>
                                    <TextField 
                                        name="ORInformation.M"
                                        label="M"
                                         />
                            </Grid>

                            <Grid item xs={6}>
                                    <TextField 
                                        name="ORInformation.Stage"
                                        label="Stage"
                                         />
                            </Grid>
 
                            <Grid item xs={6}>
                                    <TextField 
                                        name="ORInformation.Pathology"
                                        label="Pathology"
                                         />
                            </Grid>
                                <hr></hr>
                                
                            <Grid item xs={12}>
                                    <Button onClick={notify} color='primary' type="submit">Save</Button>
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

export default ORinfo;