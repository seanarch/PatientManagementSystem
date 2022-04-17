import React, { useEffect, useState } from 'react';
import { TextField, Button } from '@material-ui/core';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogTitle from '@mui/material/DialogTitle';
import { ToastContainer, toast } from 'react-toastify';
import PropTypes from 'prop-types';



export default function AddDialog({ onClose, open, tableName, setIsChanged }) {

  const notify = () => {

    toast.success('Successfully Added! Refresh to See Changes', {
      position: toast.POSITION.TOP_RIGHT,
      autoClose: 2000
    })
  }

  const [newDescription, setNewDescription] = useState("");
  //api call to add a new row in database
  const [row, setRow] = useState({ "id": null, "description": newDescription });
  useEffect(()=>{
    setNewDescription(newDescription);
    setRow({"id":null, "description": newDescription});
  },[newDescription]);

  const handleAddConfirm = async (e) => {
    setRow({ "id": null, "description": newDescription});
    console.log(newDescription);

    try {
      let result = await fetch(
        `http://localhost:8080/api/${tableName}/new`,
        {
          method: "post",
          mode: "cors",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify(row)
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
      <DialogTitle id="alert-dialog-title">Add a new description</DialogTitle>
      <DialogContent>
        <TextField name="newDescription" required fullWidth value={newDescription} onChange={(e) => setNewDescription(e.target.value)} label="New Description" variant="standard" margin="dense" />
      </DialogContent>
      <DialogActions>
        <Button autoFocus color="primary" onClick={(e) => handleAddConfirm(e)}>
          Confrim
        </Button>
        <Button color='secondary' onClick={() => onClose()}>Cancel</Button>
      </DialogActions>
      <ToastContainer />

    </Dialog>

  );
};
