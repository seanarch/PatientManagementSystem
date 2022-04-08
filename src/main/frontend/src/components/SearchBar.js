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
                            value={wordEntered} className='search__bar--search-box' placeholder='Search FirstName' />
                        <datalist id='searchFirstName'>
                            {patientDetails.slice(0, 15).map((value, key) => {
                                //  console.log(value);
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
                        <form className='search__bar--form' onSubmit={handleSearch}>
                            <input type='text' value={searchId} onChange={e => setSearchId(e.target.value)} list='searchULI' className='search__bar--search-box' placeholder='Search ULI and press ENTER' />
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

            <div className='search__bar--table-container'>
                <div className='row'>
                    <Table responsive>
                        <thead>
                            <th>S/N</th>
                            <th>First name</th>
                            <th>Last name</th>
                            <th>Sex</th>
                            <th>Birthday</th>
                            <th>Details</th>
                        </thead>
                        <tbody>
                            {filteredData.length !== 0 && (

                                filteredData.slice(0, 15).map((value, index) => {
                                    return (
                                        <tr>
                                            <td>{index + 1}</td>
                                            <td>{value.firstname}</td>
                                            <td>{value.lastname}</td>
                                            <td>{value.sex}</td>
                                            <td>{value.birthday}</td>
                                            <td>
                                                <form onSubmit={setPatientDetails}>
                                                    <input type='hidden' value={value.id} />
                                                    <button type="submit" className='see__details--button'>See Details</button>
                                                </form>
                                            </td>
                                        </tr>
                                    );
                                })

                            )}
                        </tbody>
                    </Table>
                </div>
            </div>
        </>
    )
}
