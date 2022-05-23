import scala.concurrent.duration.Duration.Infinite

def shallBeGivenRewardOrExtractingFine(isAgeAppropriate: Boolean,
                                       givenReward: => Int, // call by name
                                       extractFine: => Int, // call by name
                                       currentSavingMoney: Int): (String, Int) = {
  if(isAgeAppropriate) ("Reward given, haha", currentSavingMoney + givenReward)
  else ("Fine extracted", currentSavingMoney - extractFine)
}

//named arguments
val (msg, savingsMoney) = shallBeGivenRewardOrExtractingFine(isAgeAppropriate = true,
  extractFine = 50, currentSavingMoney = 1000, givenReward = 100)


def infinite(): Int = 1 + infinite()

/*def salaryDeductedOrCredited1(isEligibleToGoToInfinite: Boolean, goToInfiniteReward: Int): Int = {
  val fineAsYouCannotGoToInfinite = 100
  if(isEligibleToGoToInfinite) goToInfiniteReward else fineAsYouCannotGoToInfinite
}

salaryDeductedOrCredited1(false, infinite())*/

def salaryDeductedOrCredited(isEligibleToGoToInfinite: Boolean, goToInfiniteReward: => Int): Int = {
  val fineAsYouCannotGoToInfinite = 100
  if(isEligibleToGoToInfinite) goToInfiniteReward else fineAsYouCannotGoToInfinite
}

salaryDeductedOrCredited(isEligibleToGoToInfinite = false, infinite())

// ------------------------trick 1--------------------------
// these 2 numbers are same
def byValuePrint(x: Long): Unit = {
  println(x)
  println(x)
}

byValuePrint(System.nanoTime())

// these 2 numbers are different because we use => by name arg,
// then the expression System.nanoTime() is passed literally
// So byNamePrint will evaluate System.nanoTime() at every moment it is used.
def byNamePrint(x: => Long): Unit = {
  println(x)
  println(x)
}

byNamePrint(System.nanoTime())



def factorial(n: BigInt): BigInt = {
  if (n <= 1)
    1
  else
    n * factorial(n - 1)
}

for(i <- 1 to 10){
  println(s"Factorial of $i = ${factorial(i)}")
}