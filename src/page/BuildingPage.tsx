import { Fragment, useState, useEffect } from "react";
import { Building } from "../entity/Building";
import { buildingAPI } from "../api/buildingAPI";
import BuildingTable from "../table/BuildingTable";
import Button from "./../components/Button";
import BuildingForm from "./../form/BuildingForm";

interface BuildingPageProps {
  buildings: Building[];
  loading: boolean;
  currentBuilding: Building;
  error: string | undefined;
}

function BuildingPage() {
  const [buildings, setBuildings] = useState<Building[]>([]);
  const [currentBuilding, setCurrentBuilding] = useState(new Building());
  const [isEditing, setEditing] = useState(false);
  const [isCreating, setCreating] = useState(false);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | undefined>(undefined);

  const saveBuilding = (building: Building) => {
    console.log(building);
    buildingAPI
      .update(building)
      .then((updatedBuildings) => {
        let updatedBuilding = buildings.map((b: Building) => {
          return b.id === building.id ? new Building(updatedBuildings) : b;
        });
        setBuildings(updatedBuildings);
      })
      .catch((e) => {
        if (e instanceof Error) {
          setError(e.message);
        }
      });
  };

  const createBuilding = (building: Building) => {
    console.log(building);
    buildingAPI
      .create(building)
      .then((updatedBuildings) => {
        let updatedBuilding = buildings.map((b: Building) => {
          return b.id === building.id ? new Building(updatedBuildings) : b;
        });
        setBuildings(updatedBuildings);
      })
      .catch((e) => {
        if (e instanceof Error) {
          setError(e.message);
        }
      });
  };

  const deleteBuilding = (building: Building) => {
    buildingAPI
      .delete(building)
      .then((updatedBuildings) => {
        let updatedBuilding = buildings.map((b: Building) => {
          return b.id === building.id ? new Building(updatedBuildings) : b;
        });
        setBuildings(updatedBuildings);
      })
      .catch((e) => {
        if (e instanceof Error) {
          setError(e.message);
        }
      });
  };

  const deleteAll = () => {
    buildingAPI.deleteAll().catch((e) => {
      if (e instanceof Error) {
        setError(e.message);
      }
    });
  };

  const handleEditClick = () => {
    setEditing((isEditing) => !isEditing);
  };

  const handleCreateClick = () => {
    setCreating((isCreating) => !isCreating);
  };

  const setSelected = (building: Building) => {
    setCurrentBuilding(building);
  };

  useEffect(() => {
    async function loadEmployees() {
      setLoading(true);
      try {
        const data = await buildingAPI.get(1);
        setError("");
        setBuildings(data);
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

  if (isEditing) {
    return (
      <Fragment>
        <BuildingForm
          onSubmit={saveBuilding}
          onCancel={handleEditClick}
          building={currentBuilding}
        />
      </Fragment>
    );
  }

  if (isCreating) {
    return (
      <Fragment>
        <BuildingForm
          onSubmit={createBuilding}
          onCancel={handleCreateClick}
          building={new Building({"address": "Oleg", "rentDate": "2002-12-12", "area": 20})}
        />
      </Fragment>
    );
  }

  if (!isEditing && !isCreating) {
    return (
      <Fragment>
        <h1>Buildings</h1>
        <BuildingTable buildings={buildings} onSelectItem={setSelected} />
        <button className="btn btn-success" onClick={handleCreateClick}>
          Add new
        </button>
        <button className="btn btn-primary" onClick={handleEditClick}>
          Edit Selected
        </button>
        <button
          className="btn btn-danger"
          onClick={() => deleteBuilding(currentBuilding)}
        >
          Delete Selected
        </button>
        <button className="btn btn-dark" onClick={deleteAll}>
          Delete All
        </button>
      </Fragment>
    );
  }
}

export default BuildingPage;
