import {TextField, Button, Box, Container, Typography} from "@mui/material";
import { useNavigate } from "react-router-dom";
import {login} from "../services/AuthServices";
import { useContext, useState } from "react";
import { UserContext } from "../context/UserContext";

const Login = ()=>{

    const navigate = useNavigate();
    const [error, setError] = useState("");
    const { user, setUser } = useContext(UserContext);


    const handleLogin = async (e) => {
        e.preventDefault();
        const formData = new FormData(e.target);
        try{
            await login(
                formData.get('email'), 
                formData.get('password')
            )
            let user = await getMyUser();
            navigate('/home');
        }catch(error){
            console.log(error);
            setError("Usuario o contraseña incorrecto");
        }
        
    }

    return (
        <>
            <Container maxWidth="sm">
                <Box component="form" onSubmit={handleLogin}>
                    <TextField 
                        fullWidth 
                        margin="normal" 
                        type="text" 
                        name="email"
                        label="Correo electrónico"/>
                    <TextField 
                        fullWidth 
                        margin="normal" 
                        type="password" 
                        name="password" 
                        label="Contraseña"/>
                    <Button 
                        fullWidth 
                        variant="contained"
                        type="submit">
                        Iniciar Sesion
                    </Button>
                    <Typography variant="h6" component="h6" sx={{color:"#000"}}>
                        {error}
                    </Typography>
                </Box>
            </Container>

        </>
    );
}


export default Login;