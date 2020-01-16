import {Accomodation} from "./Accomodation";

export class PointOfInterest {

  private accomodations: Array<Accomodation>;

  private id: number;
  private version: number;
  private name: string;
  private description: string;
  private number: string;
  private street: string;
  private city: string;
  private postcode: string;
  private country: string;
  private latitudeDeg: number;
  private longitudeDeg: number;


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
