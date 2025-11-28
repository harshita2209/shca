import { BrowserRouter, Route, Routes } from 'react-router-dom'
import First from '../components/Home/First'
import LoginPage from '../components/Pages/LoginPage'
import Random from '../components/Pages/Random'
import RegisterPage from '../components/Pages/RegisterPage'

const AppRoutes = () => {
  return (
    <BrowserRouter>
        <Routes>
            <Route path="/login" element={<LoginPage />} />
            <Route path="/register" element={<RegisterPage />} />
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