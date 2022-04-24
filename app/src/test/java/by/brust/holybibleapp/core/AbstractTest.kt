package by.brust.holybibleapp.core

import junit.framework.Assert.assertTrue
import org.junit.Test
import java.io.IOException

class AbstractTest {

    @Test
    fun test_success() {
        val dataObject = TestDataObject.Success("a", "b")
        val domainObject = dataObject.map(DataToDomain.Base())
        assertTrue(domainObject is DomainObject.Success)
    }

    @Test
    fun test_fail() {
        val dataObject = TestDataObject.Fail(IOException())
        val domainObject = dataObject.map(DataToDomain.Base())
        assertTrue(domainObject is DomainObject.Fail)
    }

    private sealed class TestDataObject : Abstract.Object<DomainObject, DataToDomain>() {
        abstract override fun map(mapper: DataToDomain): DomainObject

        class Success(private val textOne: String, private val textTwo: String) : TestDataObject() {
            override fun map(mapper: DataToDomain): DomainObject {
                return mapper.map(textOne, textTwo)
            }
        }

        class Fail(private val exception: Exception) : TestDataObject() {
            override fun map(mapper: DataToDomain): DomainObject {
                return mapper.map(exception)
            }
        }
    }

    private interface DataToDomain : Abstract.Mapper<Any?, Any?> {
        fun map(textOne: String, textTwo: String): DomainObject
        fun map(exception: Exception): DomainObject

        class Base: DataToDomain {
            override fun map(textOne: String, textTwo: String): DomainObject {
                return DomainObject.Success("$textOne $textTwo")
            }

            override fun map(exception: Exception): DomainObject {
               return DomainObject.Fail()
            }

        }
    }

    private sealed class DomainObject: Abstract.Object<UIObject, DomainToUIMapper>() {
        class Success(private val textCombined: String): DomainObject() {
            override fun map(mapper: DomainToUIMapper): UIObject {
                TODO("Not yet implemented")
            }
        }
        class Fail: DomainObject() {
            override fun map(mapper: DomainToUIMapper): UIObject {
                TODO("Not yet implemented")
            }
        }
    }

    private interface DomainToUIMapper: Abstract.Mapper<Any?, Any?>

    private sealed class UIObject: Abstract.Object<Unit, Abstract.Mapper<Any?, Any?>.Empty>()
}