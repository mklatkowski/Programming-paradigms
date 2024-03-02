(* HELPER FUNCTIONS *)


  let rec stringToCharList s =
    let rec helper (s, it) =
      match String.get s it with
      | exception (Invalid_argument s) -> []
      | _ -> String.get s it::helper(s, it+1)
    in helper(s,0)
  ;;


  let head list =
    match list with 
    |[] -> ' '
    |head::tail -> head
  ;;

(* EX 0 *)


let log = fun prefix -> fun datetime -> fun text -> print_string ("[" ^ prefix ^ "] " ^ datetime ^ " " ^ text);;
log "cos" "cos" "cos";;

(* EX 1-3 *)

let rec filter (list, predicate) =
   match list with
   |[] -> []
   |head::tail -> if predicate(head) then head::filter(tail, predicate) else filter(tail, predicate)
;;

let rec map (list, func) =
  match list with
  |[] -> []
  |head::tail -> func(head) :: map(tail, func)
;;
let rec reduce (list, operator, acc) =
  match list with
  |[] -> acc
  |head::tail -> operator(head, reduce(tail, operator, acc))
;;  


(* EX 4-6 *)

let lowerThanSumOfWholeList list =
  let sumOperator (a,b) = a+b in 
  let sumOfList listInner = reduce(listInner, sumOperator, 0) in
  let square a = a*a in 
  let rec mapToSquare list = map(list, square) in
  filter(mapToSquare(list), fun a -> a<=sumOfList(list))
;;

lowerThanSumOfWholeList [1;2;100];;

let average list =
  let operatorSum (a,b) = a+.b in
  let count (a, listLength) = listLength+.1. in
  reduce(list, operatorSum, 0.)/. reduce(list, count, 0.)
;;

average([1.;2.5;3.]);;

(* ACRONYM EXCERCISE  *)

let operatorReduce (a,b) = if a = ' ' then b else ' ';; 

let rec reduceToAcronym (sentence, operator, acc) =
  match sentence with
  |[] -> []
  |[head] -> acc
  |head1::head2::tail -> reduceToAcronym(head2::tail, operator, acc @ [operator(head1,head2)])
;;

let acronym sentence = 
  let deleteSpaces a = a<>' ' in 
  filter(reduceToAcronym(stringToCharList(sentence), operatorReduce, [head(stringToCharList(sentence))]), deleteSpaces);;

acronym "Politechnika Wrocławska";;