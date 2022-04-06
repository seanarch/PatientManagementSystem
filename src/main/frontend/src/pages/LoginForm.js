import React, { useContext } from 'react';
import { AppContext } from '../Context/AppContext';
import { Button } from 'reactstrap';
import { Container, Grid, TextField, Box } from '@material-ui/core';

const LoginForm = () => {

    const { loginDetails, setLoginDetails, handleLoginFormSubmit } = useContext(AppContext);

    return (
        <Container maxWidth="md">
            <div className='container' style={{
                display: 'flex', justifyContent:
                    'center', alignItems: 'center', marginTop: '50px'
            }}>


                <form width={'30vw'} onSubmit={handleLoginFormSubmit} >
                    <h3>Welcome to PMS</h3>
                    <Box mb={5} mt={5}><h4>Sign In</h4></Box>

                    <Grid container spacing={3}>
                        <Grid item xs={12}>
                            <TextField
                                id="userName"
                                label="Username"
                                name="userName"
                                required
                                value={loginDetails.userName}
                                onChange={(e) => setLoginDetails({ ...loginDetails, userName: e.target.value })}
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
                            <Button color="primary" type="submit" >Save</Button>
                        </Grid>
                    </Grid>


                </form>

            </div>
        </Container>

    )
}


export default LoginForm;