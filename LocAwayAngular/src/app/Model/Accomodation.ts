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


  constructor(id?: number, version?: number, name?: string, number?: string, street?: string, city?: string, postcode?: string, country?: string, latitudeDeg?: number, longitudeDeg?: number, description?: string, numberOfRooms?: number, maxPersons?: number, isDeleted?: boolean, accomodationType?: string, defaultBasePrice?: number, defaultPersonPrice?: number, customPriceDays?: Array<CustomPriceDay>, bookmarks?: Array<Bookmark>, reviews?: Array<Review>, photos?: Array<Photo>, bookings?: Array<Booking>, options?: Array<Option>, pointOfInterests?: Array<PointOfInterest>, user?: User) {
    this.id = id;
    this.version = version;
    this.name = name;
    this.number = number;
    this.street = street;
    this.city = city;
    this.postcode = postcode;
    this.country = country;
    this.latitudeDeg = latitudeDeg;
    this.longitudeDeg = longitudeDeg;
    this.description = description;
    this.numberOfRooms = numberOfRooms;
    this.maxPersons = maxPersons;
    this.isDeleted = isDeleted;
    this.accomodationType = accomodationType;
    this.defaultBasePrice = defaultBasePrice;
    this.defaultPersonPrice = defaultPersonPrice;
    this.customPriceDays = customPriceDays;
    this.bookmarks = bookmarks;
    this.reviews = reviews;
    this.photos = photos;
    this.bookings = bookings;
    this.options = options;
    this.pointOfInterests = pointOfInterests;
    this.user = user;
  }
}
