@main def main() =

  println(distance((1,5),(4,9)))
  println(younger1(ps1))
  println(ps2.youngerV2())

  println(weekDayToString(nextDay(weekDay.Monday)))

  println(safeHead(List()))
  println(safeHead(List(1,2)))
  println(safeHead(List('a','b')))

  println(volume(solidFigure.Cuboid(4,5,6)))


//Zadanie 1

type point3d = (Float, Float)

def distance(p: point3d, q: point3d): Float =
  (p, q) match
    case ((x1, y1), (x2, y2)) => Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)).toFloat

// Zadanie 2 v1

type person1 = (String, String, Int, Int, Char)

val person11:person1 = ("Michał", "Klatkowski", 20, 43, 'M')
val person12:person1 = ("Jan", "Kowalski", 33, 42, 'M')

type partnership1 = (person1, person1)

val ps1: partnership1 = (person11, person12)

def younger1(ps: partnership1): person1 =
  ps match
    case (person1, person2) =>
      (person1, person2) match
        case ((_,_,age1,_,_), (_,_,age2,_,_)) => if age1<age2 then person1 else person2

//Zadanie 2 v2

class PersonV2(name: String, lastName: String, age: Int, shoeSize: Int, gender: Char):
  def getAge: Int = age
  override def toString: String = name +" " + lastName +" " +  age.toString + " " + shoeSize.toString +" " +  gender.toString
end PersonV2

class PartnershipV2(person1: PersonV2, person2: PersonV2):
  def youngerV2(): PersonV2 =
    if person1.getAge < person2.getAge then person1 else person2
end PartnershipV2


val person21: PersonV2 = PersonV2("Michał", "Klatkowski", 20, 43, 'M')
val person22: PersonV2 = PersonV2("Jan", "Kowalski", 33, 42, 'M')
val ps2: PartnershipV2 = PartnershipV2(person21, person22)


//Zadanie 3

enum weekDay():
  case Monday
  case Tuesday
  case Wednesday
  case Thursday
  case Friday
  case Saturday
  case Sunday

//sealed trait weekDay
//case object Monday extends weekDay
//case object Tuesday extends weekDay
//case object Wednesday extends weekDay
//case object Thursday extends weekDay
//case object Friday extends weekDay
//case object Saturday extends weekDay
//case object Sunday extends weekDay
//

def weekDayToString(wd: weekDay): String =
  wd match
    case weekDay.Monday => "Monday"
    case weekDay.Tuesday => "Tuesday"
    case weekDay.Wednesday => "Wednesday"
    case weekDay.Thursday => "Thursday"
    case weekDay.Friday => "Friday"
    case weekDay.Saturday => "Saturday"
    case weekDay.Sunday => "Sunday"

def nextDay(wd: weekDay): weekDay =
  wd match
    case weekDay.Monday => weekDay.Tuesday
    case weekDay.Tuesday => weekDay.Wednesday
    case weekDay.Wednesday => weekDay.Thursday
    case weekDay.Thursday => weekDay.Friday
    case weekDay.Friday => weekDay.Saturday
    case weekDay.Saturday => weekDay.Sunday
    case weekDay.Sunday => weekDay.Monday


//Zadanie 4
enum Maybe():
  case Nothing
  case Just(head: Any);


//sealed trait Maybe
//case object Nothing extends Maybe
//case class Some(a: Any) extends Maybe

def safeHead[A](list: List[A]): Maybe =
  list match
    case Nil => Maybe.Nothing
    case head::_ => Maybe.Just(head)


//Zadanie 5

//sealed trait solidFigure
//
//case class Cube(a: Float) extends solidFigure
//case class Cuboid(a: Float, b: Float, c:Float) extends solidFigure
//case class Cylinder(r: Float, h: Float) extends solidFigure
//case class Sphere(r: Float) extends solidFigure

enum solidFigure():
  case Cube(a: Float)
  case Cuboid(a: Float, b: Float, c:Float)
  case Cylinder(r: Float, h: Float)
  case Sphere(r: Float)

def volume(fig: solidFigure): Float =
  fig match
    case solidFigure.Cube(a) => a*a*a
    case solidFigure.Cuboid(a,b,c) => a*b*c
    case solidFigure.Sphere(r) => (4.0/3.0*r*r*r*Math.PI).toFloat
    case solidFigure.Cylinder(r,h) => (h*r*r*Math.PI).toFloat



