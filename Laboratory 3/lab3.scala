@main def main() =

  println("Zadanie 1: ")
  println(lab21(List(1,4,7,6)))
  println(lab21(List()))
  println()

  println("Zadanie 2: ")
  println(lab22(List()))
  println(lab22(List(3)))
  println(lab22(List(4,5)))
  println(lab22(List(1,2,3,4,5,6)))
  println()

  println("Zadanie 3: ")
  println(lab23(List()))
  println(lab23(List(1,2,3)))
  println()

  println("Zadanie 4: ")
  println(lab24(List()))
  println(lab24(List(5)))
  println(lab24(List(5,7,8)))
  println()

  println("Zadanie 5: ")
  println(lab25("kajak"))
  println(lab25("cokolwiek"))
  println()

  println("Zadanie 6: ")
  println(lab26(List()))
  println(lab26(List(1,2,3,4)))
  println(lab26(List(3,3,3,3)))
  println(lab26(List(6)))
  println(lab26(List(1,2,2,2,3,3,5,5,6,6)))
  println()

  println("Zadanie 7: ")
  println(lab27(List()))
  println(lab27(List(1)))
  println(lab27(List(1,5,7,8)))
  println()

  println("Zadanie 8:")
  println(lab28(1))
  println(lab28(11))
  println(lab28(6))
  println(lab28(17))


def lab21(list: List[Any]) : Option[Any] =
  list match {
    case Nil => None
    case head::Nil => Some(head)
    case _::tail => lab21(tail)
  }

def lab22(list: List[Any]) : Option[List[Any]] =
  list match{
    case Nil => None
    case head:: Nil => None
    case head:: elem2 :: Nil => Some(List(head, elem2))
    case head :: elem2 :: tail => lab22(elem2::tail)
  }

def lab23(list: List[Any]): Int =
  list match
    case Nil => 0
    case head :: tail => lab23(tail) + 1

def lab24(list: List[Any]) : List[Any] =
  def helper(list: List[Any],result: List[Any]) : List[Any] =
    list match
      case Nil => List()
      case head :: Nil => head :: result
      case head :: tail => helper(tail, result) ::: List(head)
  helper(list, List.empty)

def lab25(word: String) : Boolean =
  if word.toList == lab24(word.toList) then true else false

def lab26(list: List[Any]) : List[Any] =
  def helper(list: List[Any], result: List[Any]) : List[Any] =
    list match
      case Nil => result
      case head :: tail =>
        val result_temp = helper(tail, result)
        if !contains(tail, head) then head :: result_temp else result_temp
  helper(list, List.empty)

def lab27(list: List[Any]): List[Any] =
  def helper(list: List[Any], counter: Int, result: List[Any]) : List[Any] =
    if counter%2==0 then
      list match
        case Nil => List()
        case head :: Nil => head :: result
        case head:: tail => head :: helper(tail, counter+1, result)


    else
      list match
        case Nil => List()
        case head :: Nil => result
        case head :: tail => helper(tail, counter + 1, result)


  helper(list, 0, List.empty)

def lab28(number: Int) : Boolean =
  if number < 2 then return false
  if number == 2 then true
  else
    def helper(number: Int, toDivideBy: Int): Boolean =
      if toDivideBy == number then return true
      if number % toDivideBy == 0 then false else helper(number, toDivideBy + 1)
    helper(number, 2)

def contains(list: List[Any], elem: Any) : Boolean =
  list match
    case Nil => false
    case head :: tail => if head == elem then true else contains(tail, elem)

