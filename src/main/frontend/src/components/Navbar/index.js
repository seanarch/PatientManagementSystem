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
                    <img src={require('../../images/logo.png')} alt='logo' />
                </NavLink>
                <Bars />
                <NavMenu>
                    <NavLink to='/register' activeStyle>
                        Register
                    </NavLink>
                    <NavLink to='/previsit' activeStyle>
                        Previsit
                    </NavLink>
                    <NavLink to='/visit' activeStyle>
                        Visit
                    </NavLink>
                    <NavLink to='/other' activeStyle>
                        Other
                    </NavLink>
                    <NavLink to='/endvisit' activeStyle>
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