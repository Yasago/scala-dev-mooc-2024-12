package ru.otus.module1.DataCollection1

import scala.util.Random

class BallsExperiment {

  def isFirstBlackSecondWhite(): Boolean = {
    val list = List(0, 0, 0, 1, 1, 1)
    val shuffled = Random.shuffle(list)
    val first = shuffled.head
    val second = Random.shuffle(shuffled.tail).head

    first == 1 || second == 1
  }
}

object BallsTest {
  def main(args: Array[String]): Unit = {
    val count = 10000
    val listOfExperiments: List[BallsExperiment] = List.fill(count)(new BallsExperiment)
    val countOfExperiments = listOfExperiments.map(_.isFirstBlackSecondWhite())
    val countOfPositiveExperiments: Float = countOfExperiments.count(_ == true)
    println(countOfPositiveExperiments / count)
  }
}