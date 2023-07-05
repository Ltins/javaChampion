export class Building {
  id: number | undefined;
  address: string | undefined;
  rentDate: string | undefined;
  area: number | undefined;
  get isNew(): boolean {
    return this.id === undefined;
  }

  constructor(initializer?: any) {
    if (!initializer) return;
    if (initializer.id) this.id = initializer.id;
    if (initializer.address) this.address = initializer.address;
    if (initializer.rentDate) this.rentDate = initializer.rentDate;
    if (initializer.area) this.area = initializer.area;
  }
}
