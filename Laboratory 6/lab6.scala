import scala.collection.mutable

@main def main() =
  println(1);
//  println(stirlin(50,22))
//  println(memoized_stirling(50,22, mutable.HashMap.empty[List[Int], Int]))
//  println(fib(50))
//  println(fib_memo(50))



//ZADANIE 1

def stirlin(n: Int, m: Int) : Int =
  (n,m) match
    case (_, 1) => 1
    case (n, m) =>
      if n==m then 1 else stirlin(n-1, m-1) + m*stirlin(n-1, m)


def memoized_stirling(n:Int, m:Int, hashMap: mutable.HashMap[List[Int], Int]): Int =

  def checkHashTable(key: List[Int], hashMap: mutable.HashMap[List[Int], Int]): Int =
    key match
      case List(n,m) =>
        if hashMap.contains(key) then hashMap(key) else
          hashMap.addOne(key, memoized_stirling(n, m, hashMap))
          hashMap(key)
      case List(_*) => 0
  (n,m) match
    case(n,1) =>
      hashMap.addOne(List(n,1), 1)
      hashMap(List(n,1))
    case(n,m) =>
      if n==m then
        hashMap.addOne(List(n,m), 1)
        hashMap(List(n,m))
      else checkHashTable(List(n-1, m-1), hashMap) + m*checkHashTable(List(n-1,m), hashMap)

//ZADANIE 2


def memoized_function[A,B](func: A => B): A=>B =
  val hashMap = mutable.HashMap.empty[A,B]
  def func_result(x: A): B =
    if hashMap.contains(x) then hashMap(x) else
      hashMap.addOne(x, func(x))
      hashMap(x)
  func_result

def fib(n: Int): Int =
  if n<0 then throw new Exception("zly argument") else
  if n == 1 then 1 else
  if n == 2 then 1 else fib(n-2) + fib(n-1)

val fib_memo: Int => Int = memoized_function(fib)



