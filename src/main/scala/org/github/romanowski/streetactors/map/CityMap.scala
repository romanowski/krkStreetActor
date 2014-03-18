package org.github.romanowski.streetactors.map

import org.github.romanowski.streetactors.model.cells._
import org.github.romanowski.streetactors.model.Trip

/**
 * Created with IntelliJ IDEA.
 * User: krzysiek
 * Date: 14.03.14
 * Time: 10:47
 * To change this template use File | Settings | File Templates.
 */
trait CityMap {
  val crossroads: Set[CrossRoadCell]

  def computeTrip(from: Cell, to: Cell): Trip

  def nextCell(from: Cell): Cell
}
