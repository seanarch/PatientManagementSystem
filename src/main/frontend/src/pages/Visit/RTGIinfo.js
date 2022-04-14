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

 
function RTGIinfo() {

    const userid = -2144449451;

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
                           "id": "${userid}",
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
                                    value={formik.values.dateRTStart}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                    label="DateRTEnd"
                                    name="dateRTEnd"
                                    value={formik.values.dateRTEnd}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                    label="TypeRTId"
                                    name="typeRTId"
                                    value={formik.values.typeRTId}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                    label="LocationId"
                                    name="locationId"
                                    value={formik.values.locationId}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                    label="RT dose"
                                    name="rtdose"
                                    value={formik.values.rtdose}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                    label="Fraction"
                                    name="fraction"
                                    value={formik.values.fraction}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                    label="PlanningId"
                                    name="planningId"
                                    value={formik.values.planningId}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    />
                                </Grid>

                                <Grid item xs={12}>
                                    <TextField
                                    label="AnatDetail"
                                    name="anatDetail"
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
                                    value={formik.values.pneumonitisId}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                    label="UpperGI ID"
                                    name="upperGIId"
                                    value={formik.values.upperGIId}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                    label="Skin Reaction ID"
                                    name="skinReactionId"
                                    value={formik.values.skinReactionId}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                    label="LowerGI ID"
                                    name="lowerGIId"
                                    value={formik.values.lowerGIId}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                    label="Gu Id"
                                    name="guId"
                                    value={formik.values.guId}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                    label="Hepatic Id"
                                    name="hepaticId"
                                    value={formik.values.hepaticId}
                                    onChange={formik.handleChange}
                                    fullWidth
                                    />
                                </Grid>

                                <Grid item xs={6}>
                                    <TextField
                                    label="Heme ID"
                                    name="hemeId"
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