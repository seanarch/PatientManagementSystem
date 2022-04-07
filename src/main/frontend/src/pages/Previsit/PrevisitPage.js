import React from 'react' 
import DetailedInfo from './DetailedInfo';
import FVCFEVInfo from './FVCFEVInfo';
import GeneralInfo from './GeneralInfo';
import Previsit_form from './Previsit_form';
import SearchBar from '../../components/SearchBar';
 
 
/* npm install reactstrap
 */
const Previsit = () => (
    <div>
        <SearchBar/>
        <GeneralInfo />
        <DetailedInfo />
        <FVCFEVInfo />
     
    </div>
);

export default Previsit;