package org.github.romanowski.streetactors.model

import org.github.romanowski.streetactors.model.cells.CrossRoadCell
import org.github.romanowski.streetactors.model.cells.Cell
import org.github.romanowski.streetactors.map.CityMap
import org.github.romanowski.streetactors.trips.TripManager

trait City {

  val cityMap: CityMap
  val tripManager: TripManager

  def time: Int

  def nextCell(cell: Cell): Cell = {
    cityMap.nextCell(cell)
  }


  def onTripComplete(car: Car): Unit = {
    tripManager.tripIsDone(car)
  }

  def simulationStep(): Unit
}
