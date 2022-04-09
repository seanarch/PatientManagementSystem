import React from 'react';
import { useFormik } from 'formik';
import { FormControl, InputLabel, Grid, Select, MenuItem, Box, Container } from '@material-ui/core';
import TextField from '@mui/material/TextField';
import { Button } from 'reactstrap';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import SearchBar from '../../components/SearchBar';
import { GoTrashcan, GoPencil} from "react-icons/go"

/* npm install @mui/material @emotion/react @emotion/styled */
const Other = () => {

    const notify = () => {

        toast.success('Successfully saved!', {
            position: toast.POSITION.TOP_RIGHT,
            autoClose: 2000
        })
    }

    const otherForm = useFormik({
        initialValues: {
            CNS: { ECOG: "" },
            Lung: { ECOG: "" },
            HN: { ECOG: "" },
            Oral: { ECOG: "" },
            Cardiac: { ECOG: "" },
            MSK: { Description: "" },
            Skin: { ECOG: "" },
            Adbo: { ECOG: "" },
            ABNORMAL: { Description: "" },
            Supine: { Setup: "" },
            Breath: { Breath: "" },
        },

        /*  no validation because these fields can be null in database */
        onSubmit: (values) => {
            console.log(values)
            //once submit,provide value for back end
        }
    })
    return (
        <Container maxWidth="md" >
            <div className='container' style={{
                display: 'flex', justifyContent:
                    'center', alignItems: 'center', marginTop: '70px', marginBottom: '25px'
            }}>
                <form onSubmit={otherForm.handleSubmit}>
                    <h3>Patient Exam</h3>
                    <Grid container spacing={3} width={'70vw'}>
                        <Grid item xs={12}>
                            <FormControl fullWidth>
                                <InputLabel id="demo-simple-select-label">Central Nervous System (CNS)</InputLabel>

                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    name="CNS.ECOG"
                                    label="Central Nervous System (CNS)"
                                    onChange={otherForm.handleChange}
                                    value={otherForm.values.CNS.ECOG}

                                >
                                    <MenuItem value={7}>ABNORMALITY NOTED SEE DETAIL</MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                    <MenuItem value={8}>CN 2-12, EOM, PERLA, Speech and Facial symmetry were normal</MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                    <MenuItem value={9}>Not performed</MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                </Select>
                            </FormControl>
                        </Grid>

                        <Grid item xs={12}>
                            <FormControl fullWidth >
                                <InputLabel id="demo-simple-select-label">Lung</InputLabel>
                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    name='Lung.ECOG'
                                    label="Lung"
                                    onChange={otherForm.handleChange}
                                    value={otherForm.values.Lung.ECOG}
                                >
                                    <MenuItem value={7}>ABNORMALITY NOTED SEE DETAIL</MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                    <MenuItem value={8}>Good AE Bilat  no crackles / wheezes / dullness / accessory muscle / cyanosis</MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                    <MenuItem value={9}>Not performed</MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                </Select>
                            </FormControl>
                        </Grid>

                        <Grid item xs={12}>
                            <FormControl fullWidth>
                                <InputLabel id="demo-simple-select-label">Hemagglutinin-Neuraminidase (HN)</InputLabel>
                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    name='HN.ECOG'
                                    label="Hemagglutinin-Neuraminidase (HN)"
                                    onChange={otherForm.handleChange}
                                    value={otherForm.values.HN.ECOG}
                                >
                                    <MenuItem value={7}>ABNORMALITY NOTED SEE DETAIL</MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                    <MenuItem value={8}>No cervical or supra-clavicular lymphadenopathy, no scleral icterus or jaundice</MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                    <MenuItem value={9}>Not performed</MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                </Select>
                            </FormControl>
                        </Grid>

                        <Grid item xs={12}>
                            <FormControl fullWidth>
                                <InputLabel id="demo-simple-select-label">Oral</InputLabel>
                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    name='Oral.ECOG'
                                    label="Oral"
                                    onChange={otherForm.handleChange}
                                    value={otherForm.values.Oral.ECOG}
                                >
                                    <MenuItem value={7}>ABNORMALITY NOTED SEE DETAIL</MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                    <MenuItem value={8}>Gait, strength and reflexes - Normal. No bony tenderness in spine</MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                    <MenuItem value={9}>Not performed</MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                </Select>
                            </FormControl>
                        </Grid>

                        <Grid item xs={12}>
                            <FormControl fullWidth>
                                <InputLabel id="demo-simple-select-label">Cardiac</InputLabel>
                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    name='Cardiac.ECOG'
                                    label="Cardiac"
                                    onChange={otherForm.handleChange}
                                    value={otherForm.values.Cardiac.ECOG}
                                >
                                    <MenuItem value={7}>ABNORMALITY NOTED SEE DETAIL</MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                    <MenuItem value={8}>Heart sounds Normal. Regular pulse, good peripheral pulses and capillary refills</MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                    <MenuItem value={9}>Not performed</MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                </Select>
                            </FormControl>
                        </Grid>

                        <Grid item xs={12}>
                            <FormControl fullWidth>
                                <InputLabel id="demo-simple-select-label">Musculoskeletal (MSK)</InputLabel>
                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    name='MSK.Description'
                                    label="Musculoskeletal (MSK)"
                                    onChange={otherForm.handleChange}
                                    value={otherForm.values.MSK.Description}
                                >
                                    <MenuItem value={7}>ABNORMALITY NOTED SEE DETAIL</MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                    <MenuItem value={8}>Gait, strength and reflexes - Normal. No bony tenderness in spine</MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                    <MenuItem value={9}>Not performed</MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                </Select>
                            </FormControl>
                        </Grid>

                        {/* Peripheral is displayed according to doctor's existing UI, however it's only the foreign key, instead of table name, which should be Skin */}
                        <Grid item xs={12}>
                            <FormControl fullWidth>
                                <InputLabel id="demo-simple-select-label">Peripheral / Skin </InputLabel>
                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    name="Skin.ECOG"
                                    label="Peripheral / Skin"
                                    onChange={otherForm.handleChange}
                                    value={otherForm.values.Skin.ECOG}
                                >
                                    <MenuItem value={7}>ABNORMALITY NOTED SEE DETAIL</MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                    <MenuItem value={8}>No obvious skin metastasis on back or face. No edema was noted in legs</MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                    <MenuItem value={9}>Not performed</MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                </Select>
                            </FormControl>
                        </Grid>

                        <Grid item xs={12}>
                            <FormControl fullWidth>
                                <InputLabel id="demo-simple-select-label">Abdominal (Adbo)</InputLabel>
                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    name='Adbo.ECOG'
                                    label="Abdominal (Adbo)"
                                    onChange={otherForm.handleChange}
                                    value={otherForm.values.Adbo.ECOG}
                                >
                                    <MenuItem value={7}>ABNORMALITY NOTED SEE DETAIL</MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                    <MenuItem value={8}>No visual changes, Abd soft, liver not enlarged. No mass ascites or inguinal LN,</MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                    <MenuItem value={9}>Not performed</MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                </Select>
                            </FormControl>
                        </Grid>
                        <Grid item xs={12}>
                            <FormControl fullWidth>
                                <InputLabel id="demo-simple-select-label">Supine</InputLabel>
                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    name='Supine.Setup'
                                    label="Supine"
                                    onChange={otherForm.handleChange}
                                    value={otherForm.values.Supine.Setup}
                                >
                                    <MenuItem value={1}>Able to lay flat Supine or Prone
                                    </MenuItem>
                                    <MenuItem value={2}>Cannot Lay Prone</MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                    <MenuItem value={3}>Cannot Lay Supine</MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                    <MenuItem value={4}>Not performed</MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                </Select>
                            </FormControl>
                        </Grid>

                        <Grid item xs={12}>
                            <FormControl fullWidth>
                                <InputLabel id="demo-simple-select-label">Breath</InputLabel>
                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    name='Breath.Breath'
                                    label="Breath"
                                    onChange={otherForm.handleChange}
                                    value={otherForm.values.Breath.Breath}
                                >
                                    <MenuItem value={1}>Reg breathing. Tolerates Compression

                                    </MenuItem>
                                    {/* MenuItem value match database, which is missing number 2 */}
                                    <MenuItem value={3}>Reg breathing, CANNOT Tolerate Compression
                                    </MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                    <MenuItem value={4}>Irreg breathing, Tolerates Compress
                                    </MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                    <MenuItem value={5}>Did non assess breathing
                                    </MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                    <MenuItem value={6}>Irreg breath, CANNOT Tolerate Compression
                                    </MenuItem>
                                    <div className="ml-auto ml-auto">
                                        <Button className="btn1 btn-warning ml-1"> <GoPencil /> </Button>
                                        <Button className="btn2" color="danger"> <GoTrashcan /></Button>
                                    </div>
                                </Select>
                            </FormControl>
                        </Grid>

                        <Grid item xs={12}>
                            <TextField fullWidth
                                id="outlined-multiline-static"
                                name="ABNORMAL.Description"
                                label="ABNORMAL"
                                multiline
                                rows={5}
                                onChange={otherForm.handleChange}
                                value={otherForm.values.ABNORMAL.Description}
                            />
                        </Grid>
                        <Grid item xs={12}>
                            <Button onClick={notify} color="primary" type="submit" >Save</Button>
                            <ToastContainer />
                        </Grid>
                    </Grid>
                </form>
            </div>

        </Container>

    )
}

export default Other;