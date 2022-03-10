import React from 'react';
import { Formik, Form } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl } from '@material-ui/core';
import { TextareaAutosize } from '@mui/base';
import TextField from '../../components/TextField/TextFeild';
import DatePicker from '../../components/Date/DatePicker';
import axios from "axios"; 


const INITIAL_VALUES = {
    Endvisit: {
        Consideration: `Long text here Long text here Long text here Long text here Long text here 
        Long text here Long text here Long text here Long text here Long text here 
        Long text here Long text here Long text here Long text here Long text here
        Long text here Long text here Long text here Long text here Long text here
        Long text here Long text here Long text here Long text here Long text here`,
        Decision: `Long text here Long text here Long text here Long text here Long text here 
        Long text here Long text here Long text here Long text here Long text here 
        Long text here Long text here Long text here Long text here Long text here
        Long text here Long text here Long text here Long text here Long text here
        Long text here Long text here Long text here Long text here Long text here`
    },
}

const Endvisitpage = () => {
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
                        
                        <Grid container spacing={3} width={'70vw'}>
                        
                        <Grid item xs={12}>
                            <TextField
                                fullWidth
                                label="Consideration"
                                name="Endvisit.Consideration"
                                multiline
                                rows={4}
                            />
                            </Grid>

                        <Grid item xs={12}>
                            <TextField
                                fullWidth
                                label="Decision"
                                name="Endvisit.Decision"
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

export default Endvisitpage;