import React, { useState, useEffect } from 'react'
import { Grid, makeStyles } from '@material-ui/core'
import { TextField } from '@material-ui/core'

// const useStyles = makeStyles(theme => ({
//     root: {
//         '& .MuiFormControl-root': {
//             width: '80%',
//             margin: theme.spacing(1)
//         }
//     }
// }))

const initialFValues = {
    id: 0,
    fullName: '',
    email: '',
    mobile: '',
    city: '',
    gender: '',
    departmentId: '',
    date: new Date(),
    isPermanent: ''

}



export default function PatientsForm() {

    const [values, setValues] = useState(initialFValues);
    //const classes = useStyles();

    return (
        <form >
            <Grid container>
                <Grid item xs={8}>
                    <TextField
                        variant="outlined"
                        label="Full Name"
                        value={values.fullName}
                    />
                    <TextField
                        variant="outlined"
                        label="Email"
                        value={values.email}
                    />
                    <TextField
                        variant="outlined"
                        label="Mobile"
                        value={values.mobile}
                    />
                    <TextField
                        variant="outlined"
                        label="City"
                        value={values.city}
                    />
                    <TextField
                        variant="outlined"
                        label="Gender"
                        value={values.gender}
                    />
                    <TextField
                        variant="outlined"
                        label="DepartmentId"
                        value={values.departmentId}

                    />
                    <TextField
                        variant="outlined"
                        label="Date"
                        value={values.date}
                    />
                    <TextField
                        variant="outlined"
                        label="Permanent"
                        value={values.isPermanent}
                    />
                </Grid>

            </Grid>

        </form>
    )
}
