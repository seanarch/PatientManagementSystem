import React from 'react';
import { Formik, Form, Field } from 'formik';
import { Button } from 'reactstrap';
import { Container, Grid, InputLabel, Select, MenuItem, FormControl, Checkbox } from '@material-ui/core';
import TextField from '../../components/TextField/TextField';
import DatePicker from '../../components/Date/DatePicker';
import axios from "axios"; 

const INITIAL_VALUES = {
    Symptom1: {
        Date1: "2021-03-17",
        Date2: "2021-03-17",
        Symptom: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.", 
    },
    SymptomCheckbox1: {
        Fevers: false,
        SOB: false,
        Nocturea: false,
        BADL: false,
        Cough: false,
        Hesitancy: false,
        IADLs: false,
        Hemoptisis: false,
        Hematurea: false,
        WTLoss: false,
        Wheeze: false,
        Pneumature: false,
        BackBone: false,
        ChestPain: false,
        
    },
    SymptomCheckbox2: {
        Headache: true,
        AppetiteLost: true,
        NauseaVo: true,
        VisionCha: true,
        ChewSwallow: true,
        Heartburn: true,
        Hearing:  true,
        Abdominal: true,
        BowelHab: true,
        SpeechCha: true,
        Hemeteme: true,
        RectalBlee: true,
        FocalWea: true,
        Melena: true,
    },
    Symptom1: {
        Date: "2021-04-22",
        ECOG: "String",
        Swallowing: "String",
        Breathing: "String",
    }
}