import {Accomodation} from "./Accomodation";

export class Option {
  private id: number;
  private version: number;
  private name: string;
  private isRule: boolean;

  private accomodations: Array<Accomodation>;


  constructor(id: number, version: number, name: string, isRule: boolean, accomodations: Array<Accomodation>) {
    this.id = id;
    this.version = version;
    this.name = name;
    this.isRule = isRule;
    this.accomodations = accomodations;
  }
}
