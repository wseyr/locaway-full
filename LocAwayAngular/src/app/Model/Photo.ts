import {Accomodation} from "./Accomodation";

export class Photo {
  public id: number;
  public version: number;
  public path: string;
  public isMainPhoto: boolean;

  public accomodation: Accomodation;


  constructor(id?: number, version?: number, path?: string, isMainPhoto?: boolean, accomodation?: Accomodation) {
    this.id = id;
    this.version = version;
    this.path = path;
    this.isMainPhoto = isMainPhoto;
    this.accomodation = accomodation;
  }
}
