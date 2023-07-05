import { Building } from "../entity/Building";
import { useState } from "react";

interface BuildingFormProps {
  onSubmit: (building: Building) => void;
  onCancel: (building: Building) => void;
  building: Building;
}

const BuildingForm = ({
  onSubmit,
  onCancel,
  building: initialBuilding,
}: BuildingFormProps) => {
  const [building, setBuilding] = useState(initialBuilding);

  const handleChange = (event: any) => {
    const { type, name, value, checked } = event.target;
    let updatedValue = type === "checkbox" ? checked : value;

    if (type === "number") {
      updatedValue = Number(updatedValue);
    }

    const change = {
      [name]: updatedValue,
    };

    let updatedBuilding: Building;
    setBuilding((b) => {
      updatedBuilding = new Building({ ...b, ...change });
      return updatedBuilding;
    });
  };

  return (
    <form className="input-group vertical">
      <div className="form-group">
        <label htmlFor="inputAddress">Address</label>
        <input
          type="text"
          className="form-control"
          id="inputAddress"
          name="address"
          placeholder="Workplace Address"
          value={building.address}
          onChange={handleChange}
        />
      </div>
      <div className="form-group">
        <label htmlFor="inputDate">Rent Date</label>
        <input
          type="date"
          className="form-control"
          name="rentDate"
          id="inputDate"
          placeholder="Rent Date"
          value={building.rentDate}
          onChange={handleChange}
        />
      </div>
      <div className="form-group">
        <label htmlFor="inputArea">Area</label>
        <input
          type="number"
          className="form-control"
          name="area"
          id="inputArea"
          placeholder="Integer"
          value={building.area}
          onChange={handleChange}
        />
      </div>
      <div>
        <button className="btn btn-primary" onClick={() => onSubmit(building)}>
          Submit
        </button>
        <span />
        <button className="btn btn-primary" onClick={() => onCancel(building)}>
          Cancel
        </button>
      </div>
    </form>
  );
};
export default BuildingForm;
