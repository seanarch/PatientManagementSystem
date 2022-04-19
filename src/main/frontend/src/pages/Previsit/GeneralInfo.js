import React, {useEffect} from 'react';
import { useFormik, Formik, Form } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid } from '@material-ui/core';
import { TextField } from "@material-ui/core/"; 
import Collapsible from 'react-collapsible';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useGlobalState } from '../../components/Globalstate';

 

function GeneralInfo() {

    const userid = parseInt(useGlobalState("userid"));

    const formik = useFormik({
        enableReinitialize: true,
        initialValues: {
            datedi: "",
            ctchest: "",
            comments: "",
    
        }, 

        onSubmit: async (values) => {
            console.log(values);
            try {
            let result = await fetch(
                `http://localhost:8080/api/diagnosticimaging/update/`,
                {
                  method: "post",
                  mode: "cors",
                  headers: {
                    "Content-Type": "application/json"
                  },
                  body: `{
                           "uliId": ${userid},
                           "dateDI": "${values.datedi}",
                           "typeDIId": "${values.ctchest}",
                           "finding": "${values.comments}" 
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
                    `http://localhost:8080/api/diagnosticimaging/uli=${userid}`
                  );
        
                  if (response.ok) {
                    let content = await response.json(); 
                    console.log(content[0]);
                    formik.setValues(content[0]);
                  } else {
                    let response = await fetch(
                      `http://localhost:8080/api/diagnosticimaging/uli=836686110`);
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
                 
                        <Collapsible  trigger="General Information" triggerTagName='h3'  overflowWhenOpen="inherit" >
                        <br></br>
                        <Grid container spacing={3} width={'70vw'} >

                        <Grid item xs={6}>
                            <TextField
                            label="Date Diagnosed"
                            name="datedi"
                            value={formik.values.datedi}
                            onChange={formik.handleChange}
                            fullWidth
                            />
                        </Grid>

                        <Grid item xs={6}>
                            <TextField
                            label="Computed Tomography (CT) Chest"
                            name="ctchest"
                            value={formik.values.ctchest}
                            onChange={formik.handleChange}
                            fullWidth
                            />
                        </Grid>

                               
                                <Grid item xs={12}>
                                    <TextField
                                        fullWidth
                                        label="Comments"
                                        name="comments"
                                        value={formik.values.comments}
                                        onChange={formik.handleChange}
                                        multiline
                                        rows={4}
                                    />
                                    </Grid>
                                 

                                <Grid item xs={12}>
                                    <Button color='primary' type="submit" onClick={notify}>Save</Button>
                                    <ToastContainer />
                                </Grid>
                            </Grid>
                        </Collapsible>
                    </form>
           
        </div>
    </Container>
    )
}

export default GeneralInfo;

 