(* HELPER FUNCTIONS *)

let rec stringToCharList s =
  let rec helper (s, it) =
    match String.get s it with
    | exception (Invalid_argument s) -> []
    | _ -> String.get s it::helper(s, it+1)
  in helper(s,0)
;;    
let rec contains (list,elem) =
    match list with
    | [] -> false
    |head::tail -> if head = elem then true else contains(tail, elem)
;;


(* LAB 3  *)



let rec lab21 list =
    match list with
    | [] -> None
    | [head] -> Some(head)
    | head::tail -> lab21(tail)
  ;;

  lab21 [1;4;5;6];;
  lab21 [];;

let rec lab22 list =
    match list with
    | [] -> None
    | [head] -> None
    | [head1;head2] -> Some([head1; head2])
    | head1::head2::tail -> lab22(head2::tail)
  ;;

lab22 [];;
lab22 [3];;
lab22 [5;6];;
lab22 [6;8;2;4];;

let rec lab23 list =
  match list with
  | [] -> 0
  | head::tail -> lab23(tail) + 1
;;

lab23 [];;
lab23 [5;3;5];;

let rec lab24 list = 
  let rec helper (list,result) = 
    match list with
    | [] -> []
    | [head] -> head::result
    | head::tail -> helper(tail, result) @ [head]
  in helper(list, [])
;;

lab24 [];;
lab24 [5];;
lab24 [5;7;8];;
let lab25 s = 
  if stringToCharList s = lab24(stringToCharList s) then true else false;;

lab25 "cokolwiek";;
lab25 "kajak";;  
let rec lab26 list = 
  let rec helper(list, result) =
    match list with
    |[] -> result
    |head::tail -> if contains(tail, head) then helper(tail, result) else head::helper(tail, result)
  in helper(list, [])
;;

lab26 [1;2;3;4];;
lab26 [3;3;3;3];;
lab26 [6];;
lab26 [];;
lab26 [1;2;2;4;4;5;5;6;6];;

let rec lab27 list =
  let rec helper (list, counter, result) =
    if counter mod 2=0 then
      match list with
      | [] -> []
      | [head] -> head::result
      | head::tail -> head:: helper(tail, counter+1, result)
    else
      match list with
      | [] -> []
      | [head] -> result
      | head::tail -> helper(tail, counter+1, result)
    in helper(list, 0, [])    
  ;;

lab27 [];;
lab27 [1];;
lab27 [1;5;7;8];;
let rec lab28 number = 
  if number < 2 then false else
  if number = 2 then true else
  let rec helper (number, toDivideBy) =
      if toDivideBy = number then true else
      if number mod toDivideBy = 0 then false else helper(number, toDivideBy+1)
    in helper(number, 2)
  ;;  

lab28 1;;
lab28 8;;
lab28 11;;