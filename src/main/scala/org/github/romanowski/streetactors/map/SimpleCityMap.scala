package org.github.romanowski.streetactors.map

import org.github.romanowski.streetactors.model.cells.{CrossRoadCell, Cell}
import org.github.romanowski.streetactors.model.Trip

/**
 * Created with IntelliJ IDEA.
 * User: krzysiek
 * Date: 19.03.14
 * Time: 17:05
 * To change this template use File | Settings | File Templates.
 */
case class SimpleCityMap(override val crossroads: Map[String, CrossRoadCell]) extends CityMap {

  def computeTrip(from: Cell, to: Cell): Trip = ???

  def nextCell(from: Cell): Cell = ???
}
