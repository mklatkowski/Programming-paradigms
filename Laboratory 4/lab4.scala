@main def main() =

  println(average(List(1,2,3,4,5,1)))
  println(lowerThanSumOfList(List(1,2,3,100)))
  println(acronym("zaklad ubezpieczen spolecznych"))


//EX 1-3

def filter[A](list: List[A], predicate: A => Boolean): List[A] =
  list match
    case Nil => List()
    case head::tail => if predicate(head) then head::filter(tail, predicate) else filter(tail, predicate)

def map[A](list: List[A], function: A => A): List[A] =
  list match
    case Nil => List()
    case head::tail => function(head) :: map(tail, function)

def reduce[A,B](list: List[B], operator: (B,A) => A, acc: A): A =
  list match
    case Nil => acc
    case head:: tail => operator(head, reduce(tail, operator, acc))

// EX 4-6


def lowerThanSumOfList(list: List[Int]): List[Int] =

  def sumOfList(listInner: List[Int]) = reduce(listInner, (a: Int, b: Int) => a+b, 0)
  def mapToSquares(list: List[Int]): List[Int] = map(list, (a:Int) => a*a)

  filter(mapToSquares(list), (a:Int) => a<=sumOfList(list))

def average(list: List[Double]): Double =

  def operatorSum(a: Double, b: Double) = a+b
  def count(a:Double, listLenght: Int): Int = listLenght+1
  reduce(list, operatorSum, 0) / reduce(list, count, 0)


// ACRONYM EXCERCISE

def deleteSpaces(a: Char) = a!= ' '

def acronym(sentence: String): String =
  filter(reduceToAcronym(sentence.toList, operatorReduce, List(head(sentence.toList))), deleteSpaces).mkString


def operatorReduce(a: Char, b: Char): Char =
  if a==' ' then b else ' '

def reduceToAcronym(sentence: List[Char], operator: (Char, Char) =>Char, acc: List[Char]): List[Char] =
  sentence match
    case Nil => Nil
    case _::Nil => acc
    case head1::head2::tail => reduceToAcronym(head2:: tail, operator, acc ::: List(operator(head1,head2)))

//HELPER FUNCTIONS

def head (list: List[Char]): Char =
  list match
    case Nil => ' '
    case head::_ => head

