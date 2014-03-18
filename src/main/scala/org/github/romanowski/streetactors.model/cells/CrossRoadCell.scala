package org.github.romanowski.streetactors.cells

import org.github.romanowski.streetactors.ConflictRule

/**
 * Created with IntelliJ IDEA.
 * User: krzysiek
 * Date: 14.03.14
 * Time: 10:24
 * To change this template use File | Settings | File Templates.
 */
case class CrossRoadCell(id: String,
                         nextCellA: Cell,
                         nextCellB: Cell,
                         conflictRule: ConflictRule) extends Cell {

}

sealed trait Direction

object Left extends Direction
object Right extends Direction

