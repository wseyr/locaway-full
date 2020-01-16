import {Accomodation} from "./Accomodation";

export class PointOfInterest {

  public accomodations: Array<Accomodation>;

  public id: number;
  public version: number;
  public name: string;
  public description: string;
  public number: string;
  public street: string;
  public city: string;
  public postcode: string;
  public country: string;
  public latitudeDeg: number;
  public longitudeDeg: number;


  constructor(accomodations: Array<Accomodation>, id: number, version: number, name: string, description: string, number: string, street: string, city: string, postcode: string, country: string, latitudeDeg: number, longitudeDeg: number) {
    this.accomodations = accomodations;
    this.id = id;
    this.version = version;
    this.name = name;
    this.description = description;
    this.number = number;
    this.street = street;
    this.city = city;
    this.postcode = postcode;
    this.country = country;
    this.latitudeDeg = latitudeDeg;
    this.longitudeDeg = longitudeDeg;
  }
}
