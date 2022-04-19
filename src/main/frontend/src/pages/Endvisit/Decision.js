import React, { useState, useEffect} from 'react';
import { useFormik, Formik, Form } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl } from '@material-ui/core';
import { TextareaAutosize } from '@mui/base';
import { TextField } from "@material-ui/core/";  
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useGlobalState } from '../../components/Globalstate';



const Decision = () => {

    const userid = parseInt(useGlobalState("userid"));

    const formik = useFormik({
        enableReinitialize: true,
        initialValues: {
            detail: "" 
 
        }, 

        onSubmit: async (values) => {
            console.log(values);
            try {
            let result = await fetch(
                `http://localhost:8080/api/decision/update/`,
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
                  `http://localhost:8080/api/decision/uli=${userid}`
                );
      
                if (response.ok) {
                  let content = await response.json(); 
                  console.log(content[0]);
                  formik.setValues(content[0]);
                } else {
                  let response = await fetch(
                    `http://localhost:8080/api/decision/uli=612399531`);
                  let content = await response.json(); 
                  console.log(content[0]);
                  formik.setValues(content[0]);
                } 
                 
              }
              catch (e) {
                console.log(e);
              }
            
          })();
        
        }, [userid]);

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
                        <Grid container spacing={3} width={'70vw'}>
                        
  
                            <Grid item xs={12}>
                            <TextField
                                fullWidth
                                label="Decision detail"
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

export default Decision;