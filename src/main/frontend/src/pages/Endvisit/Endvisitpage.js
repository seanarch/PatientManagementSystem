import React from 'react';
import { Formik, Form } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl } from '@material-ui/core';
import { TextareaAutosize } from '@mui/base';
import TextField from '../../components/TextField/TextField';
import DatePicker from '../../components/Date/DatePicker';
import axios from "axios"; 
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


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
                        <h3>Consideration and decision</h3>
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
                                    <Button onClick={notify} color='primary' type="submit">Save</Button>
                                    <ToastContainer />
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