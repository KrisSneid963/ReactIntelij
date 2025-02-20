// import { useState } from "react";
// import { useForm } from "react-hook-form";
// import { postLoginData } from "../helpers/postLogin";

// const Login = () => {
//     const { register, formState: { errors }, handleSubmit } = useForm();
//     const [loading, setLoading] = useState(false);
//     const [error, setError] = useState("");

//     const onSubmit = async (data) => {
//         setLoading(true);
//         try {
//             await postLoginData(data);
//             // Handle successful login
//         } catch (error) {
//             setError(`Login failed: ${error.message}`);
//             setLoading(false);
//         } finally {
//             setLoading(false);
//         }
//     }

//     return (
//         <>
//             <form onSubmit={handleSubmit(onSubmit)}>
//                 <input type="text"
//                     placeholder="Enter your email"
//                     {...register("email", {
//                         required: "Email is required"
//                     })}>
//                 </input>
//                 {errors && (
//                     <p>{errors.email?.message}</p>
//                 )}
//                 <input type="password"
//                     placeholder="Enter your password"
//                     {...register("password", {
//                         required: "Password is required"
//                     })}>
//                 </input>
//                 {errors && (
//                     <p>{errors.password?.message}</p>
//                 )}
//                 <button type="submit" value="submit">Login</button>
//                 {loading && <p>Loading...</p>}
//                 {error && <p>{error}</p>}
//             </form>
//         </>
//     )
// }
// export default Login;