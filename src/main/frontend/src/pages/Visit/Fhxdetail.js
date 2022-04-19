import React, { useState, useEffect } from 'react';
import { useFormik, Formik, Form, Field } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl, Checkbox } from '@material-ui/core';
import { TextField } from "@material-ui/core/";
import Collapsible from 'react-collapsible';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useGlobalState } from '../../components/Globalstate';
 
 

function Fhxdetail() {

    const userid = parseInt(useGlobalState("userid"));


    const formik = useFormik({
        enableReinitialize: true,
        initialValues: {
            fhxDetail: "",
            smokingPackYears: 0,
            smokeQuit: "",
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
                  `http://localhost:8080/api/pasthistory/uli=${userid}`
                );
      
                if (response.ok) {
                  let content = await response.json(); 
                  console.log(content[0]);
                  formik.setValues(content[0]);
                } else {
                  let response = await fetch(
                    `http://localhost:8080/api/pasthistory/uli=123456789`);
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