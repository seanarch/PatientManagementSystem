import React from 'react';
import { Formik, Form } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid } from '@material-ui/core';
import DatePicker from '../../components/Date/DatePicker';
import TextField from '../../components/TextField/TextField';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Collapsible from 'react-collapsible';
import 'react-toastify/dist/ReactToastify.css';



const INITIAL_VALUES = {
  Death: {
    Date: "",
    Detail: "Details",
  }
};

function DeathForm() {

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
        <Formik initialValues={{ ...INITIAL_VALUES }} onSubmit={values => {
          console.log(values)
          //once submit, provide value for back end
        }}
        >
          <Form>

          <h3>Death information</h3>
            <Collapsible trigger="[+]"> 
             
           
              <br></br>
              <Grid container spacing={3} width={'70vw'}>

                <Grid item xs={12}>
                  <DatePicker
                    fullWidth
                    name="Death.Date"
                    label="Death Date"
                  />
                </Grid>

                <Grid item xs={12}>
                  <TextField
                    fullWidth
                    label="Death Detail"
                    name="Death.Detail"
                    multiline
                    rows={3}
                  />
                </Grid>

                <Grid item xs={12}>
                  <Button color='primary' type="submit" onClick={notify}>Save</Button>
                  <ToastContainer />
                </Grid>

              </Grid>
            </Collapsible>
          </Form>
        </Formik>
      </div>
    </Container>

  );

}

export default DeathForm;