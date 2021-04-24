

val A = Array[Int](1, 2, 3,4,5)


A.to(Vector)
A.to(Set)

/*
Using .view before the map/
slice transformation operations defers the actual
traversal and creation of a new collection until later,
when we call .to to convert it back into a concrete collection type:
 */

A.map(_+1).filter(_%2==0).slice(1,3)

A.view.map(_+1).filter(_%2==0).slice(1,3).to(Array)

val v = Vector(1, 2, 3, 4, 5)
val v1 = v.updated(2, 10)

val v2 = v :+ 1
val v3 = 4 +: v
val v4 = v.tail
v.head

/*
ArrayDeques are general-purpose mutable, linear collections
that provide efficient O(1) indexed lookups,
O(1) indexed updates, and O(1) insertion and removal
at both left and right ends:
 */
val q = collection.mutable.ArrayDeque(1, 2, 3, 4, 5)

q.removeHead()
q.removeLast()
q.append(7)


