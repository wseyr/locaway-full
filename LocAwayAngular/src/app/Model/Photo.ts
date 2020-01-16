import {Accomodation} from "./Accomodation";

export class Photo {
  private id: number;
  private version: number;
  private path: string;
  private isMainPhoto: boolean;

  private accomodation: Accomodation;


  constructor(id: number, version: number, path: string, isMainPhoto: boolean, accomodation: Accomodation) {
    this.id = id;
    this.version = version;
    this.path = path;
    this.isMainPhoto = isMainPhoto;
    this.accomodation = accomodation;
  }
}
