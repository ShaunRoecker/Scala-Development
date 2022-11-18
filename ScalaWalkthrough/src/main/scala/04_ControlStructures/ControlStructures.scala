

object ControlStructures extends App {
  def scalaControlStructures(): Unit = {
        //  As their name implies, "control structures" provide a way for programmers to control
        // the flow of a program.  They're are a fundamental feature of programming languages that let
        // you handle decision making and looping tasks

        println("CONTRIOL STRUCTURES")

        // Control Structures in Scala:
            // 'for' loops and 'for' expressions
            // if/then/else 'if' expressions
            // 'match' expressions (pattern matching)
            // try/catch/finally blocks
            // while loops
        
        // controlStructureOverview()
        // loopingOverDataStructuresWithFor()
        // usingForLoopsWithMultipleCounters()
        // usingAForLoopWithEmbeddedIfStatements()
        // creatingANewCollectionFromAnExistingCollectionWithForYield()
        // usingTheIfConstructLikeATernaryOperator()
        // usingAMatchExpressionLikeASwitchStatement()
        // matchingMultipleConditionsWithOneCaseStatement()
        // assigningTheResultOfTheMatchExpressionToAVariable()
        accessingTheValueOfTheDefaultCaseInAMatchExpression()


    }
    scalaControlStructures()

    def controlStructureOverview(): Unit = {
                // 'for' loops and 'for' expressions
        // basic: loop through a collection to perform an operation on the elements of the collection
        for i <- List(1, 2, 3) do println(i)

        // for loops can also have "guards"- embedded if statements:
        for 
            i <- 1 to 10
            if i > 3
            if i < 6
        do
            println(i)
        
        // With the use of the "yield" keyword, for loops also become 'for' expressions - 
        // loops that yield a result:
        val listOfInts = for 
            i <- 1 to 30
            if i > 3
            if i < 6
        yield 
            i * 10

        println(listOfInts) // Vector(40, 50)

        // if/then/else-if Expressions
        // while for loops and expressions let you traverse over a collection, if/then/else expressions
        // provide a way to make branching decisions.

        //val absValue = if a < 0 then -a else a

        def compare(a: Int, b: Int): Int =
            if a < b then
                -1
            else if a == b then
                0
            else
                1
        end compare

        println(compare(2, 3)) // -1

        // As shown in both of those examples, an if expression truly is an expression that returns a value

        //  Matching Expressions and Pattern Matching
        // Pattern Matching are a defining feature of Scala and very powerful
        
        def isTrue(a: Matchable): Boolean = a match
            case false | 0 | "" => false
            case _ => true

        println(isTrue(0)) //false

        // ty/catch/finally blocks
        //
        // try
            // some exception-throwing code here
        // catch
            // case e1: Exception1Type => //Handle that exception
            // case e2: Exception2Type => //Handle that exception
        // finally
            // close your resources and do anything else necessary here
        
        // Like if and match, try is an expression that returns a value, so you can write
        // code like this to transform a String into an Int
        def toInt(s: String): Option[Int] =
            try 
                Some(s.toInt)
            catch 
                case e: NumberFormatException => None
        
        println(toInt("1")) //Option[Int] = Some(1)
        println(toInt("YOLO!")) //Option[Int] = None

        // 'while' loops
        // while loops are rarely used in Scala
        // This is because while loops are mostly used for side-effects("booo!"), such as updating mutable
        // variables and printing with println, and these are things you can also do with 'for' loops 
        // and the foreach method on collections.  However, if you ever need to use one, they look like this:
        var i = 0
        while 
            i < 10
        do
            println(i)
            i += 1
    }

    // Control Structures As A Defining Feature of Programming Languages

