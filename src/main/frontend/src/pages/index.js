import React from 'react'
import heroImage from '../images/pexels-negative-space-48604.jpg'

const Home = () => {
    return (
        <main>
            <div className="container mt-4">
                <div className="row">
                    <h2>
                        Welcome <span className="docName">Dr Sinha</span>
                    </h2>
                </div>
            </div>

            <div className="container mt-4">
                <div className="row">
                    <img src={heroImage} alt="Sthethoscope" loading="lazy" className="img-responsive dashHeroImage w-100"/>
                </div>
            </div>

            <div className="container mt-3">
                <div className="row">
                    <h3>
                        <span className="dashDate">Monday, 23 June, 2020</span><span className="dashTime">4:33pm</span>
                    </h3>                    
                </div>
            </div>
        </main>
    )
}

export default Home