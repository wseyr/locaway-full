import {Accomodation} from "./Accomodation";

export class CustomPriceDay {

  public id: number;
  public version: number;
  public basePrice: number;
  public personPrice: number;
  public date: Date;

  public accomodation: Accomodation;


  constructor(id: number, version: number, basePrice: number, personPrice: number, date: Date, accomodation: Accomodation) {
    this.id = id;
    this.version = version;
    this.basePrice = basePrice;
    this.personPrice = personPrice;
    this.date = date;
    this.accomodation = accomodation;
  }
}
