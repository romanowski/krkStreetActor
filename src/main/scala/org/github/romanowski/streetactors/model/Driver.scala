package org.github.romanowski.streetactors.model

import org.github.romanowski.streetactors.model.cells.{CrossRoadCell}
import org.github.romanowski.streetactors.model.cells.Cell

/**
 * Created with IntelliJ IDEA.
 * User: krzysiek
 * Date: 14.03.14
 * Time: 10:13
 * To change this template use File | Settings | File Templates.
 */
trait Driver {
  val trip: Trip
  val car: Car


  def move(to: => Cell): Option[Cell] // speed function

  def chooseCell(currentCell: Cell, nextCell: Cell): Option[Cell] =
    move {
      nextCell match {
        case crossroad: CrossRoadCell => ???
        case _ => nextCell
      }
    }


}
