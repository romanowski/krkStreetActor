package org.github.romanowski.streetactors.model.cells

import org.github.romanowski.streetactors.model.{Car, ConflictRule}

/**
 * Created with IntelliJ IDEA.
 * User: krzysiek
 * Date: 14.03.14
 * Time: 10:24
 * To change this template use File | Settings | File Templates.
 */
case class CrossRoadCell(id: String,
                         leftExit: Cell,
                         rightExit: Cell,
                         conflictRule: ConflictRule) extends Cell {
  var rightIn: Option[Cell] = None
  var leftIn: Option[Cell] = None

  def input(road: Cell, turn: Direction): Unit = turn match {
    case LeftTurn => leftIn = Some(road)
    case RightTurn => rightIn = Some(road)
  }

  def resolveConflict(cars: Set[Car], time: Int): Car = ???

}

sealed trait Direction {
  def symbol: String
}

object LeftTurn extends Direction {
  def symbol: String = "L"
}

object RightTurn extends Direction {
  def symbol: String = "R"
}

