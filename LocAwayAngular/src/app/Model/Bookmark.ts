import {User} from "./User";
import {Accomodation} from "./Accomodation";

export class Bookmark{
  private id: number;
  private version: number;
  private user: User;
  private accomodation: Accomodation;


  constructor(id: number, version: number, user: User, accomodation: Accomodation) {
    this.id = id;
    this.version = version;
    this.user = user;
    this.accomodation = accomodation;
  }
}
