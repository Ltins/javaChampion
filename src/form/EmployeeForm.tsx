function EmployeeForm() {
  return (
    <form>
      <div className="form-group">
        <label htmlFor="inputId">ID</label>
        <input
          type="number"
          className="form-control"
          id="inputId"
          placeholder="Integer"
          min="1"
        />
      </div>
      <div className="form-group">
        <label htmlFor="inputName">Name</label>
        <input
          type="text"
          className="form-control"
          id="inputName"
          placeholder="Employee Name"
        />
      </div>
      <div className="form-group">
        <label htmlFor="inputDate">Hire Date</label>
        <input
          type="date"
          className="form-control"
          id="inputDate"
          placeholder="Hire Date"
        />
      </div>
      <div className="form-group">
        <label htmlFor="inputSalary">Salary</label>
        <input
          type="number"
          className="form-control"
          id="inputSalary"
          placeholder="Integer"
        />
      </div>
      <div className="form-group">
        <label htmlFor="inputTitle">Job Title</label>
        <input
          type="text"
          className="form-control"
          id="inputTitle"
          placeholder="Job Title"
        />
      </div>
      <div className="form-group">
        <label htmlFor="inputBuilding">Building</label>
        <select id="inputBuilding" className="form-control">
          <option selected>Choose...</option>
          <option>...</option>
        </select>
      </div>
      <div>
        <button type="submit" className="btn btn-primary">
          Submit
        </button>
      </div>
    </form>
  );
}

export default EmployeeForm;
