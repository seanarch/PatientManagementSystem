import React, { useState, useEffect } from 'react';
import { useFormik, Formik, Form, Field } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl, Checkbox } from '@material-ui/core';
import { TextField } from "@material-ui/core/";
import Collapsible from 'react-collapsible'; 
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useGlobalState } from '../../components/Globalstate';

 
 

function ORinfo() {

    const userid = parseInt(useGlobalState("userid"));

    const formik = useFormik({
        enableReinitialize: true,
        initialValues: {
            ordate: "",
            locationId: 0,
            orId: 0,
            sizePrimaryMm: 0,
            pathologyId: 0,
            grade: "",
            margin: "",
            t: "",
            n: "",
            nodesVe: "",
            nodesTaken: "",
            m: "",
            stage: "",
            lvsi: 0,
            periNeural: "",
            pathologyDescription: "",
        },

        onSubmit: async (values) => {
            console.log(values);
            try {
            let result = await fetch(
                `http://localhost:8080/api/diagnosis/update/`,
                {
                  method: "post",
                  mode: "cors",
                  headers: {
                    "Content-Type": "application/json"
                  },
                  body: `{
                           "uliId": "${userid}",
                           "ordate": "${values.ordate}",
                           "locationId": "${values.locationId}",
                           "orId": "${values.orId}",
                           "sizePrimaryMm": "${values.sizePrimaryMm}",
                           "pathologyId": "${values.pathologyId}",
                           "grade": "${values.grade}",
                           "margin": "${values.margin}",
                           "t": "${values.t}",
                           "n": "${values.n}",
                           "nodesVe": "${values.nodesVe}",
                           "nodesTaken": "${values.nodesTaken}",
                           "m": "${values.m}",
                           "stage": "${values.stage}", 
                           "pathologyDescription": "${values.pathologyDescription}"
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
                    `http://localhost:8080/api/diagnosis/uli=${userid}`
                  );
        
                  if (response.ok) {
                    let content = await response.json(); 
                    console.log(content[0]);
                    formik.setValues(content[0]);
                  } else {
                    let response = await fetch(
                      `http://localhost:8080/api/diagnosis/uli=145509461`);
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
                        <Collapsible trigger="OR Information" triggerTagName='h3'  overflowWhenOpen="inherit">
                      <br></br>
                        <Grid container spacing={3} width={'70vw'}>
                            <Grid item xs={6}>
                                <TextField
                                        fullWidth
                                        label="OR date"
                                        name="ordate"
                                        InputLabelProps={{ shrink: true}}
                                        value={formik.values.ordate}
                                        onChange={formik.handleChange}
                                         
                                    />
                                </Grid>

                            <Grid item xs={6}>
                                    <TextField
                                        fullWidth
                                        label="Location ID"
                                        name="locationId"
                                        InputLabelProps={{ shrink: true}}
                                        value={formik.values.locationId}
                                        onChange={formik.handleChange}
                                    />
                                </Grid>

 
 

                            <Grid item xs={6}>
                                    <TextField
                                        fullWidth
                                        label="OR ID"
                                        name="orId"
                                        InputLabelProps={{ shrink: true}}
                                        value={formik.values.orId}
                                        onChange={formik.handleChange}
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                        fullWidth
                                        label="Size Primary MM"
                                        name="sizePrimaryMm"
                                        InputLabelProps={{ shrink: true}}
                                        value={formik.values.sizePrimaryMm}
                                        onChange={formik.handleChange}
                                    />
                                </Grid>
   
                                <Grid item xs={6}>
                                    <TextField
                                        fullWidth
                                        label="Pathology ID"
                                        name="pathologyId"
                                        value={formik.values.pathologyId}
                                        onChange={formik.handleChange}
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                        fullWidth
                                        label="Grade"
                                        name="grade"
                                        InputLabelProps={{ shrink: true}}
                                        value={formik.values.grade}
                                        onChange={formik.handleChange}
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                        fullWidth
                                        label="Margin"
                                        name="margin"
                                        InputLabelProps={{ shrink: true}}
                                        value={formik.values.margin}
                                        onChange={formik.handleChange}
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                        fullWidth
                                        label="T"
                                        name="t"
                                        InputLabelProps={{ shrink: true}}
                                        value={formik.values.t}
                                        onChange={formik.handleChange}
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                        fullWidth
                                        label="N"
                                        name="n"
                                        InputLabelProps={{ shrink: true}}
                                        value={formik.values.n}
                                        onChange={formik.handleChange}
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                        fullWidth
                                        label="nodesVe"
                                        name="nodesVe"
                                        InputLabelProps={{ shrink: true}}
                                        value={formik.values.nodesVe}
                                        onChange={formik.handleChange}
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                        fullWidth
                                        label="nodesTaken"
                                        name="nodesTaken"
                                        InputLabelProps={{ shrink: true}}
                                        value={formik.values.nodesTaken}
                                        onChange={formik.handleChange}
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                        fullWidth
                                        label="M"
                                        name="m"
                                        InputLabelProps={{ shrink: true}}
                                        value={formik.values.m}
                                        onChange={formik.handleChange}
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                        fullWidth
                                        label="Stage"
                                        name="stage"
                                        InputLabelProps={{ shrink: true}}
                                        value={formik.values.stage}
                                        onChange={formik.handleChange}
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

export default ORinfo;