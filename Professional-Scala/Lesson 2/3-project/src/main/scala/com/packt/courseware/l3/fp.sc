
val a="1 2 3 4".split(' ').toList.map(_.toInt)
val b = List(2, 4, 8)
a.take(2).sum
b.take(3).sum
val n = 3
def rep(n:Int, a:Int):List[Int] = List.fill(n)(a)
rep(n, 2)
b.flatMap(x => rep(n, x))

b.flatMap(x => List.fill(n)(x))
