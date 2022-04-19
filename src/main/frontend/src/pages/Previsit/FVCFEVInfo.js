import React, { useState, useEffect } from 'react';
import { useFormik, Formik, Form } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl } from '@material-ui/core';
import { TextField } from "@material-ui/core/";
import Collapsible from 'react-collapsible';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useGlobalState } from '../../components/Globalstate';



function FVCFEVInfo() {

    const userid = parseInt(useGlobalState("userid"));

    const formik = useFormik({
        enableReinitialize: true,
        initialValues: {
            date: "",
            fvc: "",
            fvc1: "",
            fev1: "",
            fev11: "",
            ratio: "",
            dlco: "",

        },

        onSubmit: async (values) => {
            console.log(values);
            try {
            let result = await fetch(
                `http://localhost:8080/api/pulmonaryfunctiontest/update/`,
                {
                  method: "post",
                  mode: "cors",
                  headers: {
                    "Content-Type": "application/json"
                  },
                  body: `{
                           "uliId": "${userid}",
                           "date": "${values.date}",
                           "fvc": "${values.fvc}",
                           "fvc1": "${values.fvc1}",
                           "fev1": "${values.fev1}",
                           "fev11": "${values.fev11}",
                           "ratio": "${values.ratio}",
                           "dlco": "${values.dlco}"
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
                    `http://localhost:8080/api/pulmonaryfunctiontest/uli=${userid}`
                  );
        
                  if (response.ok) {
                    let content = await response.json(); 
                    console.log(content[0]);
                    formik.setValues(content[0]);
                  } else {
                    let response = await fetch(
                      `http://localhost:8080/api/pulmonaryfunctiontest/uli=638000910`);
                    let content = await response.json(); 
                    console.log(content[0]);
                    formik.setValues(content[0]);
                  } 
                   
                }
                catch (e) {
                  console.log(e);
                }
              
            })();
          
          }, [userid])

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
                'center', alignItems: 'center', marginTop: '50px',marginBottom: '25px'
        }}>

             <form onSubmit={formik.handleSubmit}>

                        <Collapsible trigger="FVC FEV Information" triggerTagName='h3'  overflowWhenOpen="inherit">
                         <br></br>
                        <Grid container spacing={3} width={'70vw'}>
                        <Grid item xs={6}>
                                        <TextField
                                            label="Date"
                                            name="date"
                                            value={formik.values.date}
                                            onChange={formik.handleChange}
                                            fullWidth
                                        />
                                    </Grid>
                        
                                    <Grid item xs={6}>
                                        <TextField
                                            label="Forced vital capacity (FVC)"
                                            name="Forced vital capacity (FVC)"
                                            value={formik.values.fvc}
                                            onChange={formik.handleChange}
                                            fullWidth
                                        />
                                    </Grid>

                                    <Grid item xs={6}>
                                        <TextField
                                            label="Forced vital capacity (FVC1)"
                                            name="Forced vital capacity (FVC1)"
                                            value={formik.values.fvc1}
                                            onChange={formik.handleChange}
                                            fullWidth
                                        />
                                    </Grid>

                                    <Grid item xs={6}>
                                        <TextField
                                            label="Forced Expiratory Volume (FEV1)"
                                            name="Forced Expiratory Volume (FEV1)"
                                            value={formik.values.fev1}
                                            onChange={formik.handleChange}
                                            fullWidth
                                        />
                                    </Grid>

                                    <Grid item xs={6}>
                                        <TextField
                                            label="Forced Expiratory Volume (FEV11)"
                                            name="Forced Expiratory Volume (FEV11)"
                                            value={formik.values.fev11}
                                            onChange={formik.handleChange}
                                            fullWidth
                                        />
                                    </Grid>

                                    <Grid item xs={6}>
                                        <TextField
                                            label="ratio"
                                            name="ratio"
                                            value={formik.values.ratio}
                                            onChange={formik.handleChange}
                                            fullWidth
                                        />
                                    </Grid>


                                    <Grid item xs={6}>
                                        <TextField
                                            label="dlco"
                                            name="dlco"
                                            value={formik.values.dlco}
                                            onChange={formik.handleChange}
                                            fullWidth
                                        />
                                    </Grid>
                                    <Grid item xs={12}>
                                        <Button color='primary' type="submit" onClick={notify}>Update</Button>
                                        <ToastContainer />
                                    </Grid>

                            </Grid>
                        </Collapsible>
                    </form>


        </div>
    </Container>
    )
}

export default FVCFEVInfo;