package org.sunbird.content.actors

import org.sunbird.actor.core.BaseActor
import org.sunbird.common.dto.{Request, Response}
import org.sunbird.graph.health.HealthCheckManager

import scala.concurrent.{ExecutionContext, Future}

class HealthActor extends BaseActor {
    implicit val ec: ExecutionContext = getContext().dispatcher

    override def onReceive(request: Request): Future[Response] = {
        HealthCheckManager.checkAllSystemHealth()
    }
}
