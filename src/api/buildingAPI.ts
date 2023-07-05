import { Building } from "../entity/Building";
const baseUrl = "http://localhost:8080";
const url = `${baseUrl}/buildings`;

function translateStatusToErrorMessage(status: number) {
  switch (status) {
    case 401:
      return "Please login again.";
    case 403:
      return "You do not have permission to view the building(s).";
    default:
      return "There was an error retrieving the building(s). Please try again.";
  }
}

function checkStatus(response: any) {
  if (response.ok) {
    return response;
  } else {
    const httpErrorInfo = {
      status: response.status,
      statusText: response.statusText,
      url: response.url,
    };
    console.log(`log server http error: ${JSON.stringify(httpErrorInfo)}`);

    let errorMessage = translateStatusToErrorMessage(httpErrorInfo.status);
    throw new Error(errorMessage);
  }
}

function parseJSON(response: Response) {
  return response.json();
}

function delay(ms: number) {
  return function (x: any): Promise<any> {
    return new Promise((resolve) => setTimeout(() => resolve(x), ms));
  };
}

function convertToBuildingModels(data: any[]): Building[] {
  let employees: Building[] = data.map(convertToBuildingModel);
  return employees;
}

function convertToBuildingModel(item: any): Building {
  return new Building(item);
}

const buildingAPI = {
  update(building: Building) {
    return fetch(`${url}/${building.id}`, {
      method: "PUT",
      body: JSON.stringify(building),
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then(checkStatus)
      .then(parseJSON)
      .catch((error: TypeError) => {
        console.log("log client error " + error);
        throw new Error(
          "There was an error updating the building. Please try again."
        );
      });
  },

  create(building: Building) {
    return fetch(`${url}`, {
      method: "POST",
      body: JSON.stringify(building),
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then(checkStatus)
      .then(parseJSON)
      .catch((error: TypeError) => {
        console.log("log client error " + error);
        throw new Error(
          "There was an error creating the building. Please try again."
        );
      });
  },

  delete(building: Building) {
    return fetch(`${url}/${building.id}`, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then(checkStatus)
      .then(parseJSON)
      .catch((error: TypeError) => {
        console.log("log client error " + error);
        throw new Error(
          "There was an error updating the building. Please try again."
        );
      });
  },

  deleteAll() {
    return fetch(`${url}`, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then(checkStatus)
      .then(parseJSON)
      .catch((error: TypeError) => {
        console.log("log client error " + error);
        throw new Error(
          "There was an error updating the building. Please try again."
        );
      });
  },

  get(page = 1, limit = 20) {
    return fetch(`${url}?_page=${page}&_limit=${limit}&_sort=name`)
      .then(delay(600))
      .then(checkStatus)
      .then(parseJSON)
      .then(convertToBuildingModels)
      .catch((error: TypeError) => {
        console.log("log client error " + error);
        throw new Error(
          "There was an error retrieving the buildings. Please try again."
        );
      });
  },
};

export { buildingAPI };
