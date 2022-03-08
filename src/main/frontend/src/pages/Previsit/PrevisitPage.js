import React from 'react' 
import DetailedInfo from './DetailedInfo';
import GeneralInfo from './GeneralInfo';
import Previsit_form from './Previsit_form';
 
 
/* npm install reactstrap
 */
const Previsit = () => (
    <div>
    
        <GeneralInfo />
        <DetailedInfo />
     
    </div>
);

export default Previsit;