import React from "react";
import { useNavigate } from "react-router-dom";

const Navbar = () => {
  const navigate = useNavigate();
  const isLoggedIn = localStorage.getItem("token"); // Check if user is logged in

  const handleLogin = () => {
    if (isLoggedIn) {
      localStorage.removeItem("token");
      localStorage.removeItem("userId");
      navigate("/"); // Redirect to home after logout
    } else {
      navigate("/login"); // Redirect to login page
    }
  };

  const handleRegister = () => {
    navigate("/register"); // Redirect to register page
  };

  return (
    <nav className="bg-green-600 p-4 flex justify-between items-center">
      <h1 className="text-white text-lg font-bold">Vilnius Tours</h1>
      <div className="flex items-center space-x-4"> {/* Flex container for buttons */}
        {!isLoggedIn ? (
          <>
            <button
              onClick={handleLogin}
              className="bg-white text-green-600 px-4 py-2 rounded-md shadow-md hover:bg-gray-200"
            >
              Login
            </button>
            <button
              onClick={handleRegister}
              className="bg-white text-green-600 px-4 py-2 rounded-md shadow-md hover:bg-gray-200"
            >
              Register
            </button>
          </>
        ) : (
          <button
            onClick={handleLogin}
            className="bg-white text-green-600 px-4 py-2 rounded-md shadow-md hover:bg-gray-200"
          >
            Logout
          </button>
        )}
      </div>
    </nav>
  );
};

export default Navbar;
