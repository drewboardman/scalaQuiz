import scala.util.Random
import collection.immutable.IndexedSeq

// 20% of the time return 1, 30% of the time return 2, 50% of the time return 3. Do this 100,000 times

object Doer {
  def execute(): List[Int] = {
    val rando = new Random()
    val results = (0 until 100000).toList map { _ =>
      rando.nextDouble() match {
        case x if (x <= 0.2) => 1
        case x if ((x > 0.2) && (x <= 0.5)) => 2
        case x if (x > 0.5) => 3
      }
    }
    return results
  }

  def stats(resultList: List[Int]): Map[Int, String] = {
    val ones = resultList.filter { x => x == 1 }.length
    val onesStat = (ones/100000.0)*100
    val twos = resultList.filter { x => x == 2 }.length
    val twosStat = (twos/100000.0)*100
    val threes = resultList.filter { x => x == 3 }.length
    val threesStat = (threes/100000.0)*100
    Map(
      (1 -> s"${onesStat}%"),
      (2 -> s"${twosStat}%"),
      (3 -> s"${threesStat}%")
    )
  }
}
