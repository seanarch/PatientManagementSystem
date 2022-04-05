import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Card, Input } from 'semantic-ui-react'

export default function SearchPatient() {
    const [patientDetails, setPatient] = useState([]);
    // const [filteredData, setFilteredData] = useState([]);
    // const [wordEntered, setWordEntered] = useState("");

    const SearchFilter = async () => {
        const patientResponse = await fetch(`http://localhost:8080/api/patient/all`);
        const patientResponseData = await patientResponse.json();
        patientResponseData.forEach(item => {
            if (item.firstname !== null) {
                setPatient(patientDetails => [...patientDetails, item]);
            }
        });
        // setPatient(patientResponseData);
        // console.log(patientResponseData);
      }
    
      useEffect(() => {
        SearchFilter();
      }, [])

    return (
        <>
            <div className='search__bar--container'>
                <div className='row'>
                    <div className='col-4'>
                        <input type='text' list='searchFirstName' className='search__bar--search-box' placeholder='Search FirstName' />
                        <datalist id='searchFirstName'>
                            {patientDetails.slice(0, 15).map((value, key) => {
                                console.log(value);
                                return (
                                    <option>{value.firstname}</option>
                                );
                            })}
                        </datalist>
                    </div>
                    <div className='col-4'>
                        <input type='text' list='searchlastName' className='search__bar--search-box' placeholder='Search LastName' />
                        <datalist id='searchlastName'>
                            {patientDetails.slice(0, 15).map((value, key) => {
                                return (
                                    <option>{value.lastname}</option>
                                );
                            })}
                        </datalist>
                    </div>
                    <div className='col-4'>
                        <input type='text' list='searchULI' className='search__bar--search-box' placeholder='Search ULI' />
                        <datalist id='searchULI'>
                            {patientDetails.slice(0, 15).map((value, key) => {
                                // return (
                                //     // <option>{value.ULI}</option>
                                // );
                            })}
                        </datalist>
                    </div>
                </div>
            </div>
        </>
    )
}