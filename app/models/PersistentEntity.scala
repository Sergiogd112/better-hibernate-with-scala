package models

import javax.persistence.Access
import javax.persistence.Access
import javax.persistence.AccessType
import javax.persistence.AccessType
import javax.persistence.Id
import javax.persistence.Transient
import javax.persistence._
import org.hibernate.annotations.AttributeAccessor
import scala.beans.BeanProperty
import org.hibernate.annotations.Type


@MappedSuperclass
trait PersistentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  // Try to find a way to do away with this annotation as well. It might be a bit
  // unsightly to keep putting these type annotations everywhere the Options are
  // used.
  @Type(`type` = "long")
  var id: Option[java.lang.Long] = None

  @Version
  var version: Integer = 0

  override def equals(other: Any) = {
    if(other == null || other.getClass != this.getClass) {
      false
    }

    val otherEntity = other.asInstanceOf[PersistentEntity];
    otherEntity.id == this.id
  }

  override def hashCode = {
    if(id == null) 0 else id.hashCode
  }

}

trait IdentifierProperty {
  val Id = "id"	
}
