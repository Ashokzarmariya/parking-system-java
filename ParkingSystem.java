
class Vehical {
 String name;
 String color;
 String type;

 Vehical(String name, String color, String type) {
  this.name = name;
  this.color = color;
  this.type = type;
 }
}

class Bike extends Vehical {

 public String fule;

 Bike(String name, String color, String type, String fule) {
  super(name, color, type);
  this.fule = fule;

 }

}

class Slot {
 int slotNumber;
 boolean isBooked;

 Slot(int slotNumber) {

  this.slotNumber = slotNumber;
 }
}

class Spot {
 String spotType;
 int spotNumber;
 int numberOfSlot;
 Slot[] slots;

 Spot(String spotType, int spotNumber, int numberOfSlot) {
  this.spotType = spotType;
  this.spotNumber = spotNumber;
  this.numberOfSlot = numberOfSlot;

  Slot[] arr = new Slot[numberOfSlot];
  for (int i = 0; i < numberOfSlot; i++) {
   arr[i] = new Slot(i + 1);
  }
  this.slots = arr;
 }
}

class Floor {
 int numberOfSpot;
 int floorNumber;
 Spot[] spot;

 Floor(int numberOfSpot, int floorNumber, int numberOfSlot) {
  this.numberOfSpot = numberOfSpot;
  this.floorNumber = floorNumber;

  Spot[] arr = new Spot[numberOfSpot];
  int carSpot = (numberOfSpot / 2);

  String spotType;

  for (int i = 0; i < numberOfSpot; i++) {
   
   if (i < carSpot)
    spotType = "carSpot";
   else
    spotType = "bikeSpot";

   Spot temp = new Spot(spotType, i+1, numberOfSlot);
   arr[i] = temp;
  }
  this.spot = arr;
 }

}

class Ticket {

 String slotType;
 int slotNumber;
 int floorNumber;
 int spotNumber;

 Ticket(String slotType, int slotNumber, int floorNumber, int spotNumber) {
  this.slotType = slotType;
  this.slotNumber = slotNumber;
  this.floorNumber = floorNumber;
  this.spotNumber = spotNumber;
 }
}

class Building {
 int numberOfFloor;
 Floor[] floor;

 Building(int numberOfFloor, int numberOfSpot, int numberOfSlot) {

  this.numberOfFloor = numberOfFloor;
  Floor[] arr = new Floor[numberOfFloor];

  for (int i = 0; i < numberOfFloor; i++) {
   int floor = i + 1;
   Floor temp = new Floor(numberOfSpot, floor, numberOfSlot);
   arr[i] = temp;
  }
  this.floor = arr;
 }

 public Ticket bookSlot(String slotType) {
  System.out.println("slot is not avalable");
  for (int i = 0; i < numberOfFloor; i++) {
   for (int j = 0; j < floor[i].numberOfSpot; j++) {
    if (floor[i].spot[j].spotType == slotType) {
     for (int k = 0; k < floor[i].spot[j].numberOfSlot; k++) {
      if (!floor[i].spot[j].slots[k].isBooked) {
       System.out.println();
       Ticket ticket = new Ticket(floor[i].spot[j].spotType, floor[i].spot[j].slots[k].slotNumber,
         floor[i].floorNumber, floor[i].spot[j].spotNumber);
       floor[i].spot[j].slots[k].isBooked = true;
       return ticket;
      }
     }
    }
    

   }
  }
  return null;
 }

}

public class ParkingSystem {
 public static void main(String[] arg) {
  Bike bike1 = new Bike("bike1", "red", "two wheeler", "petrol");
  Vehical car1 = new Vehical("car1", "blue", "four wheeler");

  // create building
  Building building1 = new Building(4, 5, 5);

  Ticket ticket1 = building1.bookSlot("bikeSpot");
  Ticket ticket3 = building1.bookSlot("bikeSpot");
  Ticket ticket4 = building1.bookSlot("bikeSpot");
  Ticket ticket5 = building1.bookSlot("bikeSpot");
  Ticket ticket6 = building1.bookSlot("bikeSpot");

  Ticket ticket7 = building1.bookSlot("bikeSpot");
  Ticket ticket8 = building1.bookSlot("bikeSpot");
  Ticket ticket30 = building1.bookSlot("bikeSpot");
  Ticket ticket40 = building1.bookSlot("bikeSpot");
  Ticket ticket50 = building1.bookSlot("bikeSpot");

  Ticket ticket60 = building1.bookSlot("bikeSpot");
  Ticket ticket70 = building1.bookSlot("bikeSpot");
  Ticket ticket80 = building1.bookSlot("bikeSpot");
  Ticket ticket2 = building1.bookSlot("bikeSpot");
  

  System.out.println("congratulation you got slot " + ticket1.slotNumber + " slotType - " + ticket1.slotType +" " + ticket1.spotNumber +
     " Floor Number - " + ticket1.floorNumber);
  if (ticket2 != null) {
   System.out.println("congratulation you got slot " + ticket8.slotNumber + " slotType - " + ticket8.slotType +" " + ticket8.spotNumber
     + " Floor Number - " + ticket8.floorNumber);
  } else
   System.out.println("sorry no slots available");


 
 }
}