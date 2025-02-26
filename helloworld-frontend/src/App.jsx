import './App.css'
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
          </Routes>
        <FooterComponent/>
      </BrowserRouter>
    </>
  )
}

export default App
