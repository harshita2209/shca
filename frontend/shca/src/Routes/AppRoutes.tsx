import { BrowserRouter, Route, Routes } from 'react-router-dom'

import LoginPage from '../Pages/LoginPage'
import Random from '../Pages/Random'
import RegisterPage from '../Pages/RegisterPage'
import ProtectedRoute from './ProtectedRoute'
import PublicRoute from './PublicRoute'
import AdminDashboard from '../Layout/AdminDashboard'

const AppRoutes = () => {
  return (
    <BrowserRouter>
        <Routes>
            <Route path="/login" element={<PublicRoute><LoginPage /></PublicRoute>} />
            <Route path="/register" element={<PublicRoute><RegisterPage /></PublicRoute>} />
            <Route path="/" element={<ProtectedRoute><AdminDashboard /></ProtectedRoute>} >
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