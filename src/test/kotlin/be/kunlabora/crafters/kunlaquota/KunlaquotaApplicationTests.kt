package be.kunlabora.crafters.kunlaquota

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertFalse

@SpringBootTest(classes = [TestKunlaquotaApplication::class])
class KunlaquotaApplicationTests {

	@Test
	fun contextLoads() {
		assertFalse(true)
	}

}
