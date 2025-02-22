import { BrowserRouter, Routes, Route, useLocation } from "react-router-dom";
import Home from "./components/main/Home"; // ✅ Import Home for separate page
import TourList from "./components/tours/TourList"; // ✅ Default page
import TourDetail from "./components/tours/TourDetail";
import Registration from "./components/auth/Registration";
import NavBar from "./components/main/NavBar";
import Footer from "./components/main/Footer";
import Header from "./components/main/Header";

const Layout = ({ children }) => {
  const location = useLocation();
  const isRegisterPage = location.pathname === "/register";

  return (
    <div className="min-h-screen flex flex-col">
      {!isRegisterPage && <NavBar />}
      {!isRegisterPage && <Header />}
      <main className="flex-1">{children}</main>
      {!isRegisterPage && <Footer />}
    </div>
  );
};

const App = () => {
  return (
    <BrowserRouter>
      <Layout>
        <Routes>
          <Route path="/" element={<TourList />} /> {/* ✅ Show Tours by default */}
          <Route path="/home" element={<Home />} /> {/* ✅ Home is a separate page */}
          <Route path="/tours" element={<TourList />} />
          <Route path="/tours/:id" element={<TourDetail />} />
          <Route path="/register" element={<Registration />} />
        </Routes>
      </Layout>
    </BrowserRouter>
  );
};

export default App;
