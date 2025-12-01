import { ActionIcon, Button } from '@mantine/core';
import { IconBellRinging, IconLayoutSidebarLeftCollapseFilled } from '@tabler/icons-react';
import { useDispatch, useSelector } from 'react-redux';
import { Link } from 'react-router-dom';
import { removeJwt } from '../../Slices/JwtSlice';
import { removeUser } from '../../Slices/UserSlice';
import ProfileMenu from './ProfileMenu';



const Header = () => {
  const dispatch=useDispatch();
  const jwt=useSelector((state:any)=> state.jwt);


  const handleLogout=() => {
    console.log("Logout");
    dispatch(removeJwt());
    dispatch(removeUser());
  }

  return (
    // flex-1 so header fills remaining space; add padding
    <div className='bg-light shadow w-full h-16 flex justify-between px-2 items-center py-0'>




      <ActionIcon variant="transparent"  aria-label="Settings" size="input-lg">
        <IconLayoutSidebarLeftCollapseFilled width="50" height="50" style={{ width: '100%', height: '100%' }} stroke={1}   />
      </ActionIcon>
      <div className='flex gap-5 items-center'>
      
      {jwt?<Button color='red' onClick={handleLogout}>Logout</Button> :
      <Link to="login"><Button className='flex justify-center items-center'>Login</Button></Link>
      
      }
     {jwt && <> <ActionIcon variant="transparent"  aria-label="Settings" size="input-lg">
        <IconBellRinging width="25" height="25" style={{ width: '100%', height: '100%' }} stroke={1}  />
      </ActionIcon>

      
      <ProfileMenu /> </>}



      </div>

    </div>
  );
}

export default Header;