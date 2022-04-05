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
    FhxInfo: {
        FhxDetail: "String",
        Smoking: 100,
        SmokingQuit: "3 years",
        Unattended: false,
        SocialSup: false,
        Language: false,
        $Stress: true,
        PsychStress: true,
        ETOHweek: true,
        Details: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        },
}

function Fhxdetail() {
    
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
                        <Collapsible trigger="Fhx Information" triggerTagName='h3'  overflowWhenOpen="inherit">
                      <br></br>

                        <Grid container spacing={3} width={'70vw'}>

                            <Grid item xs={6}>
                                    <TextField
                                        name="FhxInfo.FhxDetail"
                                        label="FhxDetail"
                                    />
                                </Grid>

                            <Grid item xs={6}>
                                    <TextField 
                                    name="FhxInfo.Smoking" 
                                    label="Smoking"
                                    />
                            </Grid>

                            <Grid item xs={12}>
                                    <TextField 
                                    name="FhxInfo.SmokingQuit" 
                                    label="Smoking Quit"
                                    />
                            </Grid>

                            <Grid item xs={6}>
                            <h5>Un-attended</h5>
                                <label>
                                    <Field type="checkbox" name="FhxInfo.Unattended" />
                                </label>
                            </Grid>

                            <Grid item xs={6}>
                            <h5>Lacks social support</h5>
                                <label>
                                    <Field type="checkbox" name="FhxInfo.SocialSup" />
                                </label>
                            </Grid>

                            <Grid item xs={6}>
                            <h5>Language Barrier</h5>
                                <label>
                                    <Field type="checkbox" name="FhxInfo.Language" />
                                </label>
                            </Grid>
                            
                            <Grid item xs={6}>
                            <h5>Financial Challenge</h5>
                                <label>
                                    <Field type="checkbox" name="FhxInfo.$Stress" />
                                </label>
                            </Grid>

                            <Grid item xs={6}>
                            <h5>Psychosocial Challenge</h5>
                                <label>
                                    <Field type="checkbox" name="FhxInfo.PsychStress" />
                                </label>
                            </Grid>

                            <Grid item xs={6}>
                            <h5>ETOH week</h5>
                                <label>
                                    <Field type="checkbox" name="FhxInfo.ETOHweek" />
                                </label>
                            </Grid>

                            <Grid item xs={12}>
                                    <TextField
                                        fullWidth
                                        label="Details"
                                        name="FhxInfo.Details"
                                        multiline
                                        rows={4}
                                    />
                                    </Grid>

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

export default Fhxdetail;