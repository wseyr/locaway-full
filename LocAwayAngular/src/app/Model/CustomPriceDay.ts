import {Accomodation} from "./Accomodation";

export class CustomPriceDay {

  private id: number;
  private version: number;
  private basePrice: number;
  private personPrice: number;
  private date: Date;

  private accomodation: Accomodation;


  constructor(id: number, version: number, basePrice: number, personPrice: number, date: Date, accomodation: Accomodation) {
    this.id = id;
    this.version = version;
    this.basePrice = basePrice;
    this.personPrice = personPrice;
    this.date = date;
    this.accomodation = accomodation;
  }
}
