import React, { useContext } from 'react';
import { AppContext } from '../Context/AppContext';
import UserImage from '../images/User-profile-image.webp';
import { Form, FormGroup, Label, Col, Input, Button } from 'reactstrap';

const LoginForm = () => {

    const { loginDetails, setLoginDetails, handleLoginFormSubmit } = useContext(AppContext);

    return (
        <main className="login__form">
            <div className="register__form">
                <h3 className='text-center mb-5'>Welcome</h3>
                <div className='d-flex justify-content-center align-items-center'>
                    <img src={UserImage} className="user__image" alt="User" />
                </div>
                
                <Form onSubmit={handleLoginFormSubmit}>
                    <FormGroup row>
                        <Label
                            for="username"
                            sm={3}
                        >
                            Username
                        </Label>
                        <Col sm={9}>
                            <Input
                                id="username"
                                name="username"
                                placeholder="First Name"
                                value={loginDetails.userName}
                                type="text"
                                aria-required="true"
                                onChange={(e) => setLoginDetails({ ...loginDetails, userName: e.target.value })}
                            />
                        </Col>
                    </FormGroup>
                    <FormGroup row>
                        <Label
                            for="password"
                            sm={3}
                        >
                            Password
                        </Label>
                        <Col sm={9}>
                            <Input
                                id="password"
                                name="password"
                                value={loginDetails.password}
                                placeholder="********"
                                type="password"
                                aria-required="true"
                                onChange={(e) => setLoginDetails({ ...loginDetails, password: e.target.value })}
                            />
                        </Col>
                    </FormGroup>
                    <Button>
                        Submit
                    </Button>
                </Form>
               
            </div>
        </main>

    )
}


export default LoginForm;