fun main() {
//    println("Hello World!")
    println("What's your name?")
    val name = readLine()
    println("Hello, $name!")
//    println("Hello World!")
}

fun vulnerableFunction() {
    val password = "password" // Vulnerability - hardcoded password
    if (!password.isBlank())println("null password!")
}

// Code Smell - Empty function
fun emptyFunction() {
}

fun buggyFunction(str: String){
    if (str == "hello"){
        println("Hello!")
    } else if (str == "goodbye"){
        println("Goodbye!")
    } else if (str == "hello"){ // Bug - Duplicate condition
        println("Hello again!")
    }
}
