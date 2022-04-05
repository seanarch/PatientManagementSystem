import React, { useEffect } from 'react';
import { useFormik, Formik, Form } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl } from '@material-ui/core';
import { TextField } from "@material-ui/core/";
import DatePicker from '../../components/Date/DatePicker';
import axios from "axios"; 
import Collapsible from 'react-collapsible';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


function FVCFEVInfo() {

    const userid = -2077191396;

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
                           "id": "${userid}",
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
                  `http://localhost:8080/api/pulmonaryfunctiontest/id=${userid}`
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
                'center', alignItems: 'center', marginTop: '50px',marginBottom: '25px'
        }}>

             <form onSubmit={formik.handleSubmit}>
                     
                     
 
                
                        <Collapsible trigger="FVC FEV Information" triggerTagName='h3'  overflowWhenOpen="inherit">
                         <br></br>
                        <Grid container spacing={3} width={'70vw'}>
                        <Grid item xs={6}>
                                        <TextField
                                            label="date"
                                            name="date"
                                            value={formik.values.date}
                                            onChange={formik.handleChange}
                                            fullWidth
                                        />
                                    </Grid>
                        
                                    <Grid item xs={6}>
                                        <TextField
                                            label="fvc"
                                            name="fvc"
                                            value={formik.values.fvc}
                                            onChange={formik.handleChange}
                                            fullWidth
                                        />
                                    </Grid>

                                    <Grid item xs={6}>
                                        <TextField
                                            label="fvc1"
                                            name="fvc1"
                                            value={formik.values.fvc1}
                                            onChange={formik.handleChange}
                                            fullWidth
                                        />
                                    </Grid>

                                    <Grid item xs={6}>
                                        <TextField
                                            label="fev1"
                                            name="fev1"
                                            value={formik.values.fev1}
                                            onChange={formik.handleChange}
                                            fullWidth
                                        />
                                    </Grid>

                                    <Grid item xs={6}>
                                        <TextField
                                            label="fev11"
                                            name="fev11"
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