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

salaryDeductedOrCredited(false, infinite())
