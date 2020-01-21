import {User} from "./User";
import {Option} from "./Option";
import {Review} from "./Review";
import {Booking} from "./Booking";
import {Photo} from "./Photo";
import {CustomPriceDay} from "./CustomPriceDay";
import {PointOfInterest} from "./PointOfInterest";
import {Bookmark} from "./Bookmark";

export class Accomodation {
  public id: number;
  public version: number;
  public name: string;
  public number: string;
  public street: string;
  public city: string;
  public postcode: string;
  public country: string;
  public latitudeDeg: number;
  public longitudeDeg: number;
  public description: string;
  public numberOfRooms: number;
  public maxPersons: number;
  public isDeleted: boolean;

  public accomodationType: string; //TODO: Gérer l'enum
  public defaultBasePrice: number;
  public defaultPersonPrice: number;

  public customPriceDays: Array<CustomPriceDay>;

  public bookmarks: Array<Bookmark>;

  public reviews: Array<Review>;

  public photos: Array<Photo>;

  public bookings: Array<Booking>;

  public options: Array<Option>;

  public pointOfInterests: Array<PointOfInterest>;

  public user: User;

  constructor() {


  }
}
