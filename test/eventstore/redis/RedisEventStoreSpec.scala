package eventstore
package redis

@org.junit.runner.RunWith(classOf[org.specs2.runner.JUnitRunner])
class RedisEventStoreSpec extends EventStoreSpec with support.RequiresRedis {
  def makeEmptyEventStore = new RedisEventStore[String]("spec-" + java.util.UUID.randomUUID, "localhost") {
    truncate_!

    override def close() = {
      truncate_!
      super.close
    }
  }
}