package org.github.romanowski.streetactors

import org.github.romanowski.streetactors.cells.{CrossRoadCell}
import org.github.romanowski.streetactors.cells.Cell

/**
  * Created with IntelliJ IDEA.
  * User: krzysiek
  * Date: 14.03.14
  * Time: 10:13
  * To change this template use File | Settings | File Templates.
  */
trait Driver {
   val trip: Trip
   val car: Car

   def chooseCell(cell: Cell): Cell = cell match {
     case crossroad: CrossRoadCell => ???
     case _ => cell
   }
 }
