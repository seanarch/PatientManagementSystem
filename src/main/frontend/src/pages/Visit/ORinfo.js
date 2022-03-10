import React from 'react';
import { Formik, Form } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl } from '@material-ui/core';
import TextField from '../../components/TextField/TextFeild';
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
	LVSI: 1,
	Peri: 1,
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