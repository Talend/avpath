package wandou.avro

import org.scalatest.BeforeAndAfterAll
import wandou.avro.test.Account
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

class FromToJsonSpec extends AnyWordSpecLike with Matchers with BeforeAndAfterAll {
  val schema = Schemas.account

  "FromToJson" when {
    "FromtoJsonString" in {
      val account = new Account
      account.setId("1")
      account.setRegisterTime(System.currentTimeMillis())
      val jsonStr = ToJson.toJsonString(account, schema)
      assertResult(account.toString)(FromJson.fromJsonString(jsonStr, schema).toString)
    }
  }
}
