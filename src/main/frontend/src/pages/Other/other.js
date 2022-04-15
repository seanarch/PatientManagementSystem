import React, { useEffect, useState } from 'react';
import { FormControl, InputLabel, Grid, Select, MenuItem, Box, Container, Dialog, DialogTitle } from '@material-ui/core';
import TextField from '@mui/material/TextField';
import { Button } from 'reactstrap';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import SearchBar from '../../components/SearchBar';
import { GoTrashcan, GoPencil, GoDiffAdded } from "react-icons/go"
import AddDialog from '../../components/Dialog/AddRow';
import DeleteDialog from '../../components/Dialog/DeleteRow';
import EditDialog from '../../components/Dialog/EditRow';
const Other = () => {

    const notify = () => {
        toast.success('Successfully saved!', {
            position: toast.POSITION.TOP_RIGHT,
            autoClose: 2000
        })
    }

    //array attributes to hold data from existing tables
    const [centralnervoussystems, setCentralnervoussystems] = useState([{}]);
    const [lungs, setLungs] = useState([]);
    const [hns, setHns] = useState([]);
    const [orals, setOrals] = useState([]);
    const [cardiacs, setCardiacs] = useState([]);
    const [msks, setMsks] = useState([]);
    const [skins, setSkins] = useState([]);
    const [abdos, setAbdos] = useState([]);
    const [supines, setSupines] = useState([]);
    const [breaths, setBreaths] = useState([]);

    //attributes to hold the selected id from user input
    const [date, setDate] = useState("");
    const [cnsId, setCnsId] = useState("");
    const [lungId, setLungId] = useState("");
    const [hnId, setHnId] = useState("");
    const [oralId, setOralId] = useState("");
    const [cardiacId, setCardiacId] = useState("");
    const [mskId, setMskId] = useState("");
    const [skinId, setSkinId] = useState("");
    const [abdoId, setAbdoId] = useState("");
    const [supineId, setSupineId] = useState("");
    const [breathId, setBreathId] = useState("");
    const [abnormal, setAbnormal] = useState("");
    useEffect(() => {
        (async () => {
            try {
                const responseCNS = await fetch(
                    `http://localhost:8080/api/centralnervoussystem/all`
                );
                const dataCNS = await responseCNS.json();
                setCentralnervoussystems(dataCNS);
                //   console.log(centralnervoussystems);

                const responseLUNG = await fetch(
                    `http://localhost:8080/api/lung/all`
                );
                const dataLUNG = await responseLUNG.json();
                setLungs(dataLUNG);

                const responseHN = await fetch(
                    `http://localhost:8080/api/headandneck/all`
                );
                const dataHN = await responseHN.json();
                setHns(dataHN);

                const responseORAL = await fetch(
                    `http://localhost:8080/api/oral/all`
                );
                const dataORAL = await responseORAL.json();
                setOrals(dataORAL);

                const responseCARDIAC = await fetch(
                    `http://localhost:8080/api/cardiac/all`
                );
                const dataCARDIAC = await responseCARDIAC.json();
                setCardiacs(dataCARDIAC);

                const responseMSK = await fetch(
                    `http://localhost:8080/api/musculoskeletal/all`
                );
                const dataMSK = await responseMSK.json();
                setMsks(dataMSK);

                const responseSKIN = await fetch(
                    `http://localhost:8080/api/skin/all`
                );
                const dataSKIN = await responseSKIN.json();
                setSkins(dataSKIN);

                const responseABDO = await fetch(
                    `http://localhost:8080/api/abdomen/all`
                );
                const dataABDO = await responseABDO.json();
                setAbdos(dataABDO);

                const responseSUPINE = await fetch(
                    `http://localhost:8080/api/supine/all`
                );
                const dataSUPINE = await responseSUPINE.json();
                setSupines(dataSUPINE);

                const responseBREATH = await fetch(
                    `http://localhost:8080/api/breath/all`
                );
                const dataBREATH = await responseBREATH.json();
                setBreaths(dataBREATH);

            } catch (e) {
                console.log(e);
            }
        })();
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);


    const saveExam = async (e) => {
        e.preventDefault();

        try {
            const result = await fetch(
                `http://localhost:8080/api/exam/new`,
                {
                    method: "POST",
                    mode: "cors",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify({
                        "id": null,
                        "abdoId": abdoId,
                        "uliId": 155063610,
                        "date": date,
                        "cnsId": cnsId,
                        "lungId": lungId,
                        "hnId": hnId,
                        "oralId": oralId,
                        "cardiacId": cardiacId,
                        "mskId": mskId,
                        "peripheralId": skinId,
                        "abnormal": abnormal,
                        "supineId": supineId,
                        "breathId": breathId
                    })
                }
            )
            const data = await result.text();
            console.log(data);
        } catch (e) {
            console.log(e);
        }
    }

    //button hidden status
    const [isCNSHidden, setIsCNSHidden] = useState("");
    const [isLungHidden, setIsLungHidden] = useState("");
    const [isHNHidden, setIsHNHidden] = useState("");
    const [isOralHidden, setIsOralHidden] = useState("");
    const [isMSKHidden, setIsMSKHidden] = useState("");
    const [isSkinHidden, setIsSkinHidden] = useState("");
    const [isAbdoHidden, setIsAbdoHidden] = useState("");
    const [isSupineHidden, setIsSupineHidden] = useState("");
    const [isBreathHidden, setIsBreathHidden] = useState("");


    //tableName Prop to the dialog and Api call
    const [tableName, setTableName] = useState("");

    // add dialog function
    const [openAdd, setAddOpen] = useState(false);
    const handleAddOpen = () => {
        setAddOpen(true);
    }

    const handleAddClose = () => {
        setAddOpen(false);
    };
    //delete dialog function
    const [openDelete, setDeleteOpen] = useState(false);
    const handleDeleteOpen = () => {
        setDeleteOpen(true);
    }

    const handleDeleteClose = () => {
        setDeleteOpen(false);
    };

    const [descriptionId, setDescriptionId] = useState("");
    const [description, setDescription] = useState("");

    //edit dialog function
    const [openEdit, setEditOpen] = useState(false);
    const handleEditOpen = () => {
        setEditOpen(true);
    }

    const handleEditClose = () => {
        setEditOpen(false);
    };

    //setup useEffect for synchronous update
    useEffect(() => {
        setTableName(tableName);
        setDescriptionId(descriptionId);
        setDescription(description);
        setIsCNSHidden(isCNSHidden);
    }, [tableName, descriptionId, description, isCNSHidden, isLungHidden, isHNHidden, isOralHidden, isMSKHidden, isSkinHidden, isAbdoHidden, isSupineHidden, isBreathHidden])
    // UI 
    return (
        <Container maxWidth="md" >
            <div className='container' style={{
                display: 'flex', justifyContent:
                    'center', alignItems: 'center', marginTop: '70px', marginBottom: '25px'
            }}>
                <form onSubmit={saveExam}>
                    <h3>Patient Exam</h3>
                    <Grid container spacing={3} width={'70vw'}>

                        <Grid item xs={12}>
                            <TextField fullWidth type="date" name="date" label="Exam Date" InputLabelProps={{ shrink: true }} onChange={(e) => setDate(e.target.value)} />
                        </Grid>
                        <Grid item xs={12}>
                            <FormControl fullWidth required >
                                <InputLabel id="demo-simple-select-label">Central Nervous System (CNS)</InputLabel>
                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    name="cnsId"
                                    required
                                    label="Central Nervous System (CNS)"
                                    onChange={(e) => { setCnsId(e.target.value) }}
                                    value={cnsId}
                                    onClose={() => setIsCNSHidden("none")}
                                    onOpen={() => setIsCNSHidden("")}
                                >
                                    {centralnervoussystems.map((centralnervoussystem, i) => (
                                        <MenuItem style={{ display: "flex", justifyContent: "space-between" }} value={`${centralnervoussystem.id}`} key={i} >{centralnervoussystem.description}
                                            <div id="menuItemButton" style={{ display: `${isCNSHidden}` }}>
                                                <Button className="btn1 btn-warning ml-1"
                                                    onClick={() => { setDescriptionId(centralnervoussystem.id); setDescription(centralnervoussystem.description); setTableName("centralnervoussystem"); handleEditOpen(); }}><GoPencil /></Button>
                                                <Button className="btn2" color="danger"
                                                    onClick={() => { setDescriptionId(centralnervoussystem.id); setDescription(centralnervoussystem.description); setTableName("centralnervoussystem"); handleDeleteOpen(); }}> <GoTrashcan /></Button>
                                            </div></MenuItem>)
                                    )}
                                    <MenuItem onClick={() => { setTableName("centralnervoussystem"); handleAddOpen() }}><Button className="btn2" color="info"> <GoDiffAdded /></Button></MenuItem>
                                </Select>
                            </FormControl>
                        </Grid>

                        <Grid item xs={12}>
                            <FormControl fullWidth required >
                                <InputLabel id="demo-simple-select-label">Lung</InputLabel>
                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    name="lungId"
                                    label="Lung"
                                    onChange={(e) => setLungId(e.target.value)}
                                    value={lungId}
                                    required
                                    onClose={() => setIsLungHidden("none")}
                                    onOpen={() => setIsLungHidden("")}
                                >
                                    {lungs.map((lung, i) => (
                                        <MenuItem style={{ display: "flex", justifyContent: "space-between" }} value={`${lung.id}`} key={i} >{lung.description}
                                            <div id="menuItemButton" style={{ display: `${isLungHidden}` }}>
                                                <Button className="btn1 btn-warning ml-1"
                                                    onClick={() => { setDescriptionId(lung.id); setDescription(lung.description); setTableName("lung"); handleEditOpen(); }}><GoPencil /></Button>
                                                <Button className="btn2" color="danger"
                                                    onClick={() => { setDescriptionId(lung.id); setDescription(lung.description); setTableName("lung"); handleDeleteOpen(); }}> <GoTrashcan /></Button>
                                            </div></MenuItem>)
                                    )}
                                    <MenuItem onClick={() => { setTableName("lung"); handleAddOpen() }}><Button className="btn2" color="info"> <GoDiffAdded /></Button></MenuItem>
                                </Select>
                            </FormControl>
                        </Grid>

                        <Grid item xs={12}>
                            <FormControl fullWidth required>
                                <InputLabel id="demo-simple-select-label" >Hemagglutinin-Neuraminidase (HN)</InputLabel>
                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    name="hnId"
                                    label="Hemagglutinin-Neuraminidase (HN)"
                                    onChange={(e) => setHnId(e.target.value)}
                                    value={hnId}
                                    required
                                    onClose={() => setIsHNHidden("none")}
                                    onOpen={() => setIsHNHidden("")}
                                >
                                    {hns.map((hn, i) => (
                                        <MenuItem style={{ display: "flex", justifyContent: "space-between" }} value={`${hn.id}`} key={i} >{hn.description}
                                            <div id="menuItemButton" style={{ display: `${isHNHidden}` }}>
                                                <Button className="btn1 btn-warning ml-1"
                                                    onClick={() => { setDescriptionId(hn.id); setDescription(hn.description); setTableName("hn"); handleEditOpen(); }}><GoPencil /></Button>
                                                <Button className="btn2" color="danger"
                                                    onClick={() => { setDescriptionId(hn.id); setDescription(hn.description); setTableName("hn"); handleDeleteOpen(); }}> <GoTrashcan /></Button>
                                            </div></MenuItem>)
                                    )}
                                    <MenuItem onClick={() => { setTableName("hn"); handleAddOpen() }}><Button className="btn2" color="info"> <GoDiffAdded /></Button></MenuItem>
                                </Select>
                            </FormControl>
                        </Grid>

                        <Grid item xs={12}>
                            <FormControl fullWidth required>
                                <InputLabel id="demo-simple-select-label">Oral</InputLabel>
                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    name="oralId"
                                    label="Oral"
                                    onChange={(e) => setOralId(e.target.value)}
                                    value={oralId}
                                    required
                                    onClose={() => setIsOralHidden("none")}
                                    onOpen={() => setIsOralHidden("")}
                                >
                                    {orals.map((oral, i) => (
                                        <MenuItem style={{ display: "flex", justifyContent: "space-between" }} value={`${oral.id}`} key={i}>{oral.description}
                                            <div id="menuItemButton" style={{ display: `${isOralHidden}` }}>
                                                <Button className="btn1 btn-warning ml-1"
                                                    onClick={() => { setDescriptionId(oral.id); setDescription(oral.description); setTableName("oral"); handleEditOpen(); }}><GoPencil /></Button>
                                                <Button className="btn2" color="danger"
                                                    onClick={() => { setDescriptionId(oral.id); setDescription(oral.description); setTableName("oral"); handleDeleteOpen(); }}> <GoTrashcan /></Button>
                                            </div></MenuItem>)
                                    )}
                                    <MenuItem onClick={() => { setTableName("oral"); handleAddOpen() }}><Button className="btn2" color="info"> <GoDiffAdded /></Button></MenuItem>
                                </Select>
                            </FormControl>
                        </Grid>

                        <Grid item xs={12}>
                            <FormControl fullWidth required>
                                <InputLabel id="demo-simple-select-label">Musculoskeletal (MSK)</InputLabel>
                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    name="mskId"
                                    label="Musculoskeletal (MSK)"
                                    onChange={(e) => setMskId(e.target.value)}
                                    value={mskId}
                                    onClose={() => setIsMSKHidden("none")}
                                    onOpen={() => setIsMSKHidden("")}
                                >
                                    {msks.map((msk, i) => (
                                        <MenuItem style={{ display: "flex", justifyContent: "space-between" }} value={`${msk.id}`} key={i} >{msk.description}
                                            <div id="menuItemButton" style={{ display: `${isMSKHidden}` }}>
                                                <Button className="btn1 btn-warning ml-1"
                                                    onClick={() => { setDescriptionId(msk.id); setDescription(msk.description); setTableName("msk"); handleEditOpen(); }}><GoPencil /></Button>
                                                <Button className="btn2" color="danger"
                                                    onClick={() => { setDescriptionId(msk.id); setDescription(msk.description); setTableName("msk"); handleDeleteOpen(); }}> <GoTrashcan /></Button>
                                            </div></MenuItem>)
                                    )}
                                    <MenuItem onClick={() => { setTableName("msk"); handleAddOpen() }}><Button className="btn2" color="info"> <GoDiffAdded /></Button></MenuItem>
                                </Select>
                            </FormControl>
                        </Grid>

                        <Grid item xs={12}>
                            <FormControl fullWidth required>
                                <InputLabel id="demo-simple-select-label">Peripheral / Skin</InputLabel>
                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    name="skinsId"
                                    label="Peripheral / Skin"
                                    onChange={(e) => setSkinId(e.target.value)}
                                    value={skinId}
                                    onClose={() => setIsSkinHidden("none")}
                                    onOpen={() => setIsSkinHidden("")}
                                >
                                    {skins.map((skin, i) => (
                                        <MenuItem style={{ display: "flex", justifyContent: "space-between" }} value={`${skin.id}`} key={i}>{skin.description}
                                            <div id="menuItemButton" style={{ display: `${isSkinHidden}` }}>
                                                <Button className="btn1 btn-warning ml-1"
                                                    onClick={() => { setDescriptionId(skin.id); setDescription(skin.description); setTableName("skin"); handleEditOpen(); }}><GoPencil /></Button>
                                                <Button className="btn2" color="danger"
                                                    onClick={() => { setDescriptionId(skin.id); setDescription(skin.description); setTableName("skin"); handleDeleteOpen(); }}> <GoTrashcan /></Button>
                                            </div></MenuItem>)
                                    )}
                                    <MenuItem onClick={() => { setTableName("skin"); handleAddOpen() }}><Button className="btn2" color="info"> <GoDiffAdded /></Button></MenuItem>
                                </Select>
                            </FormControl>
                        </Grid>


                        <Grid item xs={12}>
                            <FormControl fullWidth required>
                                <InputLabel id="demo-simple-select-label">Abdominal (Abdo)</InputLabel>
                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    name="abdoId"
                                    label="Abdominal (Abdo)"
                                    onChange={(e) => setAbdoId(e.target.value)}
                                    value={abdoId}
                                    onClose={() => setIsAbdoHidden("none")}
                                    onOpen={() => setIsAbdoHidden("")}
                                >
                                    {abdos.map((abdo, i) => (
                                        <MenuItem style={{ display: "flex", justifyContent: "space-between" }} value={`${abdo.id}`} key={i}>{abdo.description}
                                            <div id="menuItemButton" style={{ display: `${isAbdoHidden}` }}>
                                                <Button className="btn1 btn-warning ml-1"
                                                    onClick={() => { setDescriptionId(abdo.id); setDescription(abdo.description); setTableName("abdo"); handleEditOpen(); }}><GoPencil /></Button>
                                                <Button className="btn2" color="danger"
                                                    onClick={() => { setDescriptionId(abdo.id); setDescription(abdo.description); setTableName("abdo"); handleDeleteOpen(); }}> <GoTrashcan /></Button>
                                            </div></MenuItem>)
                                    )}
                                    <MenuItem onClick={() => { setTableName("abdo"); handleAddOpen() }}><Button className="btn2" color="info"> <GoDiffAdded /></Button></MenuItem>
                                </Select>
                            </FormControl>
                        </Grid>

                        <Grid item xs={12}>
                            <FormControl fullWidth required>
                                <InputLabel id="demo-simple-select-label">Supine</InputLabel>
                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    name="supineId"
                                    label="Supine"
                                    onChange={(e) => setSupineId(e.target.value)}
                                    value={supineId}
                                    onClose={() => setIsSupineHidden("none")}
                                    onOpen={() => setIsSupineHidden("")}
                                >
                                    {supines.map((supine, i) => (
                                        <MenuItem style={{ display: "flex", justifyContent: "space-between" }} value={`${supine.id}`} key={i}>{supine.description}
                                            <div id="menuItemButton" style={{ display: `${isSupineHidden}` }}>
                                                <Button className="btn1 btn-warning ml-1"
                                                    onClick={() => { setDescriptionId(supine.id); setDescription(supine.description); setTableName("supine"); handleEditOpen(); }}><GoPencil /></Button>
                                                <Button className="btn2" color="danger"
                                                    onClick={() => { setDescriptionId(supine.id); setDescription(supine.description); setTableName("supine"); handleDeleteOpen(); }}> <GoTrashcan /></Button>
                                            </div></MenuItem>)
                                    )}
                                    <MenuItem onClick={() => { setTableName("supine"); handleAddOpen() }}><Button className="btn2" color="info"> <GoDiffAdded /></Button></MenuItem>
                                </Select>
                            </FormControl>
                        </Grid>

                        <Grid item xs={12}>
                            <FormControl fullWidth required>
                                <InputLabel id="demo-simple-select-label">Breath</InputLabel>
                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    name="breathId"
                                    label="Breath"
                                    onChange={(e) => setBreathId(e.target.value)}
                                    value={breathId}
                                    onClose={() => setIsBreathHidden("none")}
                                    onOpen={() => setIsBreathHidden("")}
                                >
                                    {breaths.map((breath, i) => (
                                        <MenuItem style={{ display: "flex", justifyContent: "space-between" }} value={`${breath.id}`} key={i} >{breath.description}
                                            <div id="menuItemButton" style={{ display: `${isBreathHidden}` }}>
                                                <Button className="btn1 btn-warning ml-1"
                                                    onClick={() => { setDescriptionId(breath.id); setDescription(breath.description); setTableName("breath"); handleEditOpen(); }}><GoPencil /></Button>
                                                <Button className="btn2" color="danger"
                                                    onClick={() => { setDescriptionId(breath.id); setDescription(breath.description); setTableName("breath"); handleDeleteOpen(); }}> <GoTrashcan /></Button>
                                            </div></MenuItem>)
                                    )}
                                    <MenuItem onClick={() => { setTableName("breath"); handleAddOpen() }}><Button className="btn2" color="info"> <GoDiffAdded /></Button></MenuItem>
                                </Select>
                            </FormControl>
                        </Grid>


                        <Grid item xs={12}>
                            <TextField fullWidth
                                id="outlined-multiline-static"
                                name="abnormal"
                                label="ABNORMAL"
                                multiline
                                rows={5}
                                onChange={(e) => setAbnormal(e.target.value)}
                                value={abnormal}
                            />
                        </Grid>
                        <Grid item xs={12}>
                            <Button color="primary" type="submit" onSubmit={saveExam} >Save</Button>
                            <ToastContainer />
                        </Grid>

                        <AddDialog
                            onClose={handleAddClose}
                            open={openAdd}
                            tableName={tableName}
                        />
                        <DeleteDialog
                            onClose={handleDeleteClose}
                            open={openDelete}
                            tableName={tableName}
                            descriptionId={descriptionId}
                            description={description}
                        />

                        <EditDialog
                            onClose={handleEditClose}
                            open={openEdit}
                            tableName={tableName}
                            descriptionId={descriptionId}
                            description={description}
                        />

                    </Grid>
                </form>
            </div>

        </Container >

    )
}

export default Other;