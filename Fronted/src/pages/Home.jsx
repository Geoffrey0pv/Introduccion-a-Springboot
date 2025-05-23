import { useEffect, useState } from "react";
import {TextField, Button, Box, Container, Typography} from "@mui/material";
import { getAllCourses } from "../services/CourseServices";

const Home = ()=>{

    const [courseList, setCourseList] = useState([]);

    const handleGetAllCourses = async ()=> {
        let array = await getAllCourses();
        setCourseList(array);
        console.log(array);
    }

    useEffect(()=>{
        console.log("Cargando los cursos...");
        handleGetAllCourses();
    }, []);

    return (
        <>
            <h2>Bienvenido</h2>
            <h6>Hola</h6>
            {
                courseList.map((course, index)=>{
                    return (
                        <Typography key={index}>
                            {course.name}
                        </Typography>
                    );
                })
            }
        </>
    );
}

export default Home;