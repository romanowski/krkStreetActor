package org.github.romanowski.streetactors.imperative

import org.github.romanowski.streetactors.model.{Car, City}
import org.github.romanowski.streetactors.map.CityMap
import org.github.romanowski.streetactors.trips.TripManager
import org.github.romanowski.streetactors.model.cells.{Cell, CrossRoadCell}
import scala.collection.Set

/**
 * Created with IntelliJ IDEA.
 * User: krzysiek
 * Date: 15.03.14
 * Time: 08:50
 * To change this template use File | Settings | File Templates.
 */
case class ImperativeCity(cityMap: CityMap, tripManager: TripManager) extends City {

  var _time = 0


  def time: Int = _time

  override def simulationStep(): Unit = {
    _time += 1

    val cars = tripManager.carsForStep() //all cars in the city
    val plans = cars.flatMap(car => car.nextStep(this)) //all plans for this move
    val occupied = cars.map(car => car.currentCell -> car) //location of all present cars
    val possibleMoves = plans -- occupied //all moves that can be done

    val conflictResolved: Iterable[(Cell, Car)] = possibleMoves.groupBy(_._1).map {
      case (cell, set) if set.size == 1 => set.toSeq.head
      case (crossroad: CrossRoadCell, cars) =>
        crossroad -> crossroad.resolveConflict(cars.map(_._2), _time)
    } //all conflicts are resolved

    val afterMove = conflictResolved.map {
      case (cell, car) => car.moveToCell(cell)
    } //car are moved
  }
}
