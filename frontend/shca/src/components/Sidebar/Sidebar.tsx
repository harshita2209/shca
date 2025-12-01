import { Avatar, Text } from "@mantine/core";
import { IconCalendarCheck, IconHeartbeat, IconLayoutGrid, IconMoodHeart, IconStethoscope, IconVaccine } from "@tabler/icons-react";
import { useSelector } from "react-redux";
import { NavLink } from "react-router-dom";



const links=[
  {
    name:"Dashboard", url:"/dashboards", icon:<IconLayoutGrid stroke={1.5}/>
  },
  {
    name:"Doctors", url:"/doctors", icon:<IconStethoscope stroke={1.3}/>
  },
  {
    name:"Patients", url:"/patients", icon:<IconMoodHeart stroke={1.3}/>
  },
  {
    name:"Appointment", url:"/appointments", icon:<IconCalendarCheck stroke={1.3}/>
  },
  {
    name:"Pharmacy", url:"/pharmacys", icon:<IconVaccine stroke={1.3}/>
  }


]



const Sidebar = () => {
   const user=useSelector((state:any)=> state.user);
  return (
    // fixed width sidebar that doesn't shrink; add padding for appearance
    <div>
      <div className='w-64'></div>
   
    <div className='w-64 h-screen fixed overflow-y-auto hide-scrollbar bg-dark flex flex-col gap-7 items-center '>
      <div className= "fixed z-[500] bg-dark   py-3 text-pimary-400 flex gap-1 items-center">
        <IconHeartbeat size={40} stroke={2.5} />
        <span className="font-heading font-semibold text-3xl">Pulse</span>

      </div>




      <div className='flex flex-col gap-5 mt-20'>
      <div className="flex flex-col gap-1 items-center">
      <div className='p-1 bg-white rounded-full shadow-lg '>
       <Avatar className="rounded-full" radius="xl" size="xl" src="avatar.png" alt="Ram" />
       </div>
       <span className='font-medium text-light'> {user.name}</span>
       <Text c="dimmed" className="text-light" size="xs">{user.role}</Text>
      </div>
      <div className="flex flex-col gap-1">
        {
        links.map((link)=>{
          return <NavLink to={link.url} key={link.url} className={({isActive})=>`flex items-center gap-3 w-full font-medium text-light px-4 py-5 rounded-lg ${isActive ?"bg-pimary-400 text-dark":"hover:bg-gray-100 hover:text-dark"}`}>
            {link.icon}
            <span>{link.name}</span>

          </NavLink>
        }

        )    
      }


      </div>

      </div>
    </div>
     </div>
  )
}

export default Sidebar;