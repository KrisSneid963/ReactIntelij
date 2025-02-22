import React from "react";
import PropTypes from "prop-types";
import { Link } from "react-router-dom";

const TourCard = ({ tour }) => {
    return (
        <div className="bg-white p-4 shadow-md rounded-lg">
            <img src={tour.imageUrl} alt={tour.title} className="w-full h-40 object-cover rounded-md" />
            <h2 className="text-lg font-semibold mt-2">{tour.title}</h2>
            <p className="text-gray-600">{tour.category}</p>
            <p className="text-green-600 font-bold">${tour.price}</p>
            <Link to={`/tour/${tour.id}`} className="text-blue-500 hover:underline mt-2 block">View Details</Link>
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
