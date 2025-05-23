import { Navigate, Outlet } from "react-router-dom";

const ProtectedLayout = () => {
    const token = localStorage.getItem('token');
    if (token) {
        return <Outlet />;
    } else {
        return <Navigate to="/login" replace/>;
    }
}
export default ProtectedLayout;