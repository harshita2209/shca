import { Button, PasswordInput, SegmentedControl, TextInput } from "@mantine/core";
import { useForm } from "@mantine/form";
import { IconHeartbeat } from "@tabler/icons-react";
import { Link, useNavigate } from "react-router-dom";
import { registerUser } from "../../Service/UserService";
import { errorNotification, successNotification } from "../../Utility/NotificationUtil";


const RegisterPage = () => {
const navigate=useNavigate();
    const form = useForm({
        
    initialValues: {
      name : '',
      role: "PATIENT",
      email: '' ,
      password: '',
      confirmPassword: '',
    },

    validate: {
      name: (value:string) :string |null => (!value? "Name is required":null),
      email: (value:string): string | null => (/^\S+@\S+$/.test(value) ? null : 'Invalid email'),
      password:(value:string): string | null=> !value?"Password is required": !/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@!$%*&?])[A-Za-z\d@$!%*?&]{8,15}$/.test(value)
      ? "password must be 8-15 characters long and include uppercase, lowercase, number, and special character"
      : null,
      confirmPassword:(value:string):string | null=>(value === form.values.password ? null : "Password don't match"),
    },
  });

  const handleSubmit= (values: typeof form.values)=>{
    registerUser(values).then((data)=>{
      console.log(data);
    
      successNotification("Registered Successfully.");
      navigate("/login");
    }).catch((error)=>{
      errorNotification(error.response.data.errorMessage);
      console.log(error)
    })
  }









  return (
    <div className="h-screen w-screen !bg-cover !bg-center !bg-no-repeat flex flex-col  items-center justify-center" style={{background:'url("/login.jpg")'}}>
        <div className="flex flex-col items-center justify-center ">
             <div className= "  py-3 text-pink-400 flex  gap-1 items-center">
                    <IconHeartbeat size={40} stroke={2.5} />
                    <span className="font-heading font-semibold text-3xl ">Pulse</span>
            
                  </div>

           <div className="w-[800px] h-[400px] backdrop-blur-md p-10 py-8 flex flex-col justify-center items-center rounded-3xl">
                <form onSubmit={form.onSubmit(handleSubmit)} className="flex flex-col gap-5  text-2xl [&_input]:placeholder-neutral-50 [&_input]:!pl-2 [&_.mantine-Input-input]:!border-white focus-within:[&_.mantine-Input-input]:!border-pink-400 [&_.mantine-Input-input]:!border [&_svg]:text-white [&_input]:text-white">
                    <div className='self-center font-medium text-5xl pb-5  font-heading text-light '>Register</div>
                    <SegmentedControl{... form.getInputProps('role')} color="pink"  bg="none" className="[&_*]:!text-white border border-white" fullWidth size="md" radius="md" data={[{label:'Patient', value:'PATIENT'},{label : 'Doctor' ,value:'DOCTOR' },{label :'Admin', value:'ADMIN'}]} />
                    <TextInput {... form.getInputProps('name')} variant="unstyled" size="md" radius="md" placeholder="Name" />
                    <TextInput {... form.getInputProps('email')} variant="unstyled" size="md" radius="md" placeholder="Email" />
                    <PasswordInput {... form.getInputProps('password')} variant="unstyled" size="md" radius="md" placeholder="Password" />
                    <PasswordInput {... form.getInputProps('confirmPassword')} variant="unstyled" size="md" radius="md" placeholder="Confirm Password" />
                    <Button radius="md" size="md" type='submit' color="pink">Register</Button>
                    <div className="text-neutral-100 text-sm self-center">
                        Have a account? <Link to="/login" className="hover:underline">Login</Link>
                    </div>

                </form>
            </div> 
        </div>
    </div>
  )
}

export default RegisterPage;