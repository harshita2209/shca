import Header from '../components/Header/Header';
import Sidebar from '../components/Sidebar/Sidebar';




const AdminDashboard = () => {
  return (
    // make container a full-height flex row so children can flex as expected
    <div className='flex'>
      <Sidebar />
      <div className='w-full'>
      <Header />
      </div>
    </div>
  )
}

export default AdminDashboard;