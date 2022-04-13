import React, { useState, useEffect } from 'react';
import { useFormik, Formik, Form, Field } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl, Checkbox } from '@material-ui/core';
import { TextField } from "@material-ui/core/";
import DatePicker from '../../components/Date/DatePicker';
import axios from "axios"; 
import Collapsible from 'react-collapsible';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
 
export default function Patientchallenges() {

    const userid = -2144486835;
    
    const [data, setData] = useState(null);
    const [attendedFamily, setAttendedFamily] = useState(null);
    const [attendedFamilyUpdate, setAttendedFamilyUpdate] = useState(null);
    const [lacksSocialSupport, setLacksSocialSupport] = useState(null);
    const [lacksSocialSupportUpdate, setLacksSocialSupportUpdate] = useState(null);
    const [languageBarrier, setLanguageBarrier] = useState(null);
    const [languageBarrierUpdate, setLanguageBarrierUpdate] = useState(null);
    const [financialChallenge, setFinancialChallenge] = useState(null);
    const [financialChallengeUpdate, setFinancialChallengeUpdate] = useState(null);
    const [psychosocialChallenge, setPsychosocialChallenge] = useState(null);
    const [psychosocialChallengeUpdate, setPsychosocialChallengeUpdate] = useState(null);
    const [etohweek, setEtohweek] = useState(null);
    const [etohweekUpdate, setEtohweekUpdate] = useState(null);


useEffect(() => {
    setAttendedFamilyUpdate(attendedFamily ? 1:0);
  }, [attendedFamily])
  
  useEffect(() => {
    setLacksSocialSupportUpdate(lacksSocialSupport ? 1:0);
  }, [lacksSocialSupport])
  
  useEffect(() => {
    setLanguageBarrierUpdate(languageBarrier ? 1:0);
  }, [languageBarrier])
  
  useEffect(() => {
    setFinancialChallengeUpdate(financialChallenge ? 1:0);
  }, [financialChallenge])
  
  useEffect(() => {
    setPsychosocialChallengeUpdate(psychosocialChallenge ? 1:0);
  }, [psychosocialChallenge])
  
  useEffect(() => {
    setEtohweekUpdate(etohweek ? 1:0);
  }, [etohweek])

  function handleAtt(e) { 
    setAttendedFamily(e.target.checked);
  }
  
  function handleLack(e) { 
    setLacksSocialSupport(e.target.checked);
  }

  function handleLang(e) { 
    setLanguageBarrier(e.target.checked);
  }

  function handleFin(e) { 
    setFinancialChallenge(e.target.checked);
  }

  function handlePsych(e) { 
    setPsychosocialChallenge(e.target.checked);
  }

  function handleEtoh(e) { 
    setEtohweek(e.target.checked);
  }

  let handleSubmit = async (e) => {
    console.log(e);
    e.preventDefault();
    try {
      let result = await fetch(
        `http://localhost:8080/api/pasthistory/update/`,
        {
          method: "post",
          mode: "cors",
          headers: {
            "Content-Type": "application/json"
          },
          body: `{
                  "id": "${userid}",
                  "attendedFamily": "${attendedFamilyUpdate}",
                  "lacksSocialSupport": "${lacksSocialSupportUpdate}",
                  "languageBarrier": "${languageBarrierUpdate}",
                  "financialChallenge": "${financialChallengeUpdate}",
                  "psychosocialChallenge": "${psychosocialChallengeUpdate}",
                  "etohweek": "${etohweekUpdate}"
                 }`
        }
      );
      console.log("Submited: " + result);
    } catch (e) {
      console.log(e);
    }
  } 

  function getData() {
    fetch(`http://localhost:8080/api/pasthistory/id=${userid}`).then((result) => {
      result.json().then((resp) => {
        setData(resp)
        console.log(resp)
        setAttendedFamily(resp.attendedFamily)
        setLacksSocialSupport(resp.lacksSocialSupport)
        setLanguageBarrier(resp.languageBarrier)
        setFinancialChallenge(resp.financialChallenge)
        setPsychosocialChallenge(resp.psychosocialChallenge)
        setEtohweek(resp.etohweek)
         
      })
       
    })
  }
  
  useEffect(() => {
    getData();
  }, [])


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
         
             
         <form onSubmit={handleSubmit}>
                    <Collapsible trigger="Patient's Challenges" triggerTagName='h3'  overflowWhenOpen="inherit">
                  <br></br>

                    <Grid container spacing={3} width={'70vw'}>

                             

                                <Grid item xs={6}>
                                    <label>
                                    <div className="symptons">
                                        Attended fmily
                                        <input type="checkbox" 
                                        name="attendedFamily"
                                        checked={attendedFamily} 
                                        onChange={handleAtt}/>
                                       </div> 
                                    </label>
                                </Grid>

                                <Grid item xs={6}>
                                    <label>
                                    <div className="symptons">
                                        Social support
                                        <input type="checkbox" 
                                        name="Lacks Social Support"
                                        checked={lacksSocialSupport} 
                                        onChange={handleLack}/>
                                        </div>
                                    </label>
                                </Grid>

                                <Grid item xs={6}>
                                    <label>
                                    <div className="symptons">
                                        Language Barrier
                                        <input type="checkbox" 
                                        name="language"
                                        checked={languageBarrier} 
                                        onChange={handleLang}/>
                                        </div>
                                    </label>
                                </Grid>

                                <Grid item xs={6}>
                                    <label>
                                    <div className="symptons">
                                        Financial challenge
                                        <input type="checkbox" 
                                        name="financial"
                                        checked={financialChallenge} 
                                        onChange={handleFin}/>
                                        </div>
                                    </label>
                                </Grid>

                                <Grid item xs={6}>
                                    <label>
                                    <div className="symptons">
                                        Psychosocial Challenges
                                        <input type="checkbox" 
                                        name="psychosocial"
                                        checked={psychosocialChallenge} 
                                        onChange={handlePsych}/>
                                        </div>
                                    </label>
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