import React, { useState, useEffect } from 'react';
import { useFormik, Formik, Form, Field } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl, Checkbox } from '@material-ui/core';
import { TextField } from "@material-ui/core/";
import Collapsible from 'react-collapsible';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useGlobalState } from '../../components/Globalstate';

 
function RTGIinfo() {

    const userid = parseInt(useGlobalState("userid"));

    const formik = useFormik({
        enableReinitialize: true,
        initialValues: {
            dateRTStart: "",
            dateRTEnd: 0,
            typeRTId: 0,
            locationId: 0,
            rtdose: 0,
            fraction: "",
            planningId: 0,
            anatDetail: "",
            general: "",
            pneumonitisId: "",
            upperGIId: "",
            skinReactionId: "",
            lowerGIId: "",
            guId: 0,
            hepaticId: "",
            hemeId: "",
        },

        onSubmit: async (values) => {
            console.log(values);
            try {
            let result = await fetch(
                `http://localhost:8080/api/radiationtherapy/update/`,
                {
                  method: "post",
                  mode: "cors",
                  headers: {
                    "Content-Type": "application/json"
                  },
                  body: `{
                           "uliId": "${userid}",
                           "dateRTStart": "${values.dateRTStart}",
                           "dateRTEnd": "${values.dateRTEnd}",
                           "typeRTId": "${values.typeRTId}",
                           "locationId": "${values.locationId}",
                           "rtdose": "${values.rtdose}",
                           "fraction": "${values.fraction}",
                           "planningId": "${values.planningId}",
                           "anatDetail": "${values.anatDetail}",
                           "general": "${values.general}",
                           "pneumonitisId": "${values.pneumonitisId}",
                           "upperGIId": "${values.upperGIId}",
                           "skinReactionId": "${values.skinReactionId}",
                           "lowerGIId": "${values.lowerGIId}",
                           "guId": "${values.guId}",
                           "hepaticId": "${values.hepaticId}",
                           "hemeId": "${values.hemeId}"
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
                    `http://localhost:8080/api/radiationtherapy/uli=${userid}`
                  );
        
                  if (response.ok) {
                    let content = await response.json(); 
                    console.log(content[0]);
                    formik.setValues(content[0]);
                  } else {
                    let response = await fetch(
                      `http://localhost:8080/api/radiationtherapy/uli=158861710`);
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

        useEffect(() => {
            (async () => {
              try {
                let response = await fetch(
                  `http://localhost:8080/api/radiationtherapy/id=${userid}`
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
                            <Collapsible trigger="RT & GI Information" triggerTagName='h3' overflowWhenOpen="inherit">
                                <br></br>

                                <Grid container spacing={3} width={'70vw'}>

                                <Grid item xs={6}>
                                    <TextField
                                    label="DateRTStart"
                                    name="dateRTStart"
                                    InputLabelProps={{ shrink: true}}
                                    value={formik.values.dateRTStart}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                    label="DateRTEnd"
                                    name="dateRTEnd"
                                    InputLabelProps={{ shrink: true}}
                                    value={formik.values.dateRTEnd}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                    label="TypeRTId"
                                    name="typeRTId"
                                    InputLabelProps={{ shrink: true}}
                                    value={formik.values.typeRTId}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                    label="LocationId"
                                    name="locationId"
                                    InputLabelProps={{ shrink: true}}
                                    value={formik.values.locationId}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                    label="RT dose"
                                    name="rtdose"
                                    InputLabelProps={{ shrink: true}}
                                    value={formik.values.rtdose}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                    label="Fraction"
                                    name="fraction"
                                    InputLabelProps={{ shrink: true}}
                                    value={formik.values.fraction}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                    label="PlanningId"
                                    name="planningId"
                                    InputLabelProps={{ shrink: true}}
                                    value={formik.values.planningId}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    />
                                </Grid>

                                <Grid item xs={12}>
                                    <TextField
                                    label="AnatDetail"
                                    name="anatDetail"
                                    InputLabelProps={{ shrink: true}}
                                    value={formik.values.anatDetail}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    multiline
                                    rows={3}
                                    />
                                </Grid>

                                <Grid item xs={12}>
                                    <TextField
                                    label="General"
                                    name="general"
                                    InputLabelProps={{ shrink: true}}
                                    value={formik.values.general}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    multiline
                                    rows={3}
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                    label="PneumonitisId"
                                    name="pneumonitisId"
                                    InputLabelProps={{ shrink: true}}
                                    value={formik.values.pneumonitisId}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                    label="UpperGI ID"
                                    name="upperGIId"
                                    InputLabelProps={{ shrink: true}}
                                    value={formik.values.upperGIId}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                    label="Skin Reaction ID"
                                    name="skinReactionId"
                                    InputLabelProps={{ shrink: true}}
                                    value={formik.values.skinReactionId}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                    label="LowerGI ID"
                                    name="lowerGIId"
                                    InputLabelProps={{ shrink: true}}
                                    value={formik.values.lowerGIId}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                    label="Gu Id"
                                    name="guId"
                                    InputLabelProps={{ shrink: true}}
                                    value={formik.values.guId}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                    label="Hepatic Id"
                                    name="hepaticId"
                                    InputLabelProps={{ shrink: true}}
                                    value={formik.values.hepaticId}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                    label="Heme ID"
                                    name="hemeId"
                                    InputLabelProps={{ shrink: true}}
                                    value={formik.values.hemeId}
                                    onChange={formik.handleChange}
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

export default RTGIinfo