    // Looping over Data Structures with 'for'
    def loopingOverDataStructuresWithFor(): Unit = {
        println("Looping Over Data Structure With for")
        // Problem: You want to iterate over the elements in a collection in the manner of a traditional for loop
        // There are many ways to loop over collections, including for loops, while loops, and collection methods
        // like foreach, map, flatmap, and more.  This solution focuses primarily on the for loop
        val fruits = List("apple", "banana", "orange")

        for f <- fruits do println(f)
        //  This same approach works for all sequences, including List, Seq, Vector, Array, ArrayBuffer, etc.

        // Use indentation for multiple lines  
        for f <- fruits do 
            val s = f.toUpperCase
            println(s)
        

        //  for loop counters
        for i <- 0 until fruits.length do 
            println(s"$i is ${fruits(i)}")

        // Out:
            // 0 is apple
            // 1 is banana
            // 2 is orange
        
        // to access sequence elements by their index
        for (fruit, index) <- fruits.zipWithIndex do
            println(s"$index is $fruit")
        
        println(fruits.zipWithIndex) //List((apple,0), (banana,1), (orange,2))

        // GENERATORS
        for i <- 1 to 3 do println(i)
        // The "1 to 3" portion of the loop creates a "range"
        // Using a rane like this is know as using a generator

        // Looping over a map (dictionary in Python)
        val names = Map(
            "firstname" -> "Robert",
            "lastname" -> "Goren",
        )
        
        for (k, v) <- names do println(s"key: $k, value: $v")

        // Collection methods like foreach
        fruits.foreach(println)

        fruits.foreach(e => println(e.toUpperCase))

        fruits.foreach{e =>
            val s = e.toUpperCase
            println(s)
        }
        // further reading:
            // https://oreil.ly/UFVQ2
            // https://oreil.ly/3anl9
            // https://oreil.ly/RZGNP

        

    }

