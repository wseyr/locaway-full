import {Accomodation} from "./Accomodation";

export class Option {
  public id: number;
  public version: number;
  public name: string;
  public isRule: boolean;

  public accomodations: Array<Accomodation>;


  constructor(id: number, version: number, name: string, isRule: boolean, accomodations: Array<Accomodation>) {
    this.id = id;
    this.version = version;
    this.name = name;
    this.isRule = isRule;
    this.accomodations = accomodations;
  }
}
