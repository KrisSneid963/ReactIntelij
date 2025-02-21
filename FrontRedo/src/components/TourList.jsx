import React, { useEffect, useState } from "react";
import { fetchTours } from "../helpers/fetchTours";

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
        <div className="container mx-auto p-4">
            <h1 className="text-xl font-bold">Tour List</h1>

        
            {tours.length === 0 ? (
                <p className="text-red-500">No tours available.</p>
            ) : (
                <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-4">
                    {tours.map((tour) => (
                        <div key={tour.id} className="bg-white p-4 shadow rounded">
                            <img src={tour.imageUrl} alt={tour.title} className="w-full h-40 object-cover" />
                            <h2 className="text-lg font-semibold">{tour.title}</h2>
                            <p className="text-gray-600">Category: {tour.category}</p>
                            <p className="text-gray-800">Price: ${tour.price}</p>
                        </div>
                    ))}
                </div>
            )}
        </div>
    );
};

export default TourList;
