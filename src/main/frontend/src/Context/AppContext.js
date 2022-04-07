import React, { useState, createContext, useEffect } from "react";
import { useNavigate } from 'react-router-dom';

export const AppContext = createContext();

export const AppState = ({ children }) => {
    const [loginDetails, setLoginDetails] = useState({ userName: '', password: '' });
    // SEARCH PATIENT DATA
    const [patientDetails, setPatient] = useState([]); 
    const [patientId, setPatientId] = useState("");
    const [selectedPatient, setSelectedPatient] = useState({});
    const [filteredData, setFilteredData] = useState([]);
    const [wordEntered, setWordEntered] = useState("");
    const [searchId, setSearchId] = useState("");

    const navigate = useNavigate();

    const handleSearch = event => {
        event.preventDefault();
        patientDetails.forEach(patient => {
            if (patient.id === parseInt(searchId)) {
                setSelectedPatient(patient);
            }
        });
        navigate('/details');
    }

    

    // Modal open state
    const [modal, setModal] = useState(false);

    // Toggle for Modal
    const toggle = () => setModal(!modal);

    const SearchFilter = async () => {
        const patientResponse = await fetch(`http://localhost:8080/api/patient/all`);
        const patientResponseData = await patientResponse.json();
        patientResponseData.forEach(item => {
            if (item.firstname !== null) {
                setPatient(patientDetails => [...patientDetails, item]);
            }
        });
        // console.log("Started");
        setPatient(patientResponseData);
    }

    const handleFilter = (event) => {
        const searchWord = event.target.value;
        setWordEntered(searchWord);
        const newFilter = patientDetails.filter((value) => {
            return value.firstname.toLowerCase().includes(searchWord.toLowerCase());
        });

        if (searchWord === "") {
            setFilteredData([]);
        } else {
            setFilteredData(newFilter);
        }
    };

    const setPatientDetails = event => {
        event.preventDefault();
        const patientDetailsId = event.target[0].value;
        setPatientId(patientDetailsId);
        patientDetails.forEach(patient => {
            if (patient.id === parseInt(patientId)) {
                setSelectedPatient(patient);
            }
        });
    }

    const handleLoginFormSubmit = (e) => {
        e.preventDefault();
        //Log form values to console
        console.log(loginDetails);

        //save login detail for user session
        setLoginDetails(loginDetails);
    }


    useEffect(() => {
        SearchFilter();
    }, []);



    return (
        <AppContext.Provider value={{ loginDetails, setLoginDetails, handleLoginFormSubmit, patientDetails, patientId, filteredData, handleFilter, wordEntered, setPatientDetails, modal, toggle, selectedPatient, handleSearch, setSearchId, searchId }}>
            {children}
        </AppContext.Provider>
    );
};