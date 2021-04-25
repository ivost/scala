
// val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))
val fruit = "apples" :: "oranges" :: "pears" :: Nil

val nums = List(5, 10, 2, 1)
//////
// insertion sort
def insert(x: Int, xs: List[Int]): List[Int] =
  if (xs.isEmpty || x <= xs.head) x :: xs
  else xs.head :: insert(x, xs.tail)

def sort(xs: List[Int]): List[Int] =
  if (xs.isEmpty) Nil
  else insert(xs.head, sort(xs.tail))
////
sort(nums)





