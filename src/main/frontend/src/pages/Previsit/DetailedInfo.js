import React, {useState, useEffect} from 'react';
import { useFormik, Formik, Form } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl, Slider } from '@material-ui/core';
import { TextField } from "@material-ui/core/"; 
import Collapsible from 'react-collapsible';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useGlobalState } from '../../components/Globalstate';


 

function DetailedInfo() {

    const userid = parseInt(useGlobalState("userid"));

    const formik = useFormik({
        enableReinitialize: true,
        initialValues: {
            date: "",
            totalBiliUmolL: "",
            serumAlbGL: "",
            PTINR: "",
            ascites: "",
            hepaticEnch: "",
            cpscore: "",
            childpugh: "",
        }, 

        onSubmit: async (values) => {
            console.log(values);
            try {
            let result = await fetch(
                `http://localhost:8080/api/childpugh/update/`,
                {
                  method: "post",
                  mode: "cors",
                  headers: {
                    "Content-Type": "application/json"
                  },
                  body: `{
                           "uliId": ${userid},
                           "date": "${values.date}",
                           "totalBiliUmolL": "${values.totalBiliUmolL}",
                           "serumAlbGL": "${values.alb}",
                           "PTINR": "${values.PTINR}",
                           "ascites": "${values.ascites}",
                           "hepaticEnch": "${values.hepaticEnch}",
                           "childPughScore": "${values.cpscore}",
                           "childPugh": "${values.childpugh}"
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
                    `http://localhost:8080/api/childpugh/uli=${userid}`
                  );
        
                  if (response.ok) {
                    let content = await response.json(); 
                    console.log(content[0]);
                    formik.setValues(content[0]);
                  } else {
                    let response = await fetch(
                      `http://localhost:8080/api/childpugh/uli=711531521`);
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
                  
                        <Collapsible trigger="Detailed Information" triggerTagName='h3'  overflowWhenOpen="inherit">
                        <br></br>
                        <Grid container spacing={3} width={'70vw'} >

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
                            label="Total BiliUmolL"
                            name="Total BiliUmolL"
                            value={formik.values.totalBiliUmolL}
                            onChange={formik.handleChange}
                            fullWidth
                            />
                        </Grid>

                        <Grid item xs={6}>
                            <TextField
                            label="Serum AlbGL"
                            name="Serum AlbGL"
                            value={formik.values.serumAlbGL}
                            onChange={formik.handleChange}
                            fullWidth
                            />
                        </Grid>
 
 

                                <Grid item xs={12}>
                                    <Button color='primary' type="submit"  onClick={notify}>Save</Button>
                                    <ToastContainer />
                                </Grid>
                            </Grid>
                        </Collapsible>
                    </form>
                
        </div>
    </Container>
    )
}

export default DetailedInfo;