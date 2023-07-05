import { Building } from "../entity/Building";
import { useState } from "react";
import { Fragment } from "react";

interface BuildingTableProps {
  buildings: Building[];
  onSelectItem: (item: Building) => void;
}

function BuildingTable({ buildings, onSelectItem }: BuildingTableProps) {
  const [selectedIndex, setSelectedIndex] = useState(-1);
  return (
    <>
      <table className="table table-striped">
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Address</th>
            <th scope="col">Rent Date</th>
            <th scope="col">Area</th>
          </tr>
        </thead>
        <tbody>
          {buildings.map((building, index) => {
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
                    onSelectItem(building);
                  }}
                >
                  <td>{building.id}</td>
                  <td>{building.address}</td>
                  <td>{building.rentDate}</td>
                  <td>{building.area}</td>
                </tr>
              </Fragment>
            );
          })}
        </tbody>
      </table>
    </>
  );
}

export default BuildingTable;
