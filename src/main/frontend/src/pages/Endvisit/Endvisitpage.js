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
                        <h3>Consideration</h3>
                                <Grid item xs={12}> 
                                    <TextareaAutosize  
                                        maxRows={10}
                                        aria-label="maximum height" 
                                        defaultValue={INITIAL_VALUES.Endvisit.Consideration} 
                                        style={{ width: 800 }}
                                        name="Consideration"
                                         
                                    />
                                </Grid>

                        <h3>Decision</h3>
                                <Grid item xs={12}> 
                                    <TextareaAutosize  
                                        maxRows={10}
                                        aria-label="maximum height" 
                                        defaultValue={INITIAL_VALUES.Endvisit.Decision} 
                                        style={{ width: 800 }}
                                        name="Decision"
                                         
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