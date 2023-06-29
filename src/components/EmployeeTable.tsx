import { Employee } from "../entity/Employee";
import { useState } from "react";
import { Fragment } from "react";
import Button from "./Button";

interface EmployeeTableProps {
  employees: Employee[];
  onSelectItem: (item: Employee) => void;
}

function EmployeeTable({ employees, onSelectItem }: EmployeeTableProps) {
  const [selectedIndex, setSelectedIndex] = useState(-1);
  return (
    <>
      <h1>Employees</h1>
      <h2><Button children = "Add new employee" onClick={() => {}}/></h2>
      <table className="table table-striped">
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Hire Date</th>
            <th scope="col">Salary</th>
            <th scope="col">Job Title</th>
            <th scope="col">Workplace Address</th>
          </tr>
        </thead>
        <tbody>
          {employees.map((employee, index, j) => {
            return (
              <Fragment key={index}>
                <tr
                  className={
                    selectedIndex === index
                      ? "table table-striped table-active"
                      : "table table-striped"
                  }
                  onClick={() => {
                    setSelectedIndex(index);
                    onSelectItem(employee);
                  }}
                >
                  <td>{employee.id}</td>
                  <td>{employee.name}</td>
                  <td>{employee.hireDate}</td>
                  <td>{employee.salary}</td>
                  <td>{employee.jobTitle}</td>
                  <td>{employee.buildingAddress}</td>
                </tr>
                {selectedIndex === index && (
                  <tr className="table table-striped table-active">
                    <td onClick={() => {}} className="btn btn-secondary">
                      Update
                    </td>
                    <td onClick={() => {}} className="btn btn-danger">
                      Delete
                    </td>
                  </tr>
                )}
              </Fragment>
            );
          })}
        </tbody>
      </table>
    </>
  );
}

export default EmployeeTable;
