fun main() {
    val a: Int = 1
    val b: Int = 2
    println("a="+a)
    println("b="+b)
    println("a+b="+sum(a, b))

    val toyota = car("toyota", 1990)
    toyota.info()

    //Jos nullTest palauttaa tekstin "Hello Kotlin" tulostetaan se, mutta jos funktio palauttaa arvon null, tulostetaan 0
    println(nullTest() ?: 0)

    val greeting = "Hello"
    println(greeting.addExlamation())
}

fun sum (a: Int, b: Int): Int {
    return a + b
}

//Car-luokka
class car(val brand: String, val year: Int){
    fun info(){
        println("$brand, $year")
    }
}

//Funktio joka palauttaa joko tekstin "Hello Kotlin" tai arvon null
fun nullTest(): String?{
    var rand=(0..1).random()
    if (rand <= 0){
        return null
    }
    else{
        return "Hello Kotlin"
    }
}

fun String.addExlamation(): String{
    return this + "!"
}