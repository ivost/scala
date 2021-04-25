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
// currying
def sum(x: Int)(y: Int) = x + y
sum(2)(2)
val sum2 = sum(2) _
sum2(2)

// by-name params
var assertionsEnabled = true
def myAssert(predicate: () => Boolean) =
  if (assertionsEnabled && !predicate())
    throw new AssertionError

myAssert(() => 5 > 3)

def byNameAssert(predicate: => Boolean) =
  if (assertionsEnabled && !predicate)
    throw new AssertionError

byNameAssert(5 > 3)

abstract class Element {
  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length
}

class UniformElement(
                      ch: Char,
                      override val width: Int,
                      override val height: Int
                    ) extends Element {
  private val line = ch.toString * width

  def contents = Array.fill(height)(line)
}

/*
Composition and inheritance are two ways to define a new class
in terms of another existing class.
If what you're after is primarily code reuse,
you should in general prefer composition to inheritance.
Only inheritance suffers from the fragile base class problem,
in which you can inadvertently break subclasses
by changing a superclass.
 */







