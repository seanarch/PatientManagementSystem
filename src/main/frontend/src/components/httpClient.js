import axios from "axios";

export default axios.create({
    baseURL: 'http://localhost:3601',
    headers: {
        'Content-Type': 'application/json'
    }
})