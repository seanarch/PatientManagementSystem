import React from 'react'
import Previsit_search from './Previsit/Previsit_search'

const Previsit = () => {
    return (
        <div style={{
            display: 'flex', justifyContent:
                'center', alignItems: 'center', height: '90vh'
        }}>Pre-visit

            <Previsit_search />
        </div>
    )
}

export default Previsit