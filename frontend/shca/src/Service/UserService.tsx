import axiosInstance from "../Interceptor/AxiosInterceptor"

const registerUser=async(user: any)=>{
    return axiosInstance.post('/user/register,user')
    .then((response:any)=>response.data)
    .catch((error:any)=>{throw error;})
}

export {registerUser};