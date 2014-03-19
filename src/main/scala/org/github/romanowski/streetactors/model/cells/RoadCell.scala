package org.github.romanowski.streetactors.model.cells


/**
 * Created with IntelliJ IDEA.
 * User: krzysiek
 * Date: 14.03.14
 * Time: 10:23
 * To change this template use File | Settings | File Templates.
 */
case class RoadCell(fromId: String, toId: String, nr: Int) extends Cell {
  private var _nextCell: Cell = _

  val id = s"$fromId-$toId#$nr"

  def init(nextCell: Cell): Unit = {
    _nextCell = nextCell
  }

  def nextCell = _nextCell
}
