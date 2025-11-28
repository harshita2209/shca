import Header from '../Header/Header';
import Sidebar from '../Sidebar/Sidebar';




const First = () => {
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

export default First;