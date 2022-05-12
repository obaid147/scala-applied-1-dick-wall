/**
  lazy evaluation or delay execution
 lazy variable is initialized only first time its used/accessed
 then same variable value is used all he time.
 */

lazy val lazyVariable = {
  println("lazy evaluation")
  10
}

val eagerVariable = {
  println("eager evaluation")
  10
}

lazyVariable
println("==")
eagerVariable

println("***")
lazyVariable

