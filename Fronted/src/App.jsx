import './App.css'
import Login from './pages/Login'
import Home from './pages/Home'
import { BrowserRouter, Routes, Route } from "react-router-dom"
import Dashboard from './pages/Dashboard'
import StudentSection from "./sections/StudentSection"
import CourseSection from "./sections/CourseSection"
import ProtectedLayout from './components/ProtectedLayout'

function App() {
  return (
    <BrowserRouter>
      <Routes>
        {/* Ruta pública */}
        <Route path="/" element={<Login />} />

        {/* Rutas protegidas dentro de un layout */}
        <Route element={<ProtectedLayout />}>
          <Route path="/home" element={<Home />} />
        </Route>

        {/* Dashboard con rutas hijas */}
        <Route path="/dashboard" element={<Dashboard />}>
          {/* Ruta index equivale a path="" */}
          <Route index element={<StudentSection />} />
          <Route path="students" element={<CourseSection />} />
        </Route>
      </Routes>
    </BrowserRouter>
  )
}

export default App
