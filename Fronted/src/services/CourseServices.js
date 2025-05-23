import axios from "axios";
import {URL_BASE} from "../constants/globals";

export const getAllCourses = async ()=>{
    let token = localStorage.getItem('token');
    let result = await axios.get(
            `${URL_BASE}/api/v1/courses`,
            {
                headers: {
                    "Authorization":`Bearer ${token}`
                }
            }
        );
    return result.data;
}