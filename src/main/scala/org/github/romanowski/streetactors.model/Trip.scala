package org.github.romanowski.streetactors

import org.github.romanowski.streetactors.cells.{Direction, CrossRoadCell, ParkingCell}

/**
 * Created with IntelliJ IDEA.
 * User: krzysiek
 * Date: 03.12.13
 * Time: 13:44
 * To change this template use File | Settings | File Templates.
 */
case class Trip(start: ParkingCell, road: Map[CrossRoadCell, Direction], end: ParkingCell) {
}