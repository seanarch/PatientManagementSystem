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
 
 

function ORinfo() {

    const userid = -2145721333;

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
                           "id": "${userid}",
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
                           "lvsi": "${values.lvsi}",
                           "periNeural": "${values.periNeural}",
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
                  `http://localhost:8080/api/diagnosis/id=${userid}`
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
                        <Collapsible trigger="OR Information" triggerTagName='h3'  overflowWhenOpen="inherit">
                      <br></br>
                        <Grid container spacing={3} width={'70vw'}>
                            <Grid item xs={6}>
                                <TextField
                                        fullWidth
                                        label="OR date"
                                        name="ordate"
                                        value={formik.values.ordate}
                                        onChange={formik.handleChange}
                                         
                                    />
                                </Grid>

                            <Grid item xs={6}>
                                    <TextField
                                        fullWidth
                                        label="Location ID"
                                        name="locationId"
                                        value={formik.values.locationId}
                                        onChange={formik.handleChange}
                                    />
                                </Grid>

 

                            {/* <Grid item xs={6}>
                            <h5>LVSI</h5>
                                <label>
                                    <Field 
                                    type="checkbox" 
                                    name="lvsi" 
                                    checked={formik.values.lvsi}
                                    onChange={formik.handleChange} />
                                </label>
                            </Grid> */}

                            <Grid item xs={6}>

                            <h5>LVSI</h5>
                            <input type="checkbox" 
                            name="lvsi"
                            checked={formik.values.lvsi} 
                            onChange={formik.handleChange}/>

                            </Grid>

                            <Grid item xs={6}>

                            <h5>periNeural</h5>
                            <input type="checkbox" 
                            name="periNeural"
                            checked={formik.values.periNeural} 
                            onChange={formik.handleChange}/>

                            </Grid>
                            {/* <Grid item xs={6}>
                            <h5>LVSI</h5>
                                <label>
                                    <Field 
                                    type="checkbox" 
                                    name="lvsi" 
                                    value={formik.values.lvsi}
                                    onChange={formik.handleChange} />
                                </label>
                            </Grid> */}

                            <Grid item xs={6}>
                                    <TextField
                                        fullWidth
                                        label="OR ID"
                                        name="orId"
                                        value={formik.values.orId}
                                        onChange={formik.handleChange}
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                        fullWidth
                                        label="Size Primary MM"
                                        name="sizePrimaryMm"
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
                                        value={formik.values.grade}
                                        onChange={formik.handleChange}
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                        fullWidth
                                        label="Margin"
                                        name="margin"
                                        value={formik.values.margin}
                                        onChange={formik.handleChange}
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                        fullWidth
                                        label="T"
                                        name="t"
                                        value={formik.values.t}
                                        onChange={formik.handleChange}
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                        fullWidth
                                        label="N"
                                        name="n"
                                        value={formik.values.n}
                                        onChange={formik.handleChange}
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                        fullWidth
                                        label="nodesVe"
                                        name="nodesVe"
                                        value={formik.values.nodesVe}
                                        onChange={formik.handleChange}
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                        fullWidth
                                        label="nodesTaken"
                                        name="nodesTaken"
                                        value={formik.values.nodesTaken}
                                        onChange={formik.handleChange}
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                        fullWidth
                                        label="M"
                                        name="m"
                                        value={formik.values.m}
                                        onChange={formik.handleChange}
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                        fullWidth
                                        label="Stage"
                                        name="stage"
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