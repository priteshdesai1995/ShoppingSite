import axios from "axios";

const CAROUSEL_REST_API_BASEURL = "http://localhost:9999/carousal/";

export const getAllProductCarousal = () => {
    return axios.get(CAROUSEL_REST_API_BASEURL + "getAll");
}

export const addProductToCarousal = (employee) => {
    return axios.post(CAROUSEL_REST_API_BASEURL + "create", employee);
}