package org.github.romanowski.streetactors.map

import scala.io.Source
import org.github.romanowski.streetactors.model.cells.{Direction, RoadCell, CrossRoadCell}
import org.github.romanowski.streetactors.model.ConflictRule

/**
 * Created with IntelliJ IDEA.
 * User: krzysiek
 * Date: 14.03.14
 * Time: 10:46
 * To change this template use File | Settings | File Templates.
 */
object MapLoader {

  def cellId(crossRoadId: String, nr: Int, direction: Direction) = s"$crossRoadId#$nr"

  case class CrossroadInfo(id: String, leftExitId: String, leftCells: Int, rightExitId: String, rightCell: Int) {
    def conflictRule: ConflictRule = ???
  }

  object CrossroadInfo {
    def unapply(line: String): Option[CrossroadInfo] = line.split(",") match {
      case Array(id, leftId, leftCells, rightId, rightCells) =>
        Some(CrossroadInfo(id, leftId, leftCells.toInt, rightId, rightCells.toInt))
    }
  }

  def loadFromFile(file: String) = {
    val info: Seq[CrossroadInfo] = Source.fromFile(file).getLines().flatMap(CrossroadInfo.unapply).toSeq
    // val fromStart = info.gropB


    info.map(info =>
      CrossRoadCell(info.id,
        new RoadCell(cellId(info.id, 0, Left)),
        new RoadCell(cellId(info.id, 0, Right)),
        info.conflictRule)
    )

    var crossroads: Map[Int, CrossRoadCell] = Map()


  }


}
