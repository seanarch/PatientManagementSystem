import React from "react";
import axios from "axios";

export default function PatientsList() {
    const url = "http://localhost:8080/api/patient/";
    const getAllPatients = () => {
        axios.get(url)
    }
}