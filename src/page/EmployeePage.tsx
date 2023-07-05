import { Fragment, useState, useEffect } from "react";
import { Employee } from "../entity/Employee";
import { employeeAPI } from "../api/employeeAPI";
import EmployeeTable from "../table/EmployeeTable";
import Button from "./../components/Button";

interface EmployeePageProps {
  projects: Employee[];
  loading: boolean;
  error: string | undefined;
}

function EmployeePage() {
  const [employees, setEmployees] = useState<Employee[]>([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | undefined>(undefined);
  const [isEditing, setEditing] = useState(false);

  const handleUpdateClick = () => {
    setEditing((isEditing) => !isEditing);
  };

  useEffect(() => {
    async function loadEmployees() {
      setLoading(true);
      try {
        const data = await employeeAPI.get(1);
        setError("");
        setEmployees(data);
      } catch (e) {
        if (e instanceof Error) {
          setError(e.message);
        }
      } finally {
        setLoading(false);
      }
    }
    loadEmployees();
  }, []);
  return (
    <>
      <h1>Buildings</h1>
      <h2>
        <Button children="Add new building" onClick={() => {}} />
      </h2>
      <EmployeeTable employees={employees} onSelectItem={() => {}} />
      {loading && (
        <div className="center-page">
          <span className="spinner primary"></span>
          <p>Loading...</p>
        </div>
      )}
    </>
  );
}

export default EmployeePage;
