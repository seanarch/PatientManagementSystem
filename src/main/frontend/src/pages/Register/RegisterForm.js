import React from 'react';
import { useFormik, Formik, Form } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl } from '@material-ui/core';
import { TextField } from "@material-ui/core/";
import DatePicker from '../../components/Date/DatePicker';
import Collapsible from 'react-collapsible';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';



function RegisterForm() {

     

    const formik = useFormik({
        enableReinitialize: true,
        initialValues: {
            lastname: "",
            firstname: "",
            sex: "",
            birthday: "",
            id: "",
            tg: "",
            location: "",
            newdate: "",
            print: ""

        },

        onSubmit: async (values) => {
            console.log(values);
            try {
            let result = await fetch(
                `http://localhost:8080/api/patient/new/`,
                {
                  method: "post",
                  mode: "cors",
                  headers: {
                    "Content-Type": "application/json"
                  },
                  body: `{
                           "id": "${values.id}",
                           "lastname": "${values.lastname}",
                           "firstname": "${values.firstname}",
                           "sex": "${values.sex}",
                           "birthday": "${values.birthday}",
                           "print": "${values.print}",
                           "tg": "${values.tg}",
                           "location": "${values.location}"
                         }`
                }
              );
              console.log("Submited: " + result);
            } catch (e) {
              console.log(e);
            }
          }
        });

    const notify = () => {

        toast.success('Successfully created!', {
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
                         
                            <Collapsible  trigger="Create New Patient" triggerTagName='h3'   overflowWhenOpen="inherit">
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
                                            label="ULI"
                                            name="id"
                                            value={formik.values.id}
                                            onChange={formik.handleChange}
                                            fullWidth
                                            required
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
                                        <Button color='primary' type="submit" onClick={notify}>Create</Button>
                                        <ToastContainer />
                                    </Grid>
                                </Grid>
                                
                            </Collapsible>

                        </form>
                   
            </div>
        </Container>
    )
}

export default RegisterForm;