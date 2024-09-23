fun main() {
    days()
    shopping()
}

fun days(){
    println("Weekdays are:")
    val weekDays = listOf<String>("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    for (day in weekDays) {
        println(day)
    }
    println(" ")
}

fun shopping(){
    var shoppingList = mutableListOf<String>("cheese", "bread")
    var input: String = " "
    println("This is a shopping list")
    while (input != "0") {
        println(" ")
        println("What do you want to do?")
        println("1: Show shopping list")
        println("2: Add item")
        println("3: Remove item")
        println("4: Clear shopping list")
        println("0: Exit")
        input = readln()
        println(" ")
        when (input) {
            "0" -> println("Bye!")
            "1" -> {
                if(shoppingList.size == 0){
                    println("Shopping list is empty")
                }
                else {
                    println("Items in shopping list:")
                    for (item in shoppingList) {
                        println(item)
                    }
                }
            }
            "2"-> {
                print("Write item to add:")
                val item = readln()
                shoppingList.add(item)
                println("$item added")
            }
            "3"-> {
                print("Write item to remove: ")
                val item = readln()
                shoppingList.remove(item)
                println("$item removed")
            }
            "4"->{
                shoppingList.clear()
                println("Shopping list cleared")
            }

            else -> println("Invalid input")
        }
    }
}