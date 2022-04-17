import React, { useState } from 'react';
import { Button } from '@material-ui/core';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogTitle from '@mui/material/DialogTitle';
import { ToastContainer, toast } from 'react-toastify';
import DialogContentText from '@mui/material/DialogContentText';
import PropTypes from 'prop-types';



export default function DeleteDialog({ onClose, open, tableName,descriptionId, description, setIsChanged }) {

  const notify = () => {
    toast.success('Successfully Deleted! Refresh to see changes', {
      position: toast.POSITION.TOP_RIGHT,
      autoClose: 2000
    })
  }

  //api call to delete the row in the table 
  const handleDeleteConfirm = async () => {

    //e.preventDefault();

    try {
      let result = await fetch(
        `http://localhost:8080/api/${tableName}/delete/id=${descriptionId}`,
        {
          method: "delete",
          mode: "cors",
          headers: {
            "Content-Type": "application/json"
          },
          body: descriptionId
        }
      );
      console.log("Submited: " + result);
      onClose();
      notify();
      setIsChanged();
    } catch (e) {
      console.log(e);
    }
  };

  return (
    <Dialog open={open} onClose={onClose} fullWidth>
      <DialogTitle id="alert-dialog-title">Are you sure to delete this description?</DialogTitle>
      <DialogContent>
        <DialogContentText>
          {description}
        </DialogContentText>
      </DialogContent>
      <DialogActions>
        <Button autoFocus color="primary" onClick={() => handleDeleteConfirm()}>
          Confirm
        </Button>
        <Button color='secondary' onClick={() => onClose()}>Cancel</Button>
      </DialogActions>
      <ToastContainer />

    </Dialog>

  );
};
