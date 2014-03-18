package org.github.romanowski.streetactors

import org.github.romanowski.streetactors.cells.Cell


case class CarId(id: Int) extends AnyVal

//todo decision should be in strategy
case class Car(id: CarId, driver: Driver) {

  private var _currentTrip: Option[Trip] = None
  private var _currentCell: Option[Cell] = None

  private def currentTrip = _currentTrip.getOrElse(throw new IllegalStateException("No current trip for car: " + this))


  def isDone: Boolean = _currentTrip.isEmpty

  def newTrip(trip: Trip) = {
    if (isDone) {
      _currentTrip = Some(trip)
      _currentCell = Some(trip.start)
    } else {}
    throw new IllegalStateException("car currently has a trip!")
  }

  //todo speed function
  def nextStep(city: City): Option[(Cell, CarId)] = {
    //przenisienie decydowania tu
    _currentCell.flatMap(city.nextCell(this)).map(driver.chooseCell).map(_ -> id)
  }

  def moveToCell(cell: Cell) {
    _currentCell = Some(cell)
  }

}
