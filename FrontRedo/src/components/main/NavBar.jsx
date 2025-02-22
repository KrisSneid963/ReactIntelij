import { Link } from "react-router-dom";

const NavBar = () => {
  return (
    <nav className="bg-green-600 text-white p-4 flex justify-between">
      <Link to="/" className="text-lg font-bold">Vilnius Tours</Link>
      <div className="flex gap-4">
        <Link to="/home" className="hover:underline">Home</Link>
        <Link to="/tours" className="hover:underline">Tours</Link>
        <Link to="/register" className="bg-white text-green-600 px-4 py-2 rounded">Register</Link>
      </div>
    </nav>
  );
};

export default NavBar;
