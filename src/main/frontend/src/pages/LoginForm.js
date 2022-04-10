import React, { useContext, useState, useEffect } from 'react';
import { AppContext } from '../Context/AppContext';
import { Button } from 'reactstrap';
import { Container, Grid, TextField, Box,Alert } from '@material-ui/core';
import axios, { Axios } from 'axios';

const LoginForm = () => {

    const { loginDetails, setLoginDetails } = useContext(AppContext);
    const [loginStatus, setloginStatus] = useState("");
    const {isLoggedIn, setIsLoggedIn} = useContext(AppContext);


    const handleLoginFormSubmit = async (e) => {
        e.preventDefault();

        
        try {
            const result = await fetch(
                `http://localhost:8080/api/login`,
                {
                  method: "POST",
                  mode: "cors",
                  headers: {
                    "Content-Type": "application/json"
                  },
                  body: JSON.stringify({
                    "id": `${loginDetails.userEmail}`,
                    "password": `${loginDetails.password}`,
                  })
                
                }
              )
              const data = await result.json();
            //  console.log(data);

              //if data.message exist(user not found in the back end), display the message to screen
              if(data.message){
                setloginStatus(data.message);
              }else if(!data){
                  setloginStatus("User name password combination is not correct. Please try again");
              }else if(data){
                setloginStatus("Successfully logged in.");

                setIsLoggedIn(true);
              }

            } catch (e) {
              console.log(e);
            }
          }

          useEffect(()=>{
            window.localStorage.setItem("login-status", JSON.stringify(isLoggedIn));
        });
    
     
    return (
        <Container maxWidth="md">
            <div className='container' style={{
                display: 'flex', justifyContent:
                    'center', alignItems: 'center', marginTop: '50px'
            }}>


                <form width={'30vw'} onSubmit={handleLoginFormSubmit}>
                    <h3>Welcome to PMS</h3>
                    <Box mb={5} mt={5}><h4>Sign In</h4></Box>

                    <Grid container spacing={3}>
                        <Grid item xs={12}>
                            <TextField
                                id="userEmail"
                                label="User Email"
                                name="userEmail"
                                required
                                value={loginDetails.userEmail}
                                onChange={(e) => setLoginDetails({ ...loginDetails, userEmail: e.target.value })}
                                fullWidth
                            />
                        </Grid>

                        <Grid item xs={12}>
                            <TextField
                                id="password"
                                label="Password"
                                name="password"
                                required
                                type="password"
                                value={loginDetails.password}
                                onChange={(e) => setLoginDetails({ ...loginDetails, password: e.target.value })}
                                fullWidth
                            />
                        </Grid>

                        <Grid item xs={12} >
                            <Button color="primary" type="submit">Submit</Button>
                        </Grid>
                    </Grid>


                </form>
              
            </div>
            {
               loginStatus === "" ?
               null:
               (
                <div><h4>{loginStatus}</h4></div>
               )
            }
       
        </Container>

    )
}


export default LoginForm;