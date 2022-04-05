import React from 'react';
import {
    Nav,
    NavLink,
    Bars,
    NavMenu,
    NavBtn,
    NavBtnLink
} from './NavbarElements';

const Navbar = () => {
    return (
        <>
            <Nav>
                <NavLink to='/'>
                        Welcome Page
                </NavLink>
                <Bars />
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
                    {/* Second Nav */}
                    {/* <NavBtnLink to='/sign-in'>Sign In</NavBtnLink> */}
                </NavMenu>
                <NavBtn>
                    <NavBtnLink to='/signin'>Sign In</NavBtnLink>
                </NavBtn>
            </Nav>
        </>
    );
};

export default Navbar;