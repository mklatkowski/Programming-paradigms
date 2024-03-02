(* ZAD 1 *)

module type POINT_3D = 
sig
  type point
  val distance: point * point-> float
end;;

module Point3d : POINT_3D = 
struct
  type point = PointInt of int*int*int | PointFloat of float*float*float
  let distance (p,q) = 
    match (p,q) with
    |(PointInt(x1,y1,z1) , PointInt(x2,y2,z2)) -> sqrt(Int.to_float((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)+(z1-z2)*(z1-z2)))
    |(PointFloat(x1,y1,z1) , PointFloat(x2,y2,z2)) -> sqrt((x1-.x2)*.(x1-.x2)+.(y1-.y2)*.(y1-.y2)+.(z1-.z2)*.(z1-.z2))
    |_ -> 0.0
  ;;
end;;

(* ZAD 2 *)

module type SEGMENT_3D = 
sig
  type segment
  val length: segment -> float
end;;

module Segment3d: SEGMENT_3D = 
struct
  type segment = Point3d.point * Point3d.point;;
  let length(s:segment) = 
    match s with
    |(p,q) -> Point3d.distance(p,q);
end

module type TRANSLATION = 
sig
  type translation
  type sumPointOrSegment
  val translate: translation * sumPointOrSegment -> sumPointOrSegment
end;;

module Translation: TRANSLATION = 
struct
  type translation = TransInt of int*int*int | TransFloat of float*float*float
  type sumPointOrSegment = SumPoint of Point3d.point | SumSegment of Segment3d.segment
  let translate((t: translation), (input: sumPointOrSegment)) = 
    match (t,input) with
    |(TransInt(a,b,c), Point3d.PointInt(x,y,z)) -> SumPoint(Point3d.PointInt(x+a, y+b, z+c))
    |(TransFloat(a,b,c), Point3d.PointFloat(x,y,z)) -> SumPoint(Point3d.PointFloat(x+.a, y+.b, z+.c))
    |(TransInt(a,b,c), Segment3d.Segment3d(Point3d.PointInt(x1,x2,x3), Point3d.PointInt(y1,y2,y3))) -> SumSegment(Segment3d(Point3d.point.PointInt(x1+a, x2+b, x3+c), Point3d.PointInt(y1+a,y2+b, y3+c)))
    |(TransFloat(a,b,c), Segment3d.Segment3d(Point3d.PointFloat(x1,x2,x3), Point3d.PointFloat(y1,y2,y3))) -> SumSegment(Segment3d(Point3d.PointFloat(x1+.a, x2+.b, x3+.c), Point3d.PointInt(y1+.a,y2+.b, y3+.c)))
  end;;

(* ZADANIE 3 *)

module type TREE = 
sig
  type 'a tree
  val addNode: 'a tree * 'a -> 'a tree
  val removeNode: 'a tree * 'a -> 'a tree
  val preorder: 'a tree ->  'a list
  val postorder: 'a tree ->  'a list
  val inorder: 'a tree ->  'a list
  val leafs: 'a tree -> 'a list
end;;

module TreeModule: TREE = 
struct
  type 'a tree = Empty | Node of 'a * 'a tree * 'a tree;;

  let rec addNode ((bt: 'a tree), (toAdd: 'a)) = 
    match bt with
    |Empty -> Node(toAdd, Empty, Empty)
    |Node(v,l,r) when v=toAdd -> failwith("Nie można dodać tego samego elementu")
    |Node(v,l,r) -> if toAdd<v then addNode(l, toAdd) else addNode(r,toAdd);;
  ;;

  let removeNode ((bt: 'a tree), (toRemove: 'a)) = 
    match bt with
    |Empty -> bt
    |Node(v,l,r) ->  
  ;;

  let rec preorder bt = 
    match bt with
    |Node(v,l,r) -> v::(preorder l) @ (preorder r)
    |Empty -> []
  ;;

  let rec inorder bt = 
    match bt with
    |Node(v,l,r) -> (inorder l) @ v :: (inorder r)
    |Empty -> []
  ;;

  let rec postorder bt = 
    match bt with
    |Node(v,l,r) -> (postorder r) @ (postorder r) @ [v]
    |Empty -> []
  ;;

  let rec leafs (bt: 'a tree) = 
    match bt with
    |Node(v, Empty, Empty) -> [v]
    |Node(v, l, r) -> (leafs l) @ (leafs r) 
    |Empty -> []

end;;



(* ZADANIE 4 *)

module Make_Point(p: POINT_3D) = 
struct
  let funcPoint(x,y,z) = p.Point3d.PointInt(x,y,z);;
end;;

module Make_Segment (p: POINT_3D) = 
struct
  let createSegment(point1: p.Point3d, point2: p.Point3d) = SEGMENT_3D.Segment3d.segment(point1, point2);;
end;;

