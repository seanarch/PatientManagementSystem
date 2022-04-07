import React, { useContext } from 'react';
import { AppContext } from "../Context/AppContext";
// import { Card, Input } from 'semantic-ui-react'
import { Table } from 'reactstrap';
import {
    Button, Modal, ModalFooter,
    ModalHeader, ModalBody
} from "reactstrap"

export default function SeePatientDetails() {

    const { patientDetails, filteredData, handleFilter, wordEntered, setPatientDetails, toggle, modal, selectedPatient, handleSearch, setSearchId, searchId } = useContext(AppContext);

    return (
        <>
            <div className='search__bar--container'>
                <div className='row'>
                    <div className='col-6'>
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
                    {/* <div className='col-4'>
                        <input type='text' list='searchlastName' className='search__bar--search-box' placeholder='Search LastName' />
                        <datalist id='searchlastName'>
                            {patientDetails.slice(0, 15).map((value, key) => {
                                return (
                                    <option>{value.lastname}</option>
                                );
                            })}
                        </datalist>
                    </div>*/}
                    <div className='col-6'>
                        <form onSubmit={handleSearch}>
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
                            {selectedPatient !== null && (
                                <tr>
                                    <td>1</td>
                                    <td>{selectedPatient.firstname}</td>
                                    <td>{selectedPatient.lastname}</td>
                                    <td>{selectedPatient.sex}</td>
                                    <td>{selectedPatient.birthday}</td>
                                    <td>
                                        <button type="submit" onClick={toggle} className='see__details--button'>See Details</button>
                                    </td>
                                </tr>
                            )}
                        </tbody>
                    </Table>
                    <Modal isOpen={modal}
                        toggle={toggle}
                        modalTransition={{ timeout: 1000 }}>
                        <ModalHeader>Patient Details</ModalHeader>
                        <ModalBody>
                            {selectedPatient !== null && (
                                <div>
                                    <p><strong>First name</strong> : {selectedPatient.firstname}</p>
                                    <p><strong>Last name</strong> : {selectedPatient.lastname}</p>
                                    <p><strong>Sex</strong> : {selectedPatient.sex}</p>
                                    <p><strong>Birthday</strong> : {selectedPatient.birthday}</p>
                                    <p><strong>Print</strong> : {selectedPatient.print}</p>
                                    <p><strong>Tg</strong> : {selectedPatient.tg}</p>
                                    <p><strong>Location</strong> : {selectedPatient.location}</p>
                                    <p><strong>ULI</strong> : {selectedPatient.id}</p>
                                </div>
                            )
                            }
                        </ModalBody>
                    </Modal>
                </div>
            </div>
        </>
    )
}