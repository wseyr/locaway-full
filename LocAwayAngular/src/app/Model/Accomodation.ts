import {User} from "./User";
import {Option} from "./Option";
import {Review} from "./Review";
import {Booking} from "./Booking";
import {Photo} from "./Photo";
import {CustomPriceDay} from "./CustomPriceDay";
import {PointOfInterest} from "./PointOfInterest";
import {Bookmark} from "./Bookmark";

export class Accomodation {
  private id: number;
  private version: number;
  private name: string;
  private number: string;
  private street: string;
  private city: string;
  private postcode: string;
  private country: string;
  private latitudeDeg: number;
  private longitudeDeg: number;
  private description: string;
  private numberOfRooms: number;
  private maxPersons: number;
  private isDeleted: boolean;

  private accomodationType: string; //TODO: Gérer l'enum
  private defaultBasePrice: number;
  private defaultPersonPrice: number;

  private customPriceDays: Array<CustomPriceDay>;

  private bookmarks: Array<Bookmark>;

  private reviews: Array<Review>;

  private photos: Array<Photo>;

  private bookings: Array<Booking>;

  private options: Array<Option>;

  private pointOfInterests: Array<PointOfInterest>;

  private user: User;


  constructor(id: number, version: number, name: string, number: string, street: string, city: string, postcode: string, country: string, latitudeDeg: number, longitudeDeg: number, description: string, numberOfRooms: number, maxPersons: number, isDeleted: boolean, accomodationType: string, defaultBasePrice: number, defaultPersonPrice: number, customPriceDays: Array<CustomPriceDay>, bookmarks: Array<Bookmark>, reviews: Array<Review>, photos: Array<Photo>, bookings: Array<Booking>, options: Array<Option>, pointOfInterests: Array<PointOfInterest>, user: User) {
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
