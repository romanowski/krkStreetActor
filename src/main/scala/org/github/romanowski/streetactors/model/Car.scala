package org.github.romanowski.streetactors.model

import org.github.romanowski.streetactors.model.cells.Cell


case class Car(driver: Driver, trip: Trip) {

  private var _currentCell: Cell = trip.start

  def currentCell = _currentCell

  def isDone: Boolean = _currentCell == trip.end

  def nextStep(city: City): Option[(Cell, Car)] = {
    driver.chooseCell(_currentCell, city.nextCell(_currentCell)).map(_ -> this)
  }

  def moveToCell(cell: Cell): Car = {
    _currentCell = cell
    this
  }

}
