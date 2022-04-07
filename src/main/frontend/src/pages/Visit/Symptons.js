import React, {useEffect} from 'react';
import { useFormik, Formik, Form, Field } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl, Checkbox } from '@material-ui/core';
import { TextField } from '@material-ui/core'; 
import DatePicker from '../../components/Date/DatePicker';
import axios from "axios"; 
import Collapsible from 'react-collapsible';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { textAlign } from '@material-ui/system';

 
 

function Symptons() {

    const userid = -2147216991;

    const formik = useFormik({
        enableReinitialize: true,
        initialValues: {
            date: "",
            feversChills: 0,
            appetiteLoss: 0,
            difficultyChewing: 0,
            abdominalPain: 0,
            nauseaVomiting: 0,
            heartburn: 0,
            constipation: 0,
            hemetemesis: 0,
            melena: 0,
            rectalBleed: 0,
            nocturea: 0,
            hesitancy: 0,
            hematurea: 0,
            pneumaturea: 0,
            backBoneJointPain: 0,
            sob: 0,
            cough: 0,
            hemoptisis: 0,
            wheeze: 0,
            chestPain: 0,
            headaches: 0,
            visionChanges: 0,
            hearing: 0,
            speechChanges: 0,
            focalWeakness: 0,
            ed: 0,
            badls: 0,
            iadls: 0 
        },

        onSubmit: async (values) => {
            console.log(values);
            try {
            let result = await fetch(
                `http://localhost:8080/api/reviewofsymptoms/update/`,
                {
                  method: "post",
                  mode: "cors",
                  headers: {
                    "Content-Type": "application/json"
                  },
                  body: `{
                           "id": "${userid}",
                           "date": "${values.date}",
                           "feversChills": "${values.feversChills}",
                           "appetiteLoss": "${values.appetiteLoss}" ,
                           "difficultyChewing": "${values.difficultyChewing}" ,
                           "abdominalPain": "${values.abdominalPain}" ,
                           "nauseaVomiting": "${values.nauseaVomiting}" ,
                           "heartburn": "${values.heartburn}" ,
                           "constipation": "${values.constipation}" ,
                           "hemetemesis": "${values.hemetemesis}" ,
                           "melena": "${values.melena}" ,
                           "rectalBleed": "${values.rectalBleed}" ,
                           "nocturea": "${values.nocturea}" ,
                           "hesitancy": "${values.hesitancy}" ,
                           "hematurea": "${values.hematurea}" ,
                           "pneumaturea": "${values.pneumaturea}" ,
                           "backBoneJointPain": "${values.backBoneJointPain}" ,
                           "sob": "${values.sob}" ,
                           "cough": "${values.cough}" ,
                           "hemoptisis": "${values.hemoptisis}" ,
                           "wheeze": "${values.wheeze}" ,
                           "chestPain": "${values.chestPain}" ,
                           "headaches": "${values.headaches}" ,
                           "visionChanges": "${values.visionChanges}",
                           "hearing": "${values.hearing}" ,
                           "speechChanges": "${values.speechChanges}" ,
                           "focalWeakness": "${values.focalWeakness}" ,
                           "ed": "${values.ed}" ,
                           "badls": "${values.badls}" ,
                           "iadls": "${values.iadls}"    
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
                `http://localhost:8080/api/reviewofsymptoms/id=${userid}`
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

  return (   <Container maxWidth="md">
  <div className='container' style={{
      display: 'flex', justifyContent:
          'center', alignItems: 'center', marginTop: '50px', marginBottom: '25px'
  }}>
    
              <form onSubmit={formik.handleSubmit}>
                  <Collapsible trigger="Symptoms" triggerTagName='h3' overflowWhenOpen="inherit">
                      <br></br>
                  <Grid container spacing={3} width={'70vw'}>
                
                  <Grid item xs={12}>
                                <TextField
                                        fullWidth
                                        label="Date"
                                        name="date"
                                        value={formik.values.date}
                                        onChange={formik.handleChange}
                                         
                                    />
                                </Grid>

                                <Grid item xs={3}>

                                    <h5>FeversChills</h5>
                                    <input type="checkbox" 
                                    name="feversChills"
                                    checked={formik.values.feversChills} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={3}>

                                    <h5>AppetiteLoss</h5>
                                    <input type="checkbox" 
                                    name="appetiteLoss"
                                    checked={formik.values.appetiteLoss} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={3}>

                                    <h5>Chewing</h5>
                                    <input type="checkbox" 
                                    name="difficultyChewing"
                                    checked={formik.values.difficultyChewing} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={3}>

                                    <h5>AbdominalPain</h5>
                                    <input type="checkbox" 
                                    name="abdominalPain"
                                    checked={formik.values.abdominalPain} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={3}>

                                    <h5>Vomiting</h5>
                                    <input type="checkbox" 
                                    name="nauseaVomiting"
                                    checked={formik.values.nauseaVomiting} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={3}>

                                    <h5>Heartburn</h5>
                                    <input type="checkbox" 
                                    name="heartburn"
                                    checked={formik.values.heartburn} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={3}>

                                    <h5>Constipation</h5>
                                    <input type="checkbox" 
                                    name="constipation"
                                    checked={formik.values.constipation} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={3}>

                                    <h5>Hemetemesis</h5>
                                    <input type="checkbox" 
                                    name="hemetemesis"
                                    checked={formik.values.hemetemesis} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={3}>

                                    <h5>Melena</h5>
                                    <input type="checkbox" 
                                    name="melena"
                                    checked={formik.values.melena} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={3}>

                                    <h5>RectalBleed</h5>
                                    <input type="checkbox" 
                                    name="rectalBleed"
                                    checked={formik.values.rectalBleed} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={3}>

                                    <h5>Nocturea</h5>
                                    <input type="checkbox" 
                                    name="nocturea"
                                    checked={formik.values.nocturea} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={3}>

                                    <h5>Hesitancy</h5>
                                    <input type="checkbox" 
                                    name="nocturea"
                                    checked={formik.values.hesitancy} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={3}>

                                    <h5>Hematurea</h5>
                                    <input type="checkbox" 
                                    name="hematurea"
                                    checked={formik.values.hematurea} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={3}>

                                    <h5>Pneumaturea</h5>
                                    <input type="checkbox" 
                                    name="pneumaturea"
                                    checked={formik.values.pneumaturea} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={3}>

                                    <h5>BackBonePain</h5>
                                    <input type="checkbox" 
                                    name="backBoneJointPain"
                                    checked={formik.values.backBoneJointPain} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={3}>

                                    <h5>Sob</h5>
                                    <input type="checkbox" 
                                    name="sob"
                                    checked={formik.values.sob} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={3}>

                                    <h5>Cough</h5>
                                    <input type="checkbox" 
                                    name="cough"
                                    checked={formik.values.cough} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={3}>

                                    <h5>Hemoptisis</h5>
                                    <input type="checkbox" 
                                    name="hemoptisis"
                                    checked={formik.values.hemoptisis} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={3}>

                                    <h5>Wheeze</h5>
                                    <input type="checkbox" 
                                    name="wheeze"
                                    checked={formik.values.wheeze} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={3}>

                                    <h5>ChestPain</h5>
                                    <input type="checkbox" 
                                    name="chestPain"
                                    checked={formik.values.chestPain} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={3}>

                                    <h5>Headaches</h5>
                                    <input type="checkbox" 
                                    name="headaches"
                                    checked={formik.values.headaches} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={3}>

                                    <h5>VisionChanges</h5>
                                    <input type="checkbox" 
                                    name="visionChanges"
                                    checked={formik.values.visionChanges} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={3}>

                                    <h5>Hearing</h5>
                                    <input type="checkbox" 
                                    name="hearing"
                                    checked={formik.values.hearing} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={3}>

                                    <h5>SpeechChanges</h5>
                                    <input type="checkbox" 
                                    name="speechChanges"
                                    checked={formik.values.speechChanges} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={3}>

                                    <h5>FocalWeakness</h5>
                                    <input type="checkbox" 
                                    name="focalWeakness"
                                    checked={formik.values.focalWeakness} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={3}>

                                    <h5>Ed</h5>
                                    <input type="checkbox" 
                                    name="ed"
                                    checked={formik.values.ed} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={3}>

                                    <h5>Badls</h5>
                                    <input type="checkbox" 
                                    name="badls"
                                    checked={formik.values.badls} 
                                    onChange={formik.handleChange}/>

                                    </Grid>

                                <Grid item xs={3}>

                                    <h5>Iadls</h5>
                                    <input type="checkbox" 
                                    name="iadls"
                                    checked={formik.values.iadls} 
                                    onChange={formik.handleChange}/>

                                    </Grid>
                

                          <Grid item xs={6}>
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

export default Symptons