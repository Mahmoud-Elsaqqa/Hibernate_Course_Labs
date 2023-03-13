# ORM Mapping Inheritance

# Table per concrete class with implicit polymorphism

---

works by exactly one mapping table for each concrete class. You can map all properties of a class, including inherited properties.

![image](https://user-images.githubusercontent.com/119105101/224608554-992942c9-056e-46e2-b013-77842c2486ee.png)

### Super Class

```java
@MappedSuperclass
public abstract class BillingDetails {
@NotNull
protected String owner;
// ...}
```

---

### Concrete Classes

```java
@Entity
@AttributeOverride(
        name = "owner",
        column = @Column(name = "CC_OWNER", nullable = false))
public class CreditCard extends BillingDetails {
    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    protected Long id;
    @NotNull
    protected String cardNumber;
    @NotNull
    protected String expMonth;
    @NotNull
    protected String expYear;
// ...
}
```

You can override column mappings from the superclass in a subclass with the `@AttributeOverride` annotation or several with `@AttributeOverrides`. The previous example renamed the OWNER column to CC_OWNER in the CREDITCARD table.

<aside>
⚠️ The main problem with implicit inheritance mapping is that it doesn’t support polymorphic associations very well. In the database, you usually represent associations as foreign key relationships. In the schema shown in figure, if the subclasses are all mapped to different tables, a polymorphic association to their superclass (`abstract BillingDetails`) can’t be represented as a simple foreign key relationship.

</aside>

Polymorphic queries that return instances of all classes that match the interface of the queried class are also problematic. Hibernate must execute a query against the superclass as several SQL SELECTs, one for each concrete subclass. The JPA query select bd from `BillingDetails` bd requires two SQL statements:

```sql
select ID, OWNER, ACCOUNT, BANKNAME, SWIFT
from BANKACCOUNT
select ID, CC_OWNER, CARDNUMBER, EXPMONTH, EXPYEAR
from CREDITCARD
```

Hibernate uses a separate SQL query for each concrete subclass. On the other hand, queries against the concrete classes are trivial and perform well—Hibernate uses only one of the statements.

<aside>
⚠️ A further conceptual problem with this mapping strategy is that several different columns, of different tables, share exactly the same semantics. This makes schema evolution more complex.

</aside>
