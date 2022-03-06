import React from 'react';
import { TextField } from '@material-ui/core';
import { useField} from 'formik';

const TextFieldWrapper = ({...props}) => {

  const [field] = useField(props.name);

  const configTextField = {
    ...field,
    ...props,
    fullWidth: true,
    variant: 'outlined'
  };



    return(
      <TextField {...configTextField} />
    )
};

export default TextFieldWrapper;
