import React, { useEffect, useState } from 'react';
import { TextField, Button } from '@material-ui/core';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogTitle from '@mui/material/DialogTitle';
import { ToastContainer, toast } from 'react-toastify';
import DialogContentText from '@mui/material/DialogContentText';


export default function EditDialog({ onClose, open, tableName, descriptionId, description }) {

  const notify = () => {
    toast.success('Successfully Edited! Refresh to see changes', {
      position: toast.POSITION.TOP_RIGHT,
      autoClose: 2000
    })
  }

  const [editDescription, setEditDescription] = useState(description);
  const [row, setRow] = useState({ "id": descriptionId, "description": editDescription });
  //useEffect to update sychronously
  useEffect(() => {
    setEditDescription(editDescription);
    setRow({ "id": descriptionId, "description": editDescription })
  }, [editDescription])

  //api call to edit row in database
  const handleEditConfirm = async () => {
    setRow({ "id": descriptionId, "description": editDescription });
   // console.log(descriptionId + ":  " + editDescription);

    try {
      let result = await fetch(
        `http://localhost:8080/api/${tableName}/update`,
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
    } catch (e) {
      console.log(e);
    }
  };

  return (
    <Dialog open={open} onClose={onClose} fullWidth>
      <DialogTitle id="alert-dialog-title">Edit description</DialogTitle>
      <DialogContent>
        <DialogContentText>
          Original description: {description}
        </DialogContentText>
        <TextField name="editDescription" value={editDescription} required fullWidth onChange={(e) => setEditDescription(e.target.value)} label="New Description" variant="standard" margin="dense" />
      </DialogContent>
      <DialogActions>
        <Button autoFocus color="primary" onClick={() => handleEditConfirm()}>
          Confrim
        </Button>
        <Button color='secondary' onClick={() => onClose()}>Cancel</Button>
      </DialogActions>
      <ToastContainer />

    </Dialog>

  );
};
