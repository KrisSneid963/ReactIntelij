import axios from "axios";

const url = "http://localhost:8080/api/register";

export const postData = async (data) => {
  try {
    console.log("Sending data to server:", data); // Log the data being sent
    const response = await axios.post(url, data, {
      headers: {
        'Content-Type': 'application/json'
      }
    });
    console.log("Server response:", response.data); // Log the server response
    return response.data;
  } catch (error) {
    console.error("Error response:", error.response); // Log the error response
    if (error.response) {
      console.error("Error status:", error.response.status); // Log the error status
      console.error("Error data:", error.response.data); // Log the error data
    } else {
      console.error("Error message:", error.message); // Log the error message if no response
    }
    if (error.response && error.response.data && error.response.data.errors) {
      // Assuming the server returns validation errors in a specific format
      throw new Error(error.response.data.errors.map(err => err.message).join(", "));
    } else {
      throw new Error("An error occurred while registering");
    }
  }
};