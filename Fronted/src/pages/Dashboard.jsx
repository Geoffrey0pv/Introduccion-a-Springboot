import { Stack, Button , Box}  from "@mui/material";
import { Outlet, Link }  from "react-router-dom";

const Dashboard = () => {
    return (
        <Stack >
            <Stack direction="column">
                <Button component={Link} to="students">
                    Seccion 1
                </Button>
                <Button component={Link} to="">
                    Seccion 2
                </Button>
            </Stack>

            <Box>
                <Outlet />
            </Box>

        </Stack>
    );
}

export default Dashboard;