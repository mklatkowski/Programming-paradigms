
(* ZADANIE 1  *)
let rec stirlin (n,m) =
  match (n,m) with
  |(_,0) -> 0
  |(0,_) -> 0
  |(_,1) -> 1
  |(n,m) -> if n=m then 1 else stirlin(n-1, m-1) + m*stirlin(n-1,m);;
stirlin (5,3);;  


let memoized_stirlin(x,y) = 
  let rec memoized_stirlin_helper(n, m, hashMap) =
    let checkHashTable(key, hashMap) = 
      match key with
      |(a,b) -> if Hashtbl.mem hashMap (key) then Hashtbl.find (hashMap) key else (
        Hashtbl.add hashMap (a,b) (memoized_stirlin_helper(a,b,hashMap));
        Hashtbl.find hashMap key) in
    match (n,m) with
    |(n,m) when n<=0||m<=0 ->(
      Hashtbl.add hashMap (n,m) 0;
      Hashtbl.find hashMap (n,m);
    )
    |(n,1) ->(
      Hashtbl.add hashMap (n,1) 1;
      Hashtbl.find hashMap (n,1));
    |(n,m) when n=m -> 
        Hashtbl.add hashMap (n,m) 1;
        Hashtbl.find hashMap (n,m);
    |(n,m) -> checkHashTable((n-1,m-1), hashMap) + m*checkHashTable((n-1,m), hashMap) in memoized_stirlin_helper(x,y,Hashtbl.create 1000);;

memoized_stirlin(5,3);;


(* ZADANIE 2
    *)
let make_memoize func = 
  let hashTable = Hashtbl.create 10000 in
  let fun_result x =
    if Hashtbl.mem hashTable x then Hashtbl.find hashTable x else (
      Hashtbl.add hashTable x (func x);
      Hashtbl.find hashTable x
    )
  in fun_result;;

let rec fib n = 
  if n < 1 then failwith"error" else
  if n = 1 then 1 else
  if n = 2 then 1 else fib(n-2) + fib(n-1)  

let fun_test = make_memoize fib;;

fib 40;;
fib 40;;

fun_test 40;;
fun_test 40;;


(* ZADANIE 4 *)

type 'a mylist=Nil|Cons of 'a* 'a mylist;;
type 'a sequence=Cons of 'a *(unit->'a sequence);;

let bell n = 
  let rec helper(m,k,result) =
    if k=n then result else helper(n, k+1, result+memoized_stirlin(n,k)) in
  helper(n, 0, 0);;

let rec bellStream n = Cons(bell n, fun()->bellStream(n+1));;

let rec from n=Cons(n,fun()->from (n + 1));;

let stream_head str =
  match str with
  |Cons(x, _) -> x;;

let stream_tail str =
  match str with
  |Cons(_,tl) -> tl;;  

let rec listOf (n, str) =
  if n=0 then [] else stream_head str::listOf(n-1, stream_tail str());;

listOf(10, from 4);;
let listOfEven(n, str) = 
  let rec helper(k, str) = 
    if k=0 then [] else (
      if k mod 2 = 0 then helper(k-1, stream_tail str()) else stream_head str::helper(k-1, stream_tail str())
    ) in 
  helper(2*n, str);;

listOfEven(6, from 4);;  

let rec streamWithout(n, str) = 
  if n<0 then failwith "error" else
  if n = 0 then str else streamWithout(n-1, stream_tail str());;

listOf (6, streamWithout (5, from 4));;

let rec zip (n, str1, str2) =
  if n<0 then failwith "error" else
  if n = 0 then [] else  (stream_head str1, stream_head str2) :: zip(n-1, stream_tail str1(), stream_tail str2());;

zip(5, from 4, from 5);;  

let rec mapStream (func, str) = Cons(func(stream_head str), fun() -> mapStream(func, stream_tail str()));;

let fun1 a = a*a;;
listOf(4, mapStream(fun1, from 4));;