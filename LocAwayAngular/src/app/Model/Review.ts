import {Accomodation} from "./Accomodation";
import {User} from "./User";

export class Review {

  private id: number;
  private version: number;
  private text: string;
  private grade: number;

  private accomodation: Accomodation;

  private user: User;


  constructor(id: number, version: number, text: string, grade: number, accomodation: Accomodation, user: User) {
    this.id = id;
    this.version = version;
    this.text = text;
    this.grade = grade;
    this.accomodation = accomodation;
    this.user = user;
  }
}