    // Using For Loops with Multiple Counters
    def usingForLoopsWithMultipleCounters(): Unit = {
        // Problem: You want to create a loop with multiple counters, such as when iterating
        // over a multi-dimensional array

        val a = Array.ofDim[Int](2, 2)
        println(a(1)(1))
        for 
            i <- 0 to 1
            j <- 0 to 1
        do 
            println(s"($i)($j) = ${a(i)(j)}")   

        
        


    }
    // Using a For Loop With Embedded If Statements (Guards)
    def usingAForLoopWithEmbeddedIfStatements(): Unit = {
        // Problem: You want to add one or more conditional clauses to a for loop, 
        // typically to filter out some elements in a collection while working 
        // on the others

        for
            i <- 1 to 10
            if i % 2 == 0
        do 
            println(s"$i ")
        
        // Working with for loops and the java.io library
        import java.io.File
        val dir = File(".")
        val files: Array[java.io.File] = dir.listFiles()

        for 
            file <- files
            if file.isFile
            if file.getName.endsWith(".scala")
        do
            println(s"Scala file: $file")



        val b: List[Int] = List(1, 2, 3)
        val c = for  //for expression
            i <- 0 until b.length
            if i == 0 || i == 2
        yield 
            i*10
        
        println(c) // Vector(0, 20)

        val d: List[String] = List("A", "B", "C")
        val e = for
            i <- d
            if i.toLowerCase == "a" || i.toLowerCase == "c"
        yield 
            i + " found"
            
        println(e) // List(A found, C found)
    }
    // Creating a New Collection from an Existing Collection with for/yield
    def creatingANewCollectionFromAnExistingCollectionWithForYield(): Unit = {
        println("Creating a New Collection from an Existing Collection with for/yield")
        val names = List("chris", "ed", "maurice")
        println(names) //List(chris, ed, maurice)

        val capNames = for name <- names yield name.capitalize
        println(capNames) //List(Chris, Ed, Maurice)

        //  Using a for loop with a yield statement is known as a for-comprehension

        val lengths: List[Int] = for name <- names yield
            // imagine multiple lines of code
            name.length
        
        println(lengths) // List(5, 2, 7)

        // both parts of your for-comprehension (also known as a for-expression)
        // can be as complicated as necessary

        val xs = List(1, 2, 3)
        val ys = List(4, 5, 6)
        val zs = List(7, 8, 9)

        val a = for 
            x <- xs
            if x > 2
            y <- ys
            z <- zs
            if y * z < 45
        yield 
            val b = x + y 
            val c = b * z
            c
        
        println(a) // List(49, 56, 63, 56, 64, 63)

        // A for comprehension can even be the complete body of a method:
        def between3and10(xs: List[Int]): List[Int] =
            for 
                x <- xs
                if x >= 3
                if x <= 10
            yield x
        
        println(between3and10(List(1,3,5,9,11))) // List(3, 5, 9)

        // Example
        val namesUpper = for n <- names yield n.toUpperCase
        println(namesUpper) // List(CHRIS, ED, MAURICE)

        // Calling the map method on a collection does the same thing
        val namesUpperMap = names.map(_.toUpperCase)
        println(namesUpperMap) // List(CHRIS, ED, MAURICE)

        // 
        val namesCapMap = names.map(_.capitalize)
        println(namesCapMap) // List(Chris, Ed, Maurice) 

    }
    // Using the if Construct Like a Ternary Operator
    def usingTheIfConstructLikeATernaryOperator(): Unit = {
        println("Using the if Construct Like a Ternary Operator:")
        // Problem: You're familiar with Java's special "ternary operator" syntax:
            // int absValue = (a < 0) ? -a : a;
        // and you'd like to know what the scala equivalent is.

        // Trick problem: there isn't one, just use if/else/then expression:
        val a = 1
        val absValue = if a < 0 then -a else a
        println(absValue) // 1

        // because an if expression returns a value, you can embed it in a print statement
        println(if a < 0 then -a else a) // 1

        // you can also use it in another expression, such as this portion of a hashCode method:
        // hash = hash * prime + (if name == null then 0 else name.hashCode)

        // The fact that if/else expressions return a value also lets you write concise methods
        // Version 1: one-line style
        def abs1(x: Int) = if x >= 0 then x else -x
        def max1(a: Int, b: Int) = if a > b then a else b
        
        // Version  2: the method body on a separate line, if you prefer
        def abs2(x: Int) =
            if x >= 0 then x else -x
        
        def max2(a: Int, b: Int) = 
            if a > b then a else b
        
    }
    // Using a Match Expression Like a Switch Statement
    def usingAMatchExpressionLikeASwitchStatement(): Unit = {
        println("Using a Match Expression Like a Switch Statement")
        // Problem: You have a situation where you want to create something like a simple java 
        // integer-based 'switch' statement, such as matching the days in a week, the months
        // in a year, and other situations where an integer maps to a result

        // return a value from a match expression:
        import scala.annotation.switch

        // 'i' is an integer
        val i = 1
        val day = (i: @switch) match
            case 0 => "Sunday"
            case 1 => "Monday"
            case 2 => "Tuesday"
            case 3 => "Wednesday"
            case 4 => "Thursday"
            case 5 => "Friday"
            case 6 => "Saturday"
            case 7 => "invalid day"
        // When writing simple match expressions like this, its recommended to use the
        // @switch annotation, as shown. This annotation provides a warning at compile time 
        // if the switch statement cant be compiled to a 'tableswitch' or 'lookupswitch'. 
        // Compiling your match expressions to a 'tableswitch' or 'lookupswitch' is better
        // for performance because it results in a branch table rather than a decision tree.  
        // When a value is given to the expression, it can jump directly to the result rather
        // than working through the decision tree

        // Scala @switch docs: https://oreil.ly/rrNBP

        // tableswitch optimization example pg.100
            // import scala.annotation.switch

            // class SwitchDemo:
            //     val i = 1
            //     val one = 1
            //     val x = (i: @switch) match 
            //         case one => "One"
            //         case 2 => "Two"
            //         case 3 => "Three"
            //         case _ => "Other"

        // The following conditions must be true for Scala to apply the 'tableswitch' optimization
            // 1. The matched value must be a known integer
            // 2. The matched expression must be "simple". It cant contain any type checks, if statements
            //     or extractors
            // 3. The expression must have its value available at compile time
            // 4. There should be more than two 'case' statements
         
        //  if not concerned with the value of the default case:
            //  case _ => println("Got a default case")
        // If you are interested what fell down to the default case :
            // case default => println(default)
        // Note, name doesnt have to be default, can be any legal name
            //  case oops => println(oops)
        //  you can generate a MatchError if you don't handle the default case, 
            // so unless writing a partial function, handle the damn default case.
        
        // Note: you may not need a match expression for examples like these, for example
        // any time you are just mapping one value to another, it may be preferable to 
        // use a Map(Python dictionary, still getting used to that)

        val days = Map(
            0 -> "Sun", 
            1 -> "Mon",
            2 -> "Tue", 
            3 -> "Wed", 
            4 -> "Thu", 
            5 -> "Fri", 
            6 -> "Sat"
        )
        println(days.get(3)) // Some(Wed)
        println(days(3)) // Wed
        
        // JVM switches: https://oreil.ly/oUcwX
        // Diff between tableswitch and lookupswitch: https://oreil.ly/JvE3P
        // basically 
            // tableswitch: tableswitch uses a table with labels only. 
                    // (O(1) operation)
            // lookupswitch uses a table with keys and labels
                    //  (O(log n) operation)
            // hence we want to optimize by using tableswitch with our 
            // switch expressions where possible

    }
    // Matching Multiple Conditions With One Case Statement
    def matchingMultipleConditionsWithOneCaseStatement(): Unit = {
        println("Matching Multiple Conditions With One Case Statement")
        // Problem: You have a situation where several 'match' conditions 
        // require that the same business logic be executed, and rather than 
        // repeating your business logic for each case, you'd like to use 
        // one copy of the business logic for the matching conditions

        //  separate them with pipe '|'
        val i = 1
        i match
            case 1 | 3 | 5 | 7 | 9 => println("odd")
            case 2 | 4 | 6 | 8 | 10 => println("even")
            case _ => println("too big")
        
        // "odd"

        // same works for String matching
        val cmd = "stop"
        cmd match
            case "start" | "go" => println("starting...")
            case "stop" | "quit" | "exit" => println("stopping...")
            case _ => println("doing nothing")
        
        // "stopping..."

        // this example shows how to match multiple objects on each 'case' statement:
        
        enum Command:
            case Start, Go, Stop, Whoa

        import Command.*
        def executeCommand(cmd: Command): Unit = cmd match
            case Start | Go => println("start")
            case Stop | Whoa => println("stop")

        executeCommand(Start)

        // As demonstrated, the ability to define multiple possible matches for each case statement
        // can simplify your code

    }
    // Assigning the Result of a Match Expression to a Variable
    def assigningTheResultOfTheMatchExpressionToAVariable(): Unit = {
        println("Assigning the Result of a Match Expression to a Variable")
        // Problem: You want to return a value from a match expression and assign it 
        // to a variable, or use a match expression as the body of a method
        
        val someNumber = scala.util.Random.nextInt()
        val evenOrOdd = someNumber match
            case 1 | 3 | 5 | 7 | 9 => "odd"
            case 2 | 4 | 6 | 8 | 10 => "even"
            case _ => "other"

        println(s"Number $someNumber is ${evenOrOdd.toUpperCase}")

        def isTrue(a: Matchable): Boolean = a match 
            case false | 0 | "" => false
            case _ => true
        
        println(isTrue(42)) // true

        // You may hear that Scala is an "expression-oriented programming (EOP) language"
        // EOP means that every construct is an expression, yields a value, and doesn't have
        // a side effect. Unlike other languages, in Scala every construct like if, match, for
        // and try returns a value.

    }
    // Accessing the Value of the Default Case in a Match Expression
    def accessingTheValueOfTheDefaultCaseInAMatchExpression(): Unit = {
        println("Accessing the Value of the Default Case in a Match Expression")
        // Problem: You want to access the value of the default "catch all" case when using a 
        // match expression , but you can't access the value when you match it with the
        // _ wildcard syntax

        // solution: use a name like default in place of the wildcard
        val i = 2
        val newMatch: String = i match
            case 1 => "one"
            case default => "default"
        
        println(newMatch)

        i match
            case 0 => println("1")
            case 1 => println("2")
            case default => println(s"You gave me: ${default}")

    }
    // Using Pattern Matching in Match Expressions
    def usingPatternMatchingInMatchExpressions(): Unit = {
        println("usingPatternMatchingInMatchExpressions")
        // Problem: You need to match one or more patterns in a match expression,
        // and the pattern may be a constant pattern, variable pattern, constructor pattern,
        // sequence pattern, tuple pattern, or type pattern. 

        // many different types of patterns you can use in a match expressions:
        def test(x: Matchable): String = x match
            // Constant Patterns
            case 0 => "zero"
            case true => "true"
            case "hello" => "you said 'hello'"
            case Nil => "an empty list"

            // Sequence Patterns
            case List(0, _, _) => "a 3-element list with 0 as the first element"
            case List(1, _*) => "list, starts with 1, has any number of elements"

            // Tuple Patterns
            case (a, b) => s"got ${a} and ${b}"
            case (a, b, c) => s"got ${a}, ${b}, and ${c}"

            // Constructor Patterns
            case Person(first, "Alexander") => s"Alexander, first name = ${first}"
            case Dog("Zeus") => s"found a dog named Zeus"

            // Typed Patterns
            case s: String => s"got a string: ${s}"
            case i: Int => s"got an int: ${i}"
            case f: Float => s"got a float: ${f}"
            case a: Array[Int] => s"array of int: ${a.mkString(",")}"
            case as: Array[String] => s"array of strings: ${as.mkString(",")}"
            case d: Dog => s"dog: ${d.name}"
            case list: List[_] => s"got a list: ${list}"
            case m: Map[_, _] => m.toString
            
            // The Default Wildcard Pattern
            case _ => "Unknown"
        
        end test

        
            
            



    }


}
