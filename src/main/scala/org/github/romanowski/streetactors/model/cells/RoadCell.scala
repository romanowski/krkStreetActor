package org.github.romanowski.streetactors.model.cells


/**
 * Created with IntelliJ IDEA.
 * User: krzysiek
 * Date: 14.03.14
 * Time: 10:23
 * To change this template use File | Settings | File Templates.
 */
case class RoadCell(id: String) extends Cell {
  private var _nextCell: Cell = _

  def init(nextCell: Cell): Unit = {
    _nextCell = nextCell
  }

  def nextCell = _nextCell
}
