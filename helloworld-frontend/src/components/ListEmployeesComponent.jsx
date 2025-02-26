import React, {useEffect, useState} from 'react'
import { listEmployees } from '../services/EmployeeService'
import {useNavigate} from 'react-router-dom'

function ListEmployeeComponent(){

    // useState takes in the initial value of the state variable
    // useState returns an array of size two. First is the state variable name. Second is a function name to update the state variable
    const [employees, setEmployees] = useState([])

    // Navigates the user to the specified path
    const navigator = useNavigate();

    // Takes two params. First is the callBack function. Second is dependency list
    useEffect(() => {
            // As the call back function we have a function that calls the axios REST api
            // It then calls the setEmployees function to set the state of the employees object
            // Finally, in case of any errors we display to console
            listEmployees().then((response => {
                setEmployees(response.data);
            })).catch(error => {
                console.error(error)
            })
        },
        []
    )

    // Button has an onClick that references this function
    // On click, the navigator navigates client to this route
    function addNewEmployee(){
        navigator('/add-employee')
    }

    return (
        <div className="container">
            <h2 className="text-center">List of Employees</h2>
            <button className="btn btn-primary mb-2" onClick={addNewEmployee}>Add Employee</button>
            <table className="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>

                    </tr>
                </thead>
                <tbody>
                    {
                        employees.map(employee => 
                            <tr key={employee.id}>
                                <td>{employee.id}</td>
                                <td>{employee.firstName}</td>
                                <td>{employee.lastName}</td>
                                <td>{employee.email}</td>

                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
}

export default ListEmployeeComponent