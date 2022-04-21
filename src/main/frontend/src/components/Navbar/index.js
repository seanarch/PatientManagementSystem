import React, { useContext, useState } from 'react';
import { AppContext } from '../../Context/AppContext';

import {
    Nav,
    NavLink,
    Bars,
    NavMenu,
    NavBtn,
    NavBtnLink
} from './NavbarElements';

const Navbar = () => {

    const { isLoggedIn, setIsLoggedIn } = useContext(AppContext);

    return (
        <>
            <Nav>
                <NavLink to='/'>
                     
                </NavLink>
                <Bars />

                {
                    isLoggedIn ? (
                        <>
                            <NavMenu>
                                <NavLink to='/register' activestyle="true">
                                    New Patient
                                </NavLink>
                                <NavLink to='/previsit' activestyle="true">
                                    Previsit
                                </NavLink>
                                <NavLink to='/visit' activestyle="true">
                                    Visit
                                </NavLink>
                                <NavLink to='/other' activestyle="true">
                                    Other
                                </NavLink>
                                <NavLink to='/endvisit' activestyle="true">
                                    End Visit
                                </NavLink>
                            </NavMenu>
                            <NavBtn>
                                <NavBtnLink to='/' onClick={() => setIsLoggedIn(false)}>Sign Out</NavBtnLink>
                            </NavBtn>
                        </>

                    ) : (
                        <NavBtn>
                            <NavBtnLink to='/signin'>Sign In</NavBtnLink>
                        </NavBtn>
                    )
                }

            </Nav>
        </>
    );
};

export default Navbar;