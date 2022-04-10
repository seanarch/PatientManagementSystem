import React from 'react'
import Fhxdetail from './Visit/Fhxdetail';
import ORinfo from './Visit/ORinfo';
import RTGIinfo from './Visit/RTGIinfo';
import Symptons from './Visit/Symptons';
import SearchBar from '../components/SearchBar';


const visit = () => (
    <div>
        <SearchBar/>
        <ORinfo/>
        <Fhxdetail/>
        <RTGIinfo/>
        <Symptons/>
    </div>
);

export default visit;