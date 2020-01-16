import {User} from "./User";
import {Accomodation} from "./Accomodation";

export class Bookmark{
  public id: number;
  public version: number;
  public user: User;
  public accomodation: Accomodation;


  constructor(id: number, version: number, user: User, accomodation: Accomodation) {
    this.id = id;
    this.version = version;
    this.user = user;
    this.accomodation = accomodation;
  }
}
