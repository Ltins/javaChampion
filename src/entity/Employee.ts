export class Employee {
  id: number | undefined;
  name: string = "";
  hireDate: string = "";
  salary: number | undefined;
  jobTitle: string = "";
  buildingAddress: string = "";
  get isNew(): boolean {
    return this.id === undefined;
  }

  constructor(initializer?: any) {
    if (!initializer) return;
    if (initializer.id) this.id = initializer.id;
    if (initializer.name) this.name = initializer.name;
    if (initializer.hireDate) this.hireDate = initializer.hireDate;
    if (initializer.salary) this.salary = initializer.salary;
    if (initializer.jobTitle) this.jobTitle = initializer.jobTitle;
    if (initializer.buildingAddress)
      this.buildingAddress = initializer.buildingAddress;
  }
}
