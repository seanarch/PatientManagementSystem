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
import { textAlign } from '@material-ui/system';

const INITIAL_VALUES = {
    Symptom1: {
        Date1: "2021-03-17",
        Date2: "2021-03-17",
        Symptom: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.", 
    },
    SymptomCheckbox1: {
        Fevers: false,
        SOB: false,
        Nocturea: false,
        BADL: false,
        Cough: false,
        Hesitancy: false,
        IADLs: false,
        Hemoptisis: false,
        Hematurea: false,
        WTLoss: false,
        Wheeze: false,
        Pneumature: false,
        BackBone: false,
        ChestPain: false,
    },
    SymptomCheckbox2: {
        Headache: true,
        AppetiteLost: true,
        NauseaVo: true,
        VisionCha: true,
        ChewSwallow: true,
        Heartburn: true,
        Hearing:  true,
        Abdominal: true,
        BowelHab: true,
        SpeechCha: true,
        Hemeteme: true,
        RectalBlee: true,
        FocalWea: true,
        Melena: true,
    },
    Symptom2: {
        Date: "2021-04-22",
        ECOG: "String",
        Swallowing: "String",
        Breathing: "String",
    }
}
 

function Symptons() {

    const notify = () => {
     
        toast.success('Successfully saved!', {
          position: toast.POSITION.TOP_RIGHT,
          autoClose: 2000
        })
    }

  return (   <Container maxWidth="md">
  <div className='container' style={{
      display: 'flex', justifyContent:
          'center', alignItems: 'center', marginTop: '50px', marginBottom: '25px'
  }}>
      <Formik initialValues={{ ...INITIAL_VALUES }} onSubmit={values => {
          console.log(values) 
      }}
>
          {props => (
              <Form>
                  <Collapsible trigger="Symptoms" triggerTagName='h3' overflowWhenOpen="inherit">
                      <br></br>
                  <Grid container spacing={3} width={'70vw'}>
                      <Grid item xs={6}>
                          <DatePicker
                                  fullWidth
                                  name="Symptom1.Date1"
                                  label="Date1"
                              />
                          </Grid>
                      <Grid item xs={6}>
                          <DatePicker
                                  fullWidth
                                  name="Symptom1.Date2"
                                  label="Date2"
                              />
                          </Grid>

                          <Grid item xs={12}>
                                    <TextField
                                        fullWidth
                                        label="Symptom"
                                        name="Symptom1.Symptom"
                                        multiline
                                        rows={4}
                                    />
                                    </Grid>

                            <Grid item xs={3}>
                            <h5>Fevers</h5>
                                <label>
                                    <Field type="checkbox" name="SymptomCheckbox1.Fevers" />
                                </label>
                            </Grid>

                            <Grid item xs={3}>
                            <h5>SOB</h5>
                                <label>
                                    <Field type="checkbox" name="SymptomCheckbox1.SOB" />
                                </label>
                            </Grid>

                            <Grid item xs={3}>
                            <h5>Nocturea</h5>
                                <label>
                                    <Field type="checkbox" name="SymptomCheckbox1.Nocturea" />
                                </label>
                            </Grid>

                            <Grid item xs={3}>
                            <h5>BADL</h5>
                                <label>
                                    <Field type="checkbox" name="SymptomCheckbox1.BADL" />
                                </label>
                            </Grid>

                            <Grid item xs={3}>
                            <h5>Cough</h5>
                                <label>
                                    <Field type="checkbox" name="SymptomCheckbox1.Cough" />
                                </label>
                            </Grid>

                            <Grid item xs={3}>
                            <h5>Hesitancy</h5>
                                <label>
                                    <Field type="checkbox" name="SymptomCheckbox1.Hesitancy" />
                                </label>
                            </Grid>

                            <Grid item xs={3}>
                            <h5>IADLs</h5>
                                <label>
                                    <Field type="checkbox" name="SymptomCheckbox1.IADLs" />
                                </label>
                            </Grid>

                            <Grid item xs={3}>
                            <h5>Hemoptisis</h5>
                                <label>
                                    <Field type="checkbox" name="SymptomCheckbox1.Hemoptisis" />
                                </label>
                            </Grid>

                            <Grid item xs={3}>
                            <h5>WTLoss</h5>
                                <label>
                                    <Field type="checkbox" name="SymptomCheckbox1.WTLoss" />
                                </label>
                            </Grid>

                            <Grid item xs={3}>
                            <h5>Wheeze</h5>
                                <label>
                                    <Field type="checkbox" name="SymptomCheckbox1.Wheeze" />
                                </label>
                            </Grid>

                            <Grid item xs={3}>
                            <h5>Pneumature</h5>
                                <label>
                                    <Field type="checkbox" name="SymptomCheckbox1.Pneumature" />
                                </label>
                            </Grid>

                            <Grid item xs={3}>
                            <h5>BackBone</h5>
                                <label>
                                    <Field type="checkbox" name="SymptomCheckbox1.BackBone" />
                                </label>
                            </Grid>

                            <Grid item xs={3}>
                            <h5>ChestPain</h5>
                                <label>
                                    <Field type="checkbox" name="SymptomCheckbox1.ChestPain" />
                                </label>
                            </Grid>

                            <Grid item xs={3}>
                            <h5>Headache</h5>
                                <label>
                                    <Field type="checkbox" name="SymptomCheckbox2.Headache" />
                                </label>
                            </Grid>

                            <Grid item xs={3}>
                            <h5>AppetiteLost</h5>
                                <label>
                                    <Field type="checkbox" name="SymptomCheckbox2.AppetiteLost" />
                                </label>
                            </Grid>

                            <Grid item xs={3}>
                            <h5>NauseaVo</h5>
                                <label>
                                    <Field type="checkbox" name="SymptomCheckbox2.NauseaVo" />
                                </label>
                            </Grid>

                            <Grid item xs={3}>
                            <h5>VisionCha</h5>
                                <label>
                                    <Field type="checkbox" name="SymptomCheckbox2.VisionCha" />
                                </label>
                            </Grid>

                            <Grid item xs={3}>
                            <h5>ChewSwallow</h5>
                                <label>
                                    <Field type="checkbox" name="SymptomCheckbox2.ChewSwallow" />
                                </label>
                            </Grid>

                            <Grid item xs={3}>
                            <h5>Heartburn</h5>
                                <label>
                                    <Field type="checkbox" name="SymptomCheckbox2.Heartburn" />
                                </label>
                            </Grid>

                            <Grid item xs={3}>
                            <h5>Hearing</h5>
                                <label>
                                    <Field type="checkbox" name="SymptomCheckbox2.Hearing" />
                                </label>
                            </Grid>

                            <Grid item xs={3}>
                            <h5>Abdominal</h5>
                                <label>
                                    <Field type="checkbox" name="SymptomCheckbox2.Abdominal" />
                                </label>
                            </Grid>

                            <Grid item xs={3}>
                            <h5>BowelHab</h5>
                                <label>
                                    <Field type="checkbox" name="SymptomCheckbox2.BowelHab" />
                                </label>
                            </Grid>

                            <Grid item xs={3}>
                            <h5>SpeechCha</h5>
                                <label>
                                    <Field type="checkbox" name="SymptomCheckbox2.SpeechCha" />
                                </label>
                            </Grid>

                            <Grid item xs={3}>
                            <h5>Hemeteme</h5>
                                <label>
                                    <Field type="checkbox" name="SymptomCheckbox2.Hemeteme" />
                                </label>
                            </Grid>

                            <Grid item xs={3}>
                            <h5>RectalBlee</h5>
                                <label>
                                    <Field type="checkbox" name="SymptomCheckbox2.RectalBlee" />
                                </label>
                            </Grid>

                            <Grid item xs={3}>
                            <h5>FocalWea</h5>
                                <label>
                                    <Field type="checkbox" name="SymptomCheckbox2.FocalWea" />
                                </label>
                            </Grid>

                            <Grid item xs={3}>
                            <h5>Melena</h5>
                                <label>
                                    <Field type="checkbox" name="SymptomCheckbox2.Melena" />
                                </label>
                            </Grid>
 
                          <Grid item xs={6}>
                          <DatePicker
                                  fullWidth
                                  name="Symptom2.Date"
                                  label="Date"
                              />
                          </Grid>

                          <Grid item xs={6}>
                                    <TextField
                                        name="Symptom2.ECOG"
                                        label="ECOG"
                                    />
                                </Grid>                       
                                
                                <Grid item xs={6}>
                                    <TextField
                                        name="Symptom2.Swallowing"
                                        label="Swallowing"
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                        name="Symptom2.Breathing"
                                        label="Breathing"
                                    />
                                </Grid>

                          <Grid item xs={6}>
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

export default Symptons