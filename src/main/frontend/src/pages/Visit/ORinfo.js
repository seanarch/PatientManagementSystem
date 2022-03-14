import React from 'react';
import { Formik, Form, Field } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl, Checkbox } from '@material-ui/core';
import TextField from '../../components/TextField/TextField';
import DatePicker from '../../components/Date/DatePicker';
import axios from "axios"; 
 
 

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

const ORinfo = () => {
    

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
                        <h3>OR Information</h3>
                        <Grid container spacing={3} width={'70vw'}>
                            <Grid item xs={12}>
                                <DatePicker
                                        fullWidth
                                        name="ORInformation.ORdate"
                                        label="OR Date"
                                    />
                                </Grid>

                            <Grid item xs={12}>
                                    <TextField
                                        name="ORInformation.Location"
                                        label="Location"
                                    />
                                </Grid>

                            <Grid item xs={12}>
                            <h5>LVSI</h5>
                                <label>
                                    <Field type="checkbox" name="ORInformation.LVSI" />
                                </label>
                            </Grid>

                            <Grid item xs={12}>
                            <h5>PeriNeur</h5>
                                <label>
                                    <Field type="checkbox" name="ORInformation.Peri" />
                                </label>
                            </Grid>
 
                            <Grid item xs={12}>
                                <label>
                                    <TextField 
                                        name="ORInformation.T"
                                        label="T"
                                         />
                                </label>
                            </Grid>

                            <Grid item xs={12}>
                                <label>
                                    <TextField 
                                        name="ORInformation.N"
                                        label="N"
                                         />
                                </label>
                            </Grid>

                            <Grid item xs={12}>
                                <label>
                                    <TextField 
                                        name="ORInformation.Nve"
                                        label="N+ve"
                                         />
                                </label>
                            </Grid>

                            <Grid item xs={12}>
                                <label>
                                    <TextField 
                                        name="ORInformation.Ntaken"
                                        label="N Taken"
                                         />
                                </label>
                            </Grid>

                            <Grid item xs={12}>
                                <label>
                                    <TextField 
                                        name="ORInformation.M"
                                        label="M"
                                         />
                                </label>
                            </Grid>

                            <Grid item xs={12}>
                                <label>
                                    <TextField 
                                        name="ORInformation.Stage"
                                        label="Stage"
                                         />
                                </label>
                            </Grid>
 
                            <Grid item xs={12}>
                                <label>
                                    <TextField 
                                        name="ORInformation.Pathology"
                                        label="Pathology"
                                         />
                                </label>
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

export default ORinfo;