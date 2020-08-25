package kjd

fun main(args:Array<String>){
//    println("Hello World")
//
//    var x: Int = 10 //mutable
//    val y: Int = 10 //like final in Java, immutable
//    var z = 10 //type inference. Kotlin is statically typed, It's not dynamic typed as Javascript

    var p1 = Point(1, 1)
    var p2 = PointJ(2, 2)

    println(p1.x)
    println(p1.y)

    println(p2.x)
    println(p2.y)
}