import { Button, PasswordInput, TextInput } from "@mantine/core";
import { useForm } from "@mantine/form";
import { IconHeartbeat } from "@tabler/icons-react";
import { jwtDecode } from "jwt-decode";
import { useState } from "react";
import { useDispatch } from "react-redux";
import { Link, useNavigate } from "react-router-dom";
import { loginUser } from "../../Service/UserService";
import { setJwt } from "../../Slices/JwtSlice";
import { errorNotification, successNotification } from "../../Utility/NotificationUtil";
import { setUser } from "../../Slices/UserSlice";

const LoginPage = () => {
  const dispatch=useDispatch();
  const navigate=useNavigate();
  const [loading,setLoading]=useState(false);
    const form = useForm({
        
    initialValues: {
      email: '' ,
      password: '',
    },

    validate: {
      email: (value:string) => (/^\S+@\S+$/.test(value) ? null : 'Invalid email'),
      password:(value:string)=> (!value?"Password is required": null),
    },
  });

  const handleSubmit= (values: typeof form.values)=>{
    setLoading(true);
    loginUser(values).then((_data)=>{
        successNotification("Logged in Successfully.");
   
        dispatch(setJwt(_data));
        dispatch(setUser(jwtDecode(_data)));
    
      
      navigate("/");
    })
    .catch((error)=>{
      errorNotification(error?.response?.data?.errorMessage);
    })
    .finally(()=>setLoading(false));
  };









  return (
    <div className="h-screen w-screen !bg-cover !bg-center !bg-no-repeat flex flex-col  items-center justify-center" style={{background:'url("/login.jpg")'}}>
        <div className="flex flex-col items-center justify-center ">
             <div className= "  py-3 text-pink-400 flex  gap-1 items-center">
                    <IconHeartbeat size={40} stroke={2.5} />
                    <span className="font-heading font-semibold text-3xl ">Pulse</span>
            
                  </div>

           <div className="w-[800px] h-[400px] backdrop-blur-md p-10 py-8 flex flex-col justify-center items-center rounded-3xl">
                <form onSubmit={form.onSubmit(handleSubmit)} className="flex flex-col gap-5  text-2xl [&_input]:placeholder-neutral-50 [&_input]:!pl-2 [&_.mantine-Input-input]:!border-white focus-within:[&_.mantine-Input-input]:!border-pink-400 [&_.mantine-Input-input]:!border [&_svg]:text-white [&_input]:text-white">
                    <div className='self-center font-medium text-5xl pb-5  font-heading text-light '>Login</div>
                    <TextInput {... form.getInputProps('email')} variant="unstyled" size="md" radius="md" placeholder="Email" />
                    <PasswordInput {... form.getInputProps('password')} variant="unstyled" size="md" radius="md" placeholder="Password" />
                    <Button loading={loading} radius="md" size="md" type='submit' color="pink">Login</Button>
                    <div className="text-neutral-100 text-sm">
                        Don't have a account? <Link to="/register" className="hover:underline">Register</Link>
                    </div>

                </form>
            </div> 
        </div>
    </div>
  )
}

export default LoginPage