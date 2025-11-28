import { ActionIcon, Button } from '@mantine/core';
import { IconBellRinging, IconLayoutSidebarLeftCollapseFilled } from '@tabler/icons-react';
import { Link } from 'react-router-dom';
import ProfileMenu from './ProfileMenu';


const Header = () => {
  return (
    // flex-1 so header fills remaining space; add padding
    <div className='bg-light shadow w-full h-16 flex justify-between px-2 items-center py-0'>




      <ActionIcon variant="transparent"  aria-label="Settings" size="input-lg">
        <IconLayoutSidebarLeftCollapseFilled width="50" height="50" style={{ width: '100%', height: '100%' }} stroke={1}   />
      </ActionIcon>
      <div className='flex gap-5 items-center'>
      <Link to="login"><Button className='flex justify-center items-center'>Login</Button></Link>
      <ActionIcon variant="transparent"  aria-label="Settings" size="input-lg">
        <IconBellRinging width="25" height="25" style={{ width: '100%', height: '100%' }} stroke={1}  />
      </ActionIcon>

      
      <ProfileMenu />



      </div>

    </div>
  );
}

export default Header;