import React from 'react';
import { Formik, Form, Field } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl, Checkbox } from '@material-ui/core';
import TextField from '../../components/TextField/TextField';
import DatePicker from '../../components/Date/DatePicker';
import axios from "axios";
import Collapsible from 'react-collapsible'; 

const INITIAL_VALUES = {
    RTinfo: {
        DateRTStart: "2021-03-17",
        DateRTEnd: "2021-03-17",
        TypeRT: 11,
        Location: "Location",
        RTDose: 10.10,
        Fraction: 10,
        Planning: 10,
        AnatDetail: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.", 
    },
    GIinfo: {
        ClinicRes: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.", 
        Pneumoitis: 10,
        UpperGI: 10,
        SkinReaction: 10,
        LowerGI: 10,
        GU: 10,
        Hepatic: 10,
        Heme: 10,
    }
}
 

function RTGIinfo() {
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
                    <h3>RT & GI Information</h3>
                    <Collapsible trigger="[+]">
                      <br></br>

                    <Grid container spacing={3} width={'70vw'}>
                        <Grid item xs={12}>
                            <DatePicker
                                    fullWidth
                                    name="RTinfo.DateRTStart"
                                    label="DateRTStart"
                                />
                            </Grid>
                        <Grid item xs={12}>
                            <DatePicker
                                    fullWidth
                                    name="RTinfo.DateRTEnd"
                                    label="DateRTEnd"
                                />
                            </Grid>
                            <Grid item xs={12}>
                                <TextField
                                    name="RTinfo.TypeRT"
                                    label="TypeRT"
                                />
                            </Grid>
                            <Grid item xs={12}>
                                <TextField
                                    name="RTinfo.Location"
                                    label="Location"
                                />
                            </Grid>
                        <Grid item xs={12}>
                                <TextField
                                    name="RTinfo.RTDose"
                                    label="RT Dose"
                                />
                            </Grid>
                        <Grid item xs={12}>
                                <TextField
                                    name="RTinfo.Fraction"
                                    label="Fraction"
                                />
                            </Grid>
                        <Grid item xs={12}>
                                <TextField
                                    name="RTinfo.Planning"
                                    label="Planning"
                                />
                            </Grid>

                            <Grid item xs={12}>
                                    <TextField
                                        fullWidth
                                        label="AnatDetail"
                                        name="RTinfo.AnatDetail"
                                        multiline
                                        rows={4}
                                    />
                                    </Grid>
                             
                             
                            <Grid item xs={12}>
                                    <TextField
                                        fullWidth
                                        label="GI Information"
                                        name="GIinfo.ClinicRes"
                                        multiline
                                        rows={4}
                                    />
                                    </Grid>

                            <Grid item xs={12}>
                                <TextField
                                    name="GIinfo.Pneumoitis"
                                    label="Pneumoitis"
                                />
                            </Grid>

                            <Grid item xs={12}>
                                <TextField
                                    name="GIinfo.UpperGI"
                                    label="UpperGI"
                                />
                            </Grid>

                            <Grid item xs={12}>
                                <TextField
                                    name="GIinfo.SkinReaction"
                                    label="SkinReaction"
                                />
                            </Grid>

                            <Grid item xs={12}>
                                <TextField
                                    name="GIinfo.LowerGI"
                                    label="LowerGI"
                                />
                            </Grid>

                            <Grid item xs={12}>
                                <TextField
                                    name="GIinfo.GU"
                                    label="GU"
                                />
                            </Grid>

                            <Grid item xs={12}>
                                <TextField
                                    name="GIinfo.Hepatic"
                                    label="Hepatic"
                                />
                            </Grid>

                            <Grid item xs={12}>
                                <TextField
                                    name="GIinfo.Heme"
                                    label="Heme"
                                />
                            </Grid>

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

export default RTGIinfo