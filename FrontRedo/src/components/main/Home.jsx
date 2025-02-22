import React from "react";



const Home = () => {
  return (
    <div className="bg-gray-100 p-8">
      <div className="max-w-4xl mx-auto bg-white p-6 rounded-lg shadow-lg">
        <h1 className="text-3xl font-bold text-center text-green-600">Welcome to Vilnius Tours</h1>
        <p className="text-gray-700 text-center mt-2">
          Discover the beauty of Vilnius through guided tours and unique experiences.
        </p>

        <div className="mt-6">
          <h2 className="text-2xl font-semibold text-gray-800">History</h2>
          <p className="text-gray-600 mt-2">
            Vilnius, the capital of Lithuania, is a city rich in history, culture, and breathtaking landmarks. 
            Vilnius history dates to the Stone Age. The city at least since 1323 until 1795 had been the capital of the Grand Duchy of Lithuania. Later Vilnius had been ruled by imperial and Soviet Russia, Napoleonic France, imperial and Nazi Germany, interwar Poland, and again became a capital of Lithuania in the 20th century.
            Our guided tours take you through medieval streets, historic castles, and vibrant nightlife.
          </p>
        </div>
      </div>
    </div>
  );
};

export default Home;
