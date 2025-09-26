import axios from 'axios';

// Create axios instance with base configuration
const axiosClient = axios.create({
    baseURL: 'http://localhost:5432/',
    timeout: 10000, // 10 seconds timeout
    headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json',
    },
});

// // Request interceptor to add auth token
// axiosClient.interceptors.request.use(
//     (config) => {
//         // Get token from localStorage or wherever you store it
//         const token = localStorage.getItem('authToken');

//         if (token) {
//             config.headers.Authorization = `Bearer ${token}`;
//         }

//         return config;
//     },
//     (error) => {
//         return Promise.reject(error);
//     }
// );

// // Response interceptor for error handling
// axiosClient.interceptors.response.use(
//     (response) => {
//         return response;
//     },
//     (error) => {
//         // Handle common errors
//         if (error.response) {
//             // Server responded with error status
//             const { status, data } = error.response;

//             switch (status) {
//                 case 401:
//                     // Unauthorized - redirect to login or refresh token
//                     localStorage.removeItem('authToken');
//                     window.location.href = '/login';
//                     break;
//                 case 403:
//                     // Forbidden
//                     console.error('Access forbidden:', data.message);
//                     break;
//                 case 404:
//                     // Not found
//                     console.error('Resource not found:', data.message);
//                     break;
//                 case 500:
//                     // Server error
//                     console.error('Server error:', data.message);
//                     break;
//                 default:
//                     console.error('API Error:', data.message || 'Unknown error');
//             }
//         } else if (error.request) {
//             // Network error
//             console.error('Network error:', error.message);
//         } else {
//             // Something else happened
//             console.error('Request error:', error.message);
//         }

//         return Promise.reject(error);
//     }
// );

export default axiosClient;
