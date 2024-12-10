package org.jesperancinha.vtcc.domain

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.launch
import kotlinx.coroutines.reactor.mono
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.jesperancinha.vtcc.config.AppConfiguration
import org.jesperancinha.vtcc.domain.IsleType.Misc
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.transaction.reactive.TransactionalOperator

@Disabled
@SpringBootTest
@Import(AppConfiguration::class)
class ProductDaoTest @Autowired constructor(
    val productDao: ProductDao,
    val transactionOperator: TransactionalOperator
) {
    @Test
    fun `should test switch fail`(): Unit = runBlocking {
        transactionOperator.execute {
            mono {
                productDao.save(Product(name = "test", isleType =  Misc))
                withContext(CoroutineName("It's my name") + Default) {
                    launch { productDao.save(Product(name = "test", isleType =  Misc)) }
                }

            }
        }.blockFirst()?.join()
    }
}