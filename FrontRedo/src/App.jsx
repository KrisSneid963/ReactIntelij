import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import TourList from "./components/TourList";
import TourDetail from "./components/TourDetail";
import Registration from "./components/registration/Registration"; 

const App = () => {
  return (
    <BrowserRouter>
      <div className="container mx-auto p-4">
        <Routes>
          <Route path="/" element={<Registration />} /> 
          <Route path="/register" element={<Registration />} />
          <Route path="/tours" element={<TourList />} />
          <Route path="/tours/:id" element={<TourDetail />} />

        </Routes>
      </div>
    </BrowserRouter>
  );
};

export default App;