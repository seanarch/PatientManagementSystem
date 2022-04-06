import React, {useEffect} from 'react';
import { useFormik, Formik, Form } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl } from '@material-ui/core';
import { TextareaAutosize } from '@mui/base';
import { TextField } from "@material-ui/core/";  
import axios from "axios"; 
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';



const Consider = () => {

    const userid = 4;

    const formik = useFormik({
        enableReinitialize: true,
        initialValues: {
            detail: "" 
 
        }, 

        onSubmit: async (values) => {
            console.log(values);
            try {
            let result = await fetch(
                `http://localhost:8080/api/consider/update/`,
                {
                  method: "post",
                  mode: "cors",
                  headers: {
                    "Content-Type": "application/json"
                  },
                  body: `{
                           "id": "${userid}",
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
                  `http://localhost:8080/api/consider/id=${userid}`
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
                    <h3>Consideration & Decision </h3>
                        <Grid container spacing={3} width={'70vw'}>
                        
 

                            <Grid item xs={12}>
                            <TextField
                                fullWidth
                                label="Consider"
                                name="detail"
                                value={formik.values.detail}
                                onChange={formik.handleChange}
                                multiline
                                rows={4}
                            />
                            </Grid>

                                 

                                <Grid item xs={12}>
                                    <Button onClick={notify} color='primary' type="submit">Save</Button>
                                    <ToastContainer />
                                </Grid>
                            </Grid>
                        
                    </form>
             
        </div>
    </Container>
    )
}

export default Consider;