import React, { useState, createContext, useEffect } from "react";

export const AppContext = createContext();

export const AppState = ({ children }) => {
    const [loginDetails, setLoginDetails] = useState({ userName: '', password: '' });

    const handleLoginFormSubmit = (e) => {
        e.preventDefault();
        //Log form values to console
        console.log(loginDetails);

        //save login detail for user session
        setLoginDetails(loginDetails);
    }

    useEffect(() => {
        console.log("Hello world");
    }, []);



    return (
        <AppContext.Provider value={{ loginDetails, setLoginDetails, handleLoginFormSubmit }}>
            {children}
        </AppContext.Provider>
    );
};