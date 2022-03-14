import React from 'react'
import { TextField } from '@material-ui/core';
import { useField } from 'formik';

const DatePicker = ({...props}) => {
  const [field, meta] = useField(props.name);

  const configDatePicker = {
    ...field,
    ...props,
    type: 'date',
    variant: 'outlined',
    InputLabelProps: {
      shrink: true //enble labels to be passed to component
    }
  };

  //handle error
    if(meta && meta.touched && meta.error){
     configDatePicker.eror = true;
     configDatePicker.helperText = meta.error;
   }
   
  return (
    <TextField
    {...configDatePicker }
  />
  );
};

export default DatePicker;