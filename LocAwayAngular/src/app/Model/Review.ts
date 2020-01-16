import {Accomodation} from "./Accomodation";
import {User} from "./User";

export class Review {

  public id: number;
  public version: number;
  public text: string;
  public grade: number;

  public accomodation: Accomodation;

  public user: User;


  constructor(id: number, version: number, text: string, grade: number, accomodation: Accomodation, user: User) {
    this.id = id;
    this.version = version;
    this.text = text;
    this.grade = grade;
    this.accomodation = accomodation;
    this.user = user;
  }
}

