import httpClient from "../components/httpClient";

const getAll = () => {
    return httpClient.get('/patients');
}

const get = id => {
    return httpClient.get(`/patients/${id}`);

}

const update = (data) => {
    return httpClient.put(`/patients/${data.id}`, data);
}

export default { getAll, get, update };