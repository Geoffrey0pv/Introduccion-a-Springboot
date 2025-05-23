import axios from "axios";
import {URL_BASE} from "../constants/globals";

export const login = async (email, password) => {
    let result = await axios.post(
        `${URL_BASE}/api/v1/auth/login`,
        {email,password}
    );
    console.log(result.data.accessToken);
    localStorage.setItem('token', result.data.accessToken);
}

export const getMyUser = async () => {
    const token = localStorage.getItem('token');
    let result = await axios.get(
        `${URL_BASE}/api/v1/auth/login`,
        {
            headers: {
                'Authorization': `Bearer ${token}`
            }
        }
    );
    console.log(result.data);
    localStorage.setItem('user', JSON.stringify(result.data));
    return result.data;
}
