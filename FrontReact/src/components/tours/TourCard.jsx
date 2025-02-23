import React from "react";
import PropTypes from "prop-types";
import { useNavigate } from "react-router-dom";

const TourCard = ({ tour }) => {
    const navigate = useNavigate();

    const handleBooking = () => {
        const token = localStorage.getItem("token");

        if (!token) {
            alert("Please register to book this tour!");
            navigate("/register");
            return;
        }

        // Proceed with booking logic if user is logged in
        fetch("http://localhost:8080/api/bookings", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                Authorization: `Bearer ${token}`,
            },
            body: JSON.stringify({
                userId: localStorage.getItem("userId"),
                tourId: tour.id,
                bookedDate: new Date().toISOString().split("T")[0],
            }),
        })
        .then(response => response.json())
        .then(data => {
            if (!data.success) {
                throw new Error(data.message || "Failed to book tour");
            }
            alert(`Tour "${tour.title}" has been booked successfully!`);
            navigate("/my-bookings");
        })
        .catch(error => {
            console.error("Booking failed:", error);
            alert(`Booking failed: ${error.message}`);
        });
    };

    return (
        <div className="bg-white p-4 shadow-md rounded-lg">
            <img src={tour.imageUrl} alt={tour.title} className="w-full h-40 object-cover rounded-md" />
            <h2 className="text-lg font-semibold mt-2">{tour.title}</h2>
            <p className="text-gray-600">{tour.category}</p>
            <p className="text-green-600 font-bold">${tour.price}</p>
            <button 
                onClick={handleBooking} 
                className="bg-blue-500 text-white px-4 py-2 rounded-md mt-2 hover:bg-blue-600">
                Book Now
            </button>
        </div>
    );
};

TourCard.propTypes = {
    tour: PropTypes.shape({
        id: PropTypes.string.isRequired,
        imageUrl: PropTypes.string.isRequired,
        title: PropTypes.string.isRequired,
        category: PropTypes.string.isRequired,
        price: PropTypes.number.isRequired,
    }).isRequired,
};

export default TourCard;
