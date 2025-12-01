import { BrowserRouter, Route, Routes } from 'react-router-dom'
import First from '../components/Home/First'
import LoginPage from '../components/Pages/LoginPage'
import Random from '../components/Pages/Random'
import RegisterPage from '../components/Pages/RegisterPage'
import PublicRoute from './PublicRoute'

const AppRoutes = () => {
  return (
    <BrowserRouter>
        <Routes>
            <Route path="/login" element={<PublicRoute><LoginPage /></PublicRoute>} />
            <Route path="/register" element={<PublicRoute><RegisterPage /></PublicRoute>} />
            <Route path="/" element={<First />} >
                <Route path="/dashboards" element={<Random />} />
                <Route path="/pharmacys" element={<Random />} />
                <Route path="/patients" element={<Random />} />
                <Route path="/doctors" element={<Random />} />
            </Route>
        </Routes>
    
    </BrowserRouter>
  )
}

export default AppRoutes