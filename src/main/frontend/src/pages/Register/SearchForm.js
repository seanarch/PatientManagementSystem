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
import Searchfirstname from '../../components/Searchfirstname';
import { setGlobalState, useGlobalState } from '../../components/Globalstate';

 


const INITIAL_VALUES = {
  Search: {
    PatientId: "",
    PatientName: ""
  }
};

function SearchForm() {

  var selectedUserId = 0;
  const [patientDetails, setPatient] = useState([]);
  const [patientDetailsName, setPatientName] = useState([]);
  const [filteredData, setFilteredData] = useState([]); 
  const [filteredDataName, setFilteredDataName] = useState([]);
  const [wordEnteredId, setWordEnteredId] = useState("");
  const [wordEnteredName, setWordEnteredName] = useState("");

  const notify = () => {

    toast.success('Record selected!', {
      position: toast.POSITION.TOP_RIGHT,
      autoClose: 2000
    })
  }

 

  const SearchFilter = async () => {
    const patientResponse = await fetch(`http://localhost:8080/api/patient/all`);
    const patientResponseData = await patientResponse.json();
    setPatient(patientResponseData);
    console.log(patientResponseData);
  }

  useEffect(() => {
    SearchFilter();
  }, [])

  const SearchFilterName = async () => {
    const patientResponse = await fetch(`http://localhost:8080/api/patient/all`);
    const patientResponseData = await patientResponse.json();
    setPatientName(patientResponseData);
    console.log(patientResponseData);
  }

  useEffect(() => {
    SearchFilterName();
  }, [])

  const handleFilterId = (event) => {
    const searchWordId = event.target.value;
    setWordEnteredId(searchWordId);
    const newFilterId = patientDetails.filter(value => {
 
      if(value.id) {

        return value.id.toString().startsWith(searchWordId);
      }
      
    });

    if (searchWordId === "") {
      setFilteredData([]);
    } else {
      setFilteredData(newFilterId);
    }
  };

  const handleFilterName = (event) => {
    const searchWordName = event.target.value;
    setWordEnteredName(searchWordName);
    const newFilterName = patientDetailsName.filter(value => {
 
      if(value.firstname) {

        return value.firstname.toString().startsWith(searchWordName);
      }
      
    });

    if (searchWordName === "") {
      setFilteredDataName([]);
    } else {
      setFilteredDataName(newFilterName);
    }
  };

 

  

  return (
    <>
      <Container maxWidth="md">
        <div className='container' style={{
          display: 'flex', justifyContent:
            'center', alignItems: 'center', marginTop: '50px'
        }}>
          <Formik initialValues={{ ...INITIAL_VALUES }} onSubmit={values => {
            // console.log(values.Search.PatientName);
            SearchFilter(values.Search.PatientId)

            //once submit, provide value for back end
          }}
          >
            <Form> 
              <Collapsible trigger="Search Existing Patient" triggerTagName='h3'  overflowWhenOpen="inherit">
                <br></br>
                <Grid container spacing={3} width={'70vw'}>
                  <Grid item xs={6}>
                    <TextField
                      fullWidth
                      label="Search By Patient ULI"
                      name="Search.PatientId"
                      onChange={handleFilterId}
                      value={wordEnteredId}
                    />
                  </Grid>
                  <Grid item xs={6}>
                    <TextField
                      fullWidth
                      label="Search By Patient First Name"
                      name="Search.PatientName"
                      onChange={handleFilterName}
                      value={wordEnteredName}
                    />
                  </Grid>


                </Grid>
              </Collapsible>
            </Form>
          </Formik>
        </div>
      </Container>
      <div className="searchId">
        {filteredData.length != 0 && (
          <div className="dataIdResult">                

            {filteredData.slice(0, 15).map((value, key) => {
              return (
                 
                 
                <div key={value.id}>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         
                
                ID:{value.id}&nbsp;&nbsp;&nbsp;&nbsp;
                {value.firstname}&nbsp;&nbsp;&nbsp;&nbsp;
                {value.lastname}&nbsp;&nbsp;&nbsp;&nbsp;
                Birthday:{value.birthday}
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <Button color='primary' type="button" onClick={()=> {setGlobalState("userid", value.id); console.log(value.id)}} >Select</Button>
                <ToastContainer />
                <br></br>
                  
                </div>
                 
              );
            })}
          </div>
        )}
      </div>
      <div className="searchName">
        {filteredDataName.length != 0 && (
          <div className="dataNameResult">                

            {filteredDataName.slice(0, 15).map((value, key) => {
              return (
                 
                 
                <div key={value.id}>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         
                
                ID:{value.id}&nbsp;&nbsp;&nbsp;&nbsp;
                {value.firstname}&nbsp;&nbsp;&nbsp;&nbsp;
                {value.lastname}&nbsp;&nbsp;&nbsp;&nbsp;
                Birthday:{value.birthday}
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <Button color='primary' type="button" onClick={()=> {setGlobalState("userid", value.id); console.log(value.id)}} >Select</Button>
                <br></br>
                  
                </div>
                 
              );
            })}
          </div>
        )}
      </div>
    </>

  );

}

export default SearchForm;