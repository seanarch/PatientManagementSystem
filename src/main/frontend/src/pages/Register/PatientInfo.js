import React, {useEffect} from 'react';
import { useFormik, Formik, Form } from 'formik';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl } from '@material-ui/core';
import { TextField, Button } from "@material-ui/core/"; 
import DatePicker from '../../components/Date/DatePicker';
import Collapsible from 'react-collapsible';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import axios from 'axios';
  
function PatientInfo() {

    const userid = 172867100;

    const formik = useFormik({
        enableReinitialize: true,
        initialValues: {
            lastname: "",
            firstname: "",
            sex: "",
            birthday: "",
            print: "",
            tg: "",
            location: ""
        }, 

        onSubmit: async (values) => {
            console.log(values);
            try {
            let result = await fetch(
                `http://localhost:8080/api/patient/update/id=${userid}`,
                {
                  method: "update",
                  mode: "no-cors",
                  headers: {
                    "Content-Type": "application/x-www-form-urlencoded"
                  },
                  body: `${values.lastname}&${values.firstname}&${values.sex}&${values.birthday}&${values.print}&${values.tg}&${values.location}`
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
                  `http://localhost:8080/api/patient/id=${userid}`
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

        toast.success('Successfully updated!', {
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
                            <h3>Patient Information</h3>
                            <Collapsible trigger="[+]">
                                <br></br>
                                <Grid container spacing={3} width={'70vw'}>
                                    <Grid item xs={6}>
                                        <TextField
                                            label="Lastname"
                                            name="lastname"
                                            value={formik.values.lastname}
                                            onChange={formik.handleChange}
                                            fullWidth
                                        />
                                    </Grid>

                                    <Grid item xs={6}>
                                        <TextField
                                            label="Firstname"
                                            name="firstname"
                                            value={formik.values.firstname}
                                            onChange={formik.handleChange}
                                            fullWidth
                                        />
                                    </Grid>

                                    <Grid item xs={6}>
                                        <TextField
                                            label="Sex"
                                            name="sex"
                                            value={formik.values.sex}
                                            onChange={formik.handleChange}
                                            fullWidth
                                        />
                                    </Grid>

                                    <Grid item xs={6}>
                                        <TextField
                                            label="Birthday"
                                            name="birthday"
                                            value={formik.values.birthday}
                                            onChange={formik.handleChange}
                                            fullWidth
                                        />
                                    </Grid>

                                    <Grid item xs={6}>
                                        <TextField
                                            label="TG"
                                            name="tg"
                                            value={formik.values.tg}
                                            onChange={formik.handleChange}
                                            fullWidth
                                        />
                                    </Grid>

                                    <Grid item xs={6}>
                                        <TextField
                                            label="Location"
                                            name="location"
                                            value={formik.values.location}
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

export default PatientInfo;