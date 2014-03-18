package org.github.romanowski.streetactors.model

import org.github.romanowski.streetactors.model.cells.CrossRoadCell

/**
 * Created with IntelliJ IDEA.
 * User: krzysiek
 * Date: 03.12.13
 * Time: 13:13
 * To change this template use File | Settings | File Templates.
 */
trait ConflictRule {

  val forCrossroads: CrossRoadCell

  def resolveOnlyOnStreet(onA: CarId, onB: CarId): CarId

  def resolve(city: City)(onA: CarId, onB: CarId): CarId =
    city.resolveConflictOnCityLevel(forCrossroads)(onA, onB).getOrElse(resolveOnlyOnStreet(onA, onB))
}
