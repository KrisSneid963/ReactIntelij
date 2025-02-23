import React, { useEffect, useState } from "react";
import { fetchTours } from "../../helpers/fetchTours";
import TourCard from "./TourCard";

const TourList = () => {
    const [tours, setTours] = useState([]);
    console.log (tours);

    useEffect(() => {
        const loadTours = async () => {
            console.log("Fetching tours in useEffect..."); 
            const data = await fetchTours();
            console.log("Tour List Received Data:", data); 
            setTours(data);
        };

        loadTours();
    }, []);

    return (
        <div 
          className="min-h-screen bg-cover bg-center flex flex-col items-center p-8"
          style={{ backgroundImage: "url('/assets/VilniusDownload.jpg')" }} 
        >
          <div className="bg-amber-40">
            <h1 className="text-4xl font-bold">💚</h1>
          </div>
    
          <div className="flex justify-center items-center flex-wrap gap-8 mt-8 w-full max-w-6xl">
            {tours.length === 0 ? (
              <p className="text-white text-lg">Loading tours...</p>
            ) : (
              tours.map((tour) => <TourCard key={tour.id} tour={tour} />)
            )}
          </div>
        </div>
      );
    };
    
    export default TourList;