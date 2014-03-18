package org.github.romanowski.streetactors

import org.github.romanowski.streetactors.cells.CrossRoadCell
import org.github.romanowski.streetactors.cells.Cell

/**
 * Created with IntelliJ IDEA.
 * User: krzysiek
 * Date: 03.12.13
 * Time: 13:37
 * To change this template use File | Settings | File Templates.
 */
trait City {
  //implement
  /**
   *
   * @param cell
   * @return None - if next cells is
   */
  def nextCell(car: Car)(cell: Cell): Option[Cell] = {
    ???
  }


  def onTripComplete(car: Car): Unit = ???

  def resolveConflictOnCityLevel(crossRoadId: CrossRoadCell)(onA: CarId, onB: CarId): Option[CarId] = ???
}
