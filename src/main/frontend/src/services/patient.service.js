import httpClient from "../components/httpClient";

const getAll = () => {
    return httpClient.get('/patients');
}

export default { getAll };