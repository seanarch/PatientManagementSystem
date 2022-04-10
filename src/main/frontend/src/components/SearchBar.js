import React, { useContext } from 'react';
import { AppContext } from "../Context/AppContext";
// import { Card, Input } from 'semantic-ui-react'
import { Table } from 'reactstrap';
import {
    Button, Modal, ModalFooter,
    ModalHeader, ModalBody
} from "reactstrap"

export default function SearchPatient() {

    const { patientDetails, filteredData, handleFilter, wordEntered, setPatientDetails, toggle, modal, selectedPatient, handleSearch, setSearchId, searchId } = useContext(AppContext);

    return (
        <>
            <div className='search__bar--container'>
                <div className='row'>
                    <div className='col-4'>
                        <input type='text' list='searchFirstName' onChange={handleFilter}
                            value={wordEntered} className='search__bar--search-box' placeholder='Firstname' />
                        <datalist id='searchFirstName'>
                            {patientDetails.slice(0, 15).map((value, key) => {
                                return (
                                    <option>{value.firstname}</option>
                                );
                            })}
                        </datalist>
                    </div>
                     <div className='col-4'>
                        <input type='text' list='searchlastName' className='search__bar--search-box' placeholder='Lastname' />
                        <datalist id='searchlastName'>
                            {patientDetails.slice(0, 15).map((value, key) => {
                                return (
                                    <option>{value.lastname}</option>
                                );
                            })}
                        </datalist>
                    </div>

                    <div className='col-4'>
                        <form className='search__bar--form' onSubmit={handleSearch}>
                            <input type='text' value={searchId} onChange={e => setSearchId(e.target.value)} list='searchULI' className='search__bar--search-box' placeholder='ULI' />
                            <datalist id='searchULI'>
                                {patientDetails.slice(0, 15).map((value, key) => {
                                    //  console.log(value);
                                    return (
                                        <option>{value.id}</option>
                                    );
                                })}
                            </datalist>
                        </form>
                    </div>

                </div>
            </div>

        </>
    )
}
