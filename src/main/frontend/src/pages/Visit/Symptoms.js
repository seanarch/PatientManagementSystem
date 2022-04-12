import React, {useState, useEffect} from 'react';
import { useFormik, Formik, Form, Field } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl } from '@material-ui/core';
import { TextField } from '@material-ui/core'; 
import DatePicker from '../../components/Date/DatePicker';
import axios from "axios"; 
import Collapsible from 'react-collapsible';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
  
 

export default function Symptoms() { 

const userid = -2147216991;
 
const [data, setData] = useState(null);
const [date, setDate] = useState(null);
const [dateUpdate, setDateUpdate] = useState(null);
const [feversChills, setFeversChills] = useState(null);
const [feversChillsUpdate, setfeversChillsUpdate] = useState(null) ;
const [appetiteLoss, setAppetiteLoss] = useState(null);
const [appetiteLossUpdate, setAppetiteLossUpdate] = useState(null);
const [difficultyChewing, setDifficultyChewing] = useState(null);
const [difficultyChewingUpdate, setDifficultyChewingUpdate] = useState(null);
const [abdominalPain, setAbdominalPain] = useState(null);
const [abdominalPainUpdate, setAbdominalPainUpdate] = useState(null);
const [nauseaVomiting, setNauseaVomiting] = useState(null);
const [nauseaVomitingUpdate, setNauseaVomitingUpdate] = useState(null);
const [heartburn, setHeartburn] = useState(null);
const [heartburnUpdate, setHeartburnUpdate] = useState(null);
const [constipation, setConstipation] = useState(null);
const [constipationUpdate, setConstipationUpdate] = useState(null);
const [hemetemesis, setHemetemesis] = useState(null);
const [hemetemesisUpdate, setHemetemesisUpdate] = useState(null);
const [melena, setMelena] = useState(null);
const [melenaUpdate, setMelenaUpdate] = useState(null);
const [rectalBleed, setRectalBleed] = useState(null);
const [rectalBleedUpdate, setRectalBleedUpdate] = useState(null);
const [nocturea, setNocturea] = useState(null);
const [noctureaUpdate, setNoctureaUpdate] = useState(null);
const [hesitancy, setHesitancy] = useState(null);
const [hesitancyUpdate, setHesitancyUpdate] = useState(null);
const [hematurea, setHematurea] = useState(null);
const [hematureaUpdate, setHematureaUpdate] = useState(null);
const [pneumaturea, setPneumaturea] = useState(null);
const [pneumatureaUpdate, setPneumatureaUpdate] = useState(null);
const [backBoneJointPain, setBackBoneJointPain] = useState(null);
const [backBoneJointPainUpdate, setBackBoneJointPainUpdate] = useState(null);
const [sob, setSob] = useState(null);
const [sobUpdate, setSobUpdate] = useState(null);
const [cough, setCough] = useState(null);
const [coughUpdate, setCoughUpdate] = useState(null);
const [hemoptisis, setHemoptisis] = useState(null);
const [hemoptisisUpdate, setHemoptisisUpdate] = useState(null);
const [wheeze, setWheeze] = useState(null);
const [wheezeUpdate, setWheezeUpdate] = useState(null);
const [chestPain, setChestPain] = useState(null);
const [chestPainUpdate, setChestPainUpdate] = useState(null);
const [headaches, setHeadaches] = useState(null);
const [headachesUpdate, setHeadachesUpdate] = useState(null);
const [visionChanges, setVisionChanges] = useState(null);
const [visionChangesUpate, setVisionChangesUpate] = useState(null);
const [hearing, setHearing] = useState(null);
const [hearingUpdate, setHearingUpdate] = useState(null);
const [speechChanges, setSpeechChanges] = useState(null);
const [speechChangesUpdate, setSpeechChangesUpdate] = useState(null);
const [focalWeakness, setFocalWeakness] = useState(null);
const [focalWeaknessUpdate, setFocalWeaknessUpdate] = useState(null);
const [ed, setEd] = useState(null);
const [edUpdate, setEdUpdate] = useState(null);
const [badls, setBadls] = useState(null);
const [badlsUpdate, setBadlsUpdate] = useState(null);
const [iadls, setIadls] = useState(null);
const [iadlsUpdate, setIadlsUpdate] = useState(null);
 
 
 
useEffect(() => {
  setDateUpdate(date);
}, [date])
 
useEffect(() => {
  setfeversChillsUpdate(feversChills ? 1:0);
}, [feversChills])

useEffect(() => {
  setAppetiteLossUpdate(appetiteLoss ? 1:0);
}, [appetiteLoss])

useEffect(() => {
  setDifficultyChewingUpdate(difficultyChewing ? 1:0);
}, [difficultyChewing])

useEffect(() => {
  setAbdominalPainUpdate(abdominalPain ? 1:0);
}, [abdominalPain])

useEffect(() => {
  setNauseaVomitingUpdate(nauseaVomiting ? 1:0);
}, [nauseaVomiting])

useEffect(() => {
  setHeartburnUpdate(heartburn ? 1:0);
}, [heartburn])

useEffect(() => {
  setConstipationUpdate(constipation ? 1:0);
}, [constipation])

useEffect(() => {
  setHemetemesisUpdate(hemetemesis ? 1:0);
}, [hemetemesis])

useEffect(() => {
  setMelenaUpdate(melena ? 1:0);
}, [melena])

useEffect(() => {
  setRectalBleedUpdate(rectalBleed ? 1:0);
}, [rectalBleed])

useEffect(() => {
  setNoctureaUpdate(nocturea ? 1:0);
}, [nocturea])

useEffect(() => {
  setHesitancyUpdate(hesitancy ? 1:0);
}, [hesitancy])

useEffect(() => {
  setHematureaUpdate(hematurea ? 1:0);
}, [hematurea])

useEffect(() => {
  setPneumatureaUpdate(pneumaturea ? 1:0);
}, [pneumaturea])

useEffect(() => {
  setBackBoneJointPainUpdate(backBoneJointPain ? 1:0);
}, [backBoneJointPain])

useEffect(() => {
  setSobUpdate(sob ? 1:0);
}, [sob])

useEffect(() => {
  setCoughUpdate(cough ? 1:0);
}, [cough])

useEffect(() => {
  setHemoptisisUpdate(hemoptisis ? 1:0);
}, [hemoptisis])

useEffect(() => {
  setWheezeUpdate(wheeze ? 1:0);
}, [wheeze])

useEffect(() => {
  setChestPainUpdate(chestPain ? 1:0);
}, [chestPain])

useEffect(() => {
  setHeadachesUpdate(headaches ? 1:0);
}, [headaches])

useEffect(() => {
  setVisionChangesUpate(visionChanges ? 1:0);
}, [visionChanges])

useEffect(() => {
  setHearingUpdate(hearing ? 1:0);
}, [hearing])

useEffect(() => {
  setSpeechChangesUpdate(speechChanges ? 1:0);
}, [speechChanges])

useEffect(() => {
  setFocalWeaknessUpdate(focalWeakness ? 1:0);
}, [focalWeakness])

useEffect(() => {
  setEdUpdate(ed ? 1:0);
}, [ed])

useEffect(() => {
  setBadlsUpdate(badls ? 1:0);
}, [badls])

useEffect(() => {
  setIadlsUpdate(iadls ? 1:0);
}, [iadls])



function handleDate(e) { 
  setDate(e.target.value);
}

function handleFev(e) { 
  setFeversChills(e.target.checked);
}

function handleAppt(e) { 
  setAppetiteLoss(e.target.checked);
}

function handleDiff(e) { 
  setDifficultyChewing(e.target.checked);
}

function handleAbdo(e) { 
  setAbdominalPain(e.target.checked);
}

function handleNaus(e) { 
  setNauseaVomiting(e.target.checked);
}

function handleHeart(e) { 
  setHeartburn(e.target.checked);
}

function handleCons(e) { 
  setConstipation(e.target.checked);
}

function handleHeme(e) { 
  setHemetemesis(e.target.checked);
}

function handleMele(e) { 
  setMelena(e.target.checked);
}

function handleRect(e) { 
  setRectalBleed(e.target.checked);
}

function handleNoct(e) { 
  setNocturea(e.target.checked);
}

function handleHesi(e) { 
  setHesitancy(e.target.checked);
}

function handleHema(e) { 
  setHematurea(e.target.checked);
}

function handlePneu(e) { 
  setPneumaturea(e.target.checked);
}

function handleBack(e) { 
  setBackBoneJointPain(e.target.checked);
}

function handleSob(e) { 
  setSob(e.target.checked);
}

function handleCough(e) { 
  setCough(e.target.checked);
}

function handleHemo(e) { 
  setHemoptisis(e.target.checked);
}

function handleWhee(e) { 
  setWheeze(e.target.checked);
}

function handleChes(e) { 
  setChestPain(e.target.checked);
}

function handleHead(e) { 
  setHeadaches(e.target.checked);
}

function handleVisi(e) { 
  setVisionChanges(e.target.checked);
}

function handleSpee(e) { 
  setSpeechChanges(e.target.checked);
}

function handleFoca(e) { 
  setFocalWeakness(e.target.checked);
}

function handleHear(e) { 
  setHearing(e.target.checked);
}

function handleEd(e) { 
  setEd(e.target.checked);
}

function handleBadl(e) { 
  setBadls(e.target.checked);
}

function handleIadl(e) { 
  setIadls(e.target.checked);
}

let handleSubmit = async (e) => {
  console.log(e);
  e.preventDefault();
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
                 "id" : "${userid}", 
                 "date": "${dateUpdate}",
                 "feversChills": "${feversChillsUpdate}",
                 "appetiteLoss": "${appetiteLossUpdate}",
                 "difficultyChewing": "${difficultyChewingUpdate}" ,
                 "abdominalPain": "${abdominalPainUpdate}" ,
                 "nauseaVomiting": "${nauseaVomitingUpdate}" ,
                 "heartburn": "${heartburnUpdate}" ,
                 "constipation": "${constipationUpdate}" ,
                 "hemetemesis": "${hemetemesisUpdate}" ,
                 "melena": "${melenaUpdate}" ,
                 "rectalBleed": "${rectalBleedUpdate}" ,
                 "nocturea": "${noctureaUpdate}" ,
                 "hesitancy": "${hesitancyUpdate}" ,
                 "hematurea": "${hematureaUpdate}" ,
                 "pneumaturea": "${pneumatureaUpdate}" ,
                 "backBoneJointPain": "${backBoneJointPainUpdate}" ,
                 "sob": "${sobUpdate}" ,
                 "cough": "${coughUpdate}" ,
                 "hemoptisis": "${hemoptisisUpdate}" ,
                 "wheeze": "${wheezeUpdate}" ,
                 "chestPain": "${chestPainUpdate}" ,
                 "headaches": "${headachesUpdate}" ,
                 "visionChanges": "${visionChangesUpate}",
                 "hearing": "${hearingUpdate}" ,
                 "speechChanges": "${speechChangesUpdate}" ,
                 "focalWeakness": "${focalWeaknessUpdate}" ,
                 "ed": "${edUpdate}" ,
                 "badls": "${badlsUpdate}" ,
                 "iadls": "${iadlsUpdate}" 

               }`
      }
    );
    console.log("Submited: " + result);
  } catch (e) {
    console.log(e);
  }
} 

 

function getData() {
  fetch(`http://localhost:8080/api/reviewofsymptoms/id=${userid}`).then((result) => {
    result.json().then((resp) => {
      setData(resp) 
      setDate(resp.date)
      setFeversChills(resp.feversChills)
      setAppetiteLoss(resp.appetiteLoss)
      setDifficultyChewing(resp.difficultyChewing)
      setAbdominalPain(resp.abdominalPain)
      setNauseaVomiting(resp.nauseaVomiting)
      setHeartburn(resp.heartburn)
      setConstipation(resp.constipation)
      setHemetemesis(resp.hemetemesis)
      setMelena(resp.melena)
      setRectalBleed(resp.rectalBleed)
      setNocturea(resp.nocturea)
      setHesitancy(resp.hesitancy)
      setHematurea(resp.hematurea)
      setPneumaturea(resp.pneumaturea)
      setBackBoneJointPain(resp.backBoneJointPain)
      setSob(resp.sob)
      setCough(resp.cough)
      setHemoptisis(resp.hemoptisis)
      setWheeze(resp.wheeze)
      setChestPain(resp.chestPain)
      setHeadaches(resp.headaches)
      setVisionChanges(resp.visionChanges)
      setHearing(resp.hearing)
      setSpeechChanges(resp.speechChanges)
      setFocalWeakness(resp.focalWeakness)
      setEd(resp.ed)
      setBadls(resp.badls)
      setIadls(resp.iadls)
       
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
          'center', alignItems: 'center', marginTop: '50px', marginBottom: '25px'
  }}>
    <form onSubmit={handleSubmit}>

    <Collapsible trigger="Symptoms" triggerTagName='h3' overflowWhenOpen="inherit">
                      <br></br>
                  <Grid container spacing={3} width={'70vw'}>
                
                  <Grid item xs={12}>
                    <TextField
                      fullWidth
                      label="Date" 
                      name="date"
                      value={date}
                      onChange={handleDate} />
                  </Grid>

                  <Grid item xs={3}>
                    <label>
                      <div className="symptons">Fever
                    <input type="checkbox" 
                    name="fever" 
                    checked={feversChills} 
                    onChange={handleFev}/> 
                    </div>
                    </label>
                  </Grid>
                  
                  <Grid item xs={3}>
                    <label>
                    <div className="symptons">
                      Appetite
                    <input type="checkbox" 
                    name="appt" 
                    checked={appetiteLoss} 
                    onChange={handleAppt}/> 
                    </div>
                    </label>
                  </Grid>

                  <Grid item xs={3}>
                    <label>
                    <div className="symptons">
                      Chewing
                    <input type="checkbox" 
                    name="chew" 
                    checked={difficultyChewing} 
                    onChange={handleDiff}/>
                    </div> 
                    </label>
                  </Grid>

                  <Grid item xs={3}>
                    <label>
                    <div className="symptons">
                      Abdom
                    <input type="checkbox" 
                    name="abdom" 
                    checked={abdominalPain} 
                    onChange={handleAbdo}/> 
                    </div>
                    </label>
                  </Grid>

                  <Grid item xs={3}>
                    <label>
                    <div className="symptons">
                      NauseeVomit
                    <input type="checkbox" 
                    name="nause" 
                    checked={nauseaVomiting} 
                    onChange={handleNaus}/> 
                    </div>
                    </label>
                  </Grid>

                  <Grid item xs={3}>
                    <label>
                    <div className="symptons">
                      Heartburn
                    <input type="checkbox" 
                    name="heartburn" 
                    checked={heartburn} 
                    onChange={handleHeart}/> 
                     </div>
                    </label>
                  </Grid>

                  <Grid item xs={3}>
                    <label>
                    <div className="symptons">
                      Constipation
                    <input type="checkbox" 
                    name="Constipation" 
                    checked={constipation} 
                    onChange={handleCons}/> 
                    </div>
                    </label>
                  </Grid>

                  <Grid item xs={3}>
                    <label>
                    <div className="symptons">
                      Hemetemesis
                    <input type="checkbox" 
                    name="heme" 
                    checked={hemetemesis} 
                    onChange={handleHeme}/>
                    </div>
                    </label>
                  </Grid>

                  <Grid item xs={3}>
                    <label>
                    <div className="symptons">
                      Melena
                    <input type="checkbox" 
                    name="melena" 
                    checked={melena} 
                    onChange={handleMele}/> 
                    </div>
                    </label>
                  </Grid>

                  <Grid item xs={3}>
                    <label>
                    <div className="symptons">
                      RectalBleed
                    <input type="checkbox" 
                    name="rectal" 
                    checked={rectalBleed} 
                    onChange={handleRect}/> 
                    </div>
                    </label>
                  </Grid>

                  <Grid item xs={3}>
                    <label>
                    <div className="symptons">
                      Nocturea
                    <input type="checkbox" 
                    name="nocturea" 
                    checked={nocturea} 
                    onChange={handleNoct}/> 
                    </div>
                    </label>
                  </Grid>

                  <Grid item xs={3}>
                    <label>
                      Hesitancy
                    <input type="checkbox" 
                    name="hesitancy" 
                    checked={hesitancy} 
                    onChange={handleHesi}/> 
                    </label>
                  </Grid>

                  <Grid item xs={3}>
                    <label>
                    <div className="symptons">
                      Hematurea
                    <input type="checkbox" 
                    name="hematurea" 
                    checked={hematurea} 
                    onChange={handleHema}/> 
                    </div>
                    </label>
                  </Grid>

                  <Grid item xs={3}>
                    <label>
                    <div className="symptons">
                      Pneumaturea
                    <input type="checkbox" 
                    name="pneumaturea" 
                    checked={pneumaturea} 
                    onChange={handlePneu}/> 
                    </div>
                    </label>
                  </Grid>

                  <Grid item xs={3}>
                    <label>
                    <div className="symptons">
                      BackBone
                    <input type="checkbox" 
                    name="backbone" 
                    checked={backBoneJointPain} 
                    onChange={handleBack}/> 
                    </div>
                    </label>
                  </Grid>

                  <Grid item xs={3}>
                    <label>
                    <div className="symptons">
                      SOB
                    <input type="checkbox" 
                    name="sob" 
                    checked={sob} 
                    onChange={handleSob}/> 
                    </div>
                    </label>
                  </Grid>

                  <Grid item xs={3}>
                    <label>
                    <div className="symptons">
                      Cough
                    <input type="checkbox" 
                    name="cough" 
                    checked={cough} 
                    onChange={handleCough}/>
                    </div> 
                    </label>
                  </Grid>

                  <Grid item xs={3}>
                    <label>
                    <div className="symptons">
                      Hemoptisis
                    <input type="checkbox" 
                    name="hemo" 
                    checked={hemoptisis} 
                    onChange={handleHemo}/> 
                    </div>
                    </label>
                  </Grid>

                  <Grid item xs={3}>
                    <label>
                    <div className="symptons">
                      Wheeze
                    <input type="checkbox" 
                    name="whee" 
                    checked={wheeze} 
                    onChange={handleWhee}/> 
                    </div>
                    </label>
                  </Grid>

                  <Grid item xs={3}>
                    <label>
                    <div className="symptons">
                      ChestPain
                    <input type="checkbox" 
                    name="chest" 
                    checked={chestPain} 
                    onChange={handleChes}/>
                    </div> 
                    </label>
                  </Grid>

                  <Grid item xs={3}>
                    <label>
                    <div className="symptons">
                      Headaches
                    <input type="checkbox" 
                    name="head" 
                    checked={headaches} 
                    onChange={handleHead}/>
                    </div> 
                    </label>
                  </Grid>

                  <Grid item xs={3}>
                    <label>
                    <div className="symptons">
                      Vision
                    <input type="checkbox" 
                    name="vision" 
                    checked={visionChanges} 
                    onChange={handleVisi}/> 
                    </div>
                    </label>
                  </Grid>

                  <Grid item xs={3}>
                    <label>
                    <div className="symptons">
                      Hearing
                    <input type="checkbox" 
                    name="hear" 
                    checked={hearing} 
                    onChange={handleHear}/> 
                    </div>
                    </label>
                  </Grid>

                  <Grid item xs={3}>
                    <label>
                    <div className="symptons">
                      Speech
                    <input type="checkbox" 
                    name="speech" 
                    checked={speechChanges} 
                    onChange={handleSpee}/> 
                    </div>
                    </label>
                  </Grid>

                  <Grid item xs={3}>
                    <label>
                    <div className="symptons">
                      Focal
                    <input type="checkbox" 
                    name="focal" 
                    checked={focalWeakness} 
                    onChange={handleFoca}/> 
                    </div>
                    </label>
                  </Grid>

                  <Grid item xs={3}>
                    <label>
                    <div className="symptons">
                      ED
                    <input type="checkbox" 
                    name="ed" 
                    checked={ed} 
                    onChange={handleEd}/>
                    </div> 
                    </label>
                  </Grid>

                  <Grid item xs={3}>
                    <label>
                    <div className="symptons">
                      Badls
                    <input type="checkbox" 
                    name="badls" 
                    checked={badls} 
                    onChange={handleBadl}/>
                    </div> 
                    </label>
                  </Grid>

                  <Grid item xs={3}>
                    <label>
                    <div className="symptons">
                      Iadls
                    <input type="checkbox" 
                    name="iadls" 
                    checked={iadls} 
                    onChange={handleIadl}/> 
                    </div>
                    </label>
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

