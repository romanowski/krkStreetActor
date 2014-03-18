package org.github.romanowski.streetactors.trips

import org.github.romanowski.streetactors.model.{Car, Trip}

/**
 * Created with IntelliJ IDEA.
 * User: krzysiek
 * Date: 15.03.14
 * Time: 09:14
 * To change this template use File | Settings | File Templates.
 */
trait TripManager {

  def carsForStep(): Set[Car]

  //new cars to join the city

  def tripIsDone(car: Car): Unit
}
