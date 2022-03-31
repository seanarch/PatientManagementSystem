import React, { useState, useEffect } from 'react';
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
  Search: {
    PatientName: "",
  }
};

function SearchForm() {

  const [patientDetails, setPatient] = useState([]);
  const [filteredData, setFilteredData] = useState([]);
  const [wordEntered, setWordEntered] = useState("");

  const notify = () => {

    toast.success('Successfully saved!', {
      position: toast.POSITION.TOP_RIGHT,
      autoClose: 2000
    })
  }

  const SearchFilter = async () => {
    const patientResponse = await fetch(`http://localhost:8080/api/patient/`);
    const patientResponseData = await patientResponse.json();
    setPatient(patientResponseData);
    console.log(patientResponseData);
  }

  useEffect(() => {
    SearchFilter();
  }, [])

  const handleFilter = (event) => {
    const searchWord = event.target.value;
    setWordEntered(searchWord);
    const newFilter = patientDetails.filter((value) => {
      return value.title.toLowerCase().includes(searchWord.toLowerCase());
    });

    if (searchWord === "") {
      setFilteredData([]);
    } else {
      setFilteredData(newFilter);
    }
  };

  // const clearInput = () => {
  //   setFilteredData([]);
  //   setWordEntered("");
  // };

  return (
    <>
      <Container maxWidth="md">
        <div className='container' style={{
          display: 'flex', justifyContent:
            'center', alignItems: 'center', marginTop: '50px'
        }}>
          <Formik initialValues={{ ...INITIAL_VALUES }} onSubmit={values => {
            // console.log(values.Search.PatientName);
            SearchFilter(values.Search.PatientName)

            //once submit, provide value for back end
          }}
          >
            <Form>
              <h3>Search Existing Patient</h3>
              <Collapsible trigger="[+]">
                <br></br>
                <Grid container spacing={3} width={'70vw'}>
                  <Grid item xs={12}>
                    <TextField
                      fullWidth
                      label="Search By Patient First Name, Last Name or ULI"
                      name="Search.PatientName"
                      onChange={handleFilter}
                      value={wordEntered}
                    />
                  </Grid>


                  {/* <Grid item xs={12}>
                  <Button color='primary' type="submit" onClick={notify}>Search</Button>
                  <ToastContainer />
                </Grid> */}

                </Grid>
              </Collapsible>
            </Form>
          </Formik>
        </div>
      </Container>
      <div className="search">
        {filteredData.length != 0 && (
          <div className="dataResult">
            {filteredData.slice(0, 15).map((value, key) => {
              return (
                <a className="dataItem" href={value.link} target="_blank">
                  <p>{value.title} </p>
                </a>
              );
            })}
          </div>
        )}
      </div>
    </>

  );

}

export default SearchForm;