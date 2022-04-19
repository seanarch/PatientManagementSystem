import React, {useState, useEffect} from 'react';
import { useFormik, Formik, Form } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid } from '@material-ui/core';
import DatePicker from '../../components/Date/DatePicker';
import { TextField } from "@material-ui/core/"; 
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Collapsible from 'react-collapsible';
import 'react-toastify/dist/ReactToastify.css';
import { useGlobalState } from '../../components/Globalstate';


 

function DeathForm() {

  const userid = parseInt(useGlobalState("userid"));
 
  const formik = useFormik({
    enableReinitialize: true,
    initialValues: {
        date: "",
        detail: "",

    }, 

    onSubmit: async (values) => {
      console.log(values);
      try {
      let result = await fetch(
          `http://localhost:8080/api/death/update/`,
          {
            method: "post",
            mode: "cors",
            headers: {
              "Content-Type": "application/json"
            },
            body: `{
                     "uliId": ${userid},
                     "date": "${values.date}",
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
            `http://localhost:8080/api/death/uli=${userid}`
          );

          if (response.ok) {
            let content = await response.json(); 
            console.log(content[0]);
            formik.setValues(content[0]);
          } else {
            let response = await fetch(
              `http://localhost:8080/api/death/uli=836686110`);
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
               
              <h3>{userid}</h3>
            
              <br></br>
              <Grid container spacing={3} width={'70vw'}>

              <Grid item xs={6}>
                <TextField
                  label="Death date"
                  name="date"
                  value={formik.values.date}
                  onChange={formik.handleChange}
                  fullWidth
                  />
              </Grid>

                <Grid item xs={12}>
                  <TextField
                    fullWidth
                    label="Death Detail"
                    name="detail"
                    value={formik.values.detail}
                    onChange={formik.handleChange}
                    multiline
                    rows={3}
                  />
                </Grid>

                <Grid item xs={12}>
                  <Button color='primary' type="submit" onClick={notify}>Save</Button>
                  <ToastContainer />
                </Grid>

              </Grid>
            
          </form>
         
      </div>
    </Container>

  );

}

export default DeathForm;