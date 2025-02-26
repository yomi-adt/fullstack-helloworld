import './App.css'
import EmployeeComponent from './components/EmployeeComponent'
import FooterComponent from "./components/FooterComponent"
import HeaderComponent from "./components/HeaderComponent"
import ListEmployeeComponent from "./components/ListEmployeesComponent"
import {BrowserRouter, Routes, Route} from 'react-router-dom'

function App() {
  return (
    <>
      <BrowserRouter>
        <HeaderComponent/>
          <Routes>
            {/* If the use goes to this path, updates with corresponding component */}
            <Route path="/" element = {<ListEmployeeComponent/>}></Route>
            <Route path="/employees" element = {<ListEmployeeComponent/>}></Route>
            <Route path="/add-employee" element = {<EmployeeComponent/>}></Route>
          </Routes>
        <FooterComponent/>
      </BrowserRouter>
    </>
  )
}

export default App
