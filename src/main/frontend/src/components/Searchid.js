import React, { useState, useEffect } from 'react';
import { Formik, Form } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid } from '@material-ui/core'; 
import { TextField } from '@material-ui/core';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Collapsible from 'react-collapsible';
import 'react-toastify/dist/ReactToastify.css';



const INITIAL_VALUES = {
  Search: {
    PatientName: "",
  }
};

function Searchid() {

  const [patientDetails, setPatient] = useState([]);
  const [filteredData, setFilteredData] = useState([]);
  const [wordEntered, setWordEntered] = useState("");

  // const notify = () => {

  //   toast.success('Successfully saved!', {
  //     position: toast.POSITION.TOP_RIGHT,
  //     autoClose: 2000
  //   })
  // }

  const SearchFilter = async () => {
    const patientResponse = await fetch(`http://localhost:8080/api/patient/all`);
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
    const newFilter = patientDetails.filter(value => {
 
      if(value.id) {

        return value.id.toString().startsWith(searchWord);
      }
      
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
              <Collapsible trigger="Search Existing Patient" triggerTagName='h3'  overflowWhenOpen="inherit">
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
                 
                 
                <div key={value.id}>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                {/* <table>
                  <tr>
                    <th>ID</th>
                    <th>Firstname</th>
                    <th>Lastname</th>
                    <th>Birthday</th>
                  </tr>
                  <tr>
                    <td>{value.id}</td>
                    <td>{value.firstname}</td>
                    <td>{value.lastname}</td>
                    <td>{value.birthday}</td>
                  </tr>
                </table> */}
                
                ID:{value.id}&nbsp;&nbsp;&nbsp;&nbsp;
                {value.firstname}&nbsp;&nbsp;&nbsp;&nbsp;
                {value.lastname}&nbsp;&nbsp;&nbsp;&nbsp;
                Birthday:{value.birthday}
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

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

export default Searchid;