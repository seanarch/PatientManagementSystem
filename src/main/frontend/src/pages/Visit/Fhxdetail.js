import React, { useEffect } from 'react';
import { useFormik, Formik, Form, Field } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl, Checkbox } from '@material-ui/core';
import { TextField } from "@material-ui/core/";
import DatePicker from '../../components/Date/DatePicker';
import axios from "axios"; 
import Collapsible from 'react-collapsible';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
 
 

function Fhxdetail() {

    const userid = -2144486835;
    
    const formik = useFormik({
        enableReinitialize: true,
        initialValues: {
            fhxDetail: "",
            smokingPackYears: 0,
            smokeQuit: "",
            attendedFamily: false,
            lacksSocialSupport: false,
            languageBarrier: false,
            financialChallenge: true,
            psychosocialChallenge: true,
            etohweek: true,
            detail: "",
        },

        onSubmit: async (values) => {
            console.log(values);
            try {
            let result = await fetch(
                `http://localhost:8080/api/pasthistory/update/`,
                {
                  method: "post",
                  mode: "cors",
                  headers: {
                    "Content-Type": "application/json"
                  },
                  body: `{
                           "id": "${userid}",
                           "fhxDetail": "${values.fhxDetail}",
                           "smokingPackYears": "${values.smokingPackYears}",
                           "smokeQuit": "${values.smokeQuit}",
                           "attendedFamily": "${values.attendedFamily}",
                           "lacksSocialSupport": "${values.lacksSocialSupport}",
                           "languageBarrier": "${values.languageBarrier}",
                           "financialChallenge": "${values.financialChallenge}",
                           "psychosocialChallenge": "${values.psychosocialChallenge}",
                           "etohweek": "${values.etohweek}",
                           "detail": "${values.detail}"
                         }`
                }
              );
              console.log("Submited: " + result);
            } catch (e) {
              console.log(e);
            }
          }
        });

        useEffect(() => {
            (async () => {
              try {
                let response = await fetch(
                  `http://localhost:8080/api/pasthistory/id=${userid}`
                );
                let content = await response.json();
                formik.setValues(content);
                // formik.setFieldValue("email", content[0].email);
              } catch (e) {
                console.log(e);
              }
            })();
            // eslint-disable-next-line react-hooks/exhaustive-deps
          }, []);

 
    
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
             
                 
                    <form onSubmit={formik.handleSubmit}>
                        <Collapsible trigger="Fhx Information" triggerTagName='h3'  overflowWhenOpen="inherit">
                      <br></br>

                        <Grid container spacing={3} width={'70vw'}>

                                <Grid item xs={6}>
                                        <TextField
                                            label="FHX detail"
                                            name="fhxDetail"
                                            value={formik.values.fhxDetail}
                                            onChange={formik.handleChange}
                                            fullWidth
                                        />
                                    </Grid>

                                <Grid item xs={6}>
                                        <TextField
                                            label="Smoking Pack Years"
                                            name="smokingPackYears"
                                            value={formik.values.smokingPackYears}
                                            onChange={formik.handleChange}
                                            fullWidth
                                        />
                                    </Grid>

                                <Grid item xs={12}>
                                        <TextField
                                            label="Smoke quit"
                                            name="smokeQuit"
                                            value={formik.values.smokeQuit}
                                            onChange={formik.handleChange}
                                            fullWidth
                                        />
                                    </Grid>
 
                                    <Grid item xs={6}>

                                    <h5>Attended Family</h5>
                                    <input type="checkbox" 
                                    name="attendedFamily"
                                    checked={formik.values.attendedFamily} 
                                    onChange={formik.handleChange}/>

                                    </Grid>
 
                                    <Grid item xs={6}>

                                    <h5>Social Support</h5>
                                    <input type="checkbox" 
                                    name="lacksSocialSupport"
                                    checked={formik.values.lacksSocialSupport} 
                                    onChange={formik.handleChange}/>

                                    </Grid>
 
                                    <Grid item xs={6}>

                                    <h5>Language Barrier</h5>
                                    <input type="checkbox" 
                                    name="languageBarrier"
                                    checked={formik.values.languageBarrier} 
                                    onChange={formik.handleChange}/>

                                    </Grid>
 
                                    <Grid item xs={6}>

                                    <h5>Financial Challenge</h5>
                                    <input type="checkbox" 
                                    name="financialChallenge"
                                    checked={formik.values.financialChallenge} 
                                    onChange={formik.handleChange}/>

                                    </Grid>
 
                                    <Grid item xs={6}>

                                    <h5>Psychosocial Challenge</h5>
                                    <input type="checkbox" 
                                    name="psychosocialChallenge"
                                    checked={formik.values.psychosocialChallenge} 
                                    onChange={formik.handleChange}/>

                                    </Grid>
 
                                    <Grid item xs={6}>

                                    <h5>etohweek</h5>
                                    <input type="checkbox" 
                                    name="etohweek"
                                    checked={formik.values.etohweek} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={12}>
                                        <TextField
                                            label="Detail"
                                            name="detail"
                                            value={formik.values.detail}
                                            onChange={formik.handleChange}
                                            multiline
                                            rows={3}
                                            fullWidth
                                        />
                                    </Grid>
 

                            <Grid item xs={12}>
                                    <Button onClick={notify} color='primary' type="submit">Save</Button>
                                    <ToastContainer />
                            </Grid>
                        </Grid>

                      </Collapsible>
                        
                    </form>
 
        </div>
    </Container>
    )
}

export default Fhxdetail;