import { UserContext } from "../context/UserContext";
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";

export const UserProvider = ({ children }) => {
  const [user, setUser] = useState(null);

  useEffect(() => {
        const storedUser = localStorage.getItem("user");
        if (storedUser) {
            const parsedUser = JSON.parse(storedUser);
            setUser(parsedUser);
        }
    }, []);


  return (
    <UserContext.Provider value={{ user, setUser }}>
      {children}
    </UserContext.Provider>
  );
}