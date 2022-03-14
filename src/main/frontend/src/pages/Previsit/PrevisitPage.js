import React from 'react' 
import DetailedInfo from './DetailedInfo';
import FVCFEVInfo from './FVCFEVInfo';
import GeneralInfo from './GeneralInfo';
import Previsit_form from './Previsit_form';
 
 
/* npm install reactstrap
 */
const Previsit = () => (
    <div>
    
        <GeneralInfo />
        <DetailedInfo />
        <FVCFEVInfo />
     
    </div>
);

export default Previsit;