package org.github.romanowski.streetactors.map

import scala.io.Source
import org.github.romanowski.streetactors.model.cells._
import org.github.romanowski.streetactors.model.ConflictRule
import org.github.romanowski.streetactors.model.cells.CrossRoadCell
import org.github.romanowski.streetactors.model.cells.RoadCell
import scala.Some

/**
 * Created with IntelliJ IDEA.
 * User: krzysiek
 * Date: 14.03.14
 * Time: 10:46
 * To change this template use File | Settings | File Templates.
 */
object MapLoader {


  case class CrossroadInfo(id: String, leftExitId: String, leftCells: Int, rightExitId: String, rightCells: Int) {
    def conflictRule: ConflictRule = ???
  }

  object CrossroadInfo {
    def fromString(line: String): Option[CrossroadInfo] = line.split(",") match {
      case Array(id, leftId, leftCells, rightId, rightCells) =>
        Some(CrossroadInfo(id, leftId, leftCells.toInt, rightId, rightCells.toInt))
    }
  }

  def loadFromFile(file: String): CityMap = {
    val info: Seq[CrossroadInfo] = Source.fromFile(file).getLines().flatMap(CrossroadInfo.fromString).toSeq
    // val fromStart = info.gropB

    var roads: Map[RoadCell, Int] = Map()

    def info2crossroad(info: CrossroadInfo): (String, CrossRoadCell) = {
      val (left, right) = if (info.leftExitId == info.rightExitId) {
        val out = new RoadCell(info.id, info.leftExitId, 0)
        (out, out)
      } else (new RoadCell(info.id, info.leftExitId, 0), new RoadCell(info.id, info.rightExitId, 0))
      roads = roads + (left -> info.leftCells)
      roads = roads + (right -> info.rightCells)

      info.id -> CrossRoadCell(info.id, left, right, info.conflictRule)
    }

    val crossroads: Map[String, CrossRoadCell] = info.map(info2crossroad)(collection.breakOut)

    def fillRoad(roadCell: RoadCell, length: Int): Unit = {
      val last = (1 to length).foldLeft(roadCell) {
        (prv, nr) =>
          val next = RoadCell(prv.fromId, prv.toId, nr)
          prv.init(next)
          next
      }
      last.init(crossroads(last.toId))
    }
    roads.foreach(Function.tupled(fillRoad _))

    SimpleCityMap(crossroads)
  }
}
