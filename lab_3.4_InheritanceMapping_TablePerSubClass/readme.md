# Table Per Class Hierarchy
This method works by mapping an entire class hierarchy to a single database table.

This table includes columns for all properties of all classes in the hierarchy. The value of an extra type discriminator column or formula identifies the concrete subclass represented by a particular row.

![image](https://user-images.githubusercontent.com/119105101/224630130-e2a7641c-f815-44e7-be8a-055d96788b3b.png)

This strategy is the best-performing way to represent polymorphism—both polymorphic and nonpolymorphic queries perform well—and it’s even easy to write queries by hand.

<aside>
⚠️ There is one major problem: data integrity. You must declare columns for properties declared by subclasses to be nullable. If your subclasses each define several nonnullable properties, the loss of `NOT NULL` constraints may be a serious problem from the point of view of data correctness.

</aside>

### Super Class

```java
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "BD_TYPE")
public abstract class BillingDetails {
    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    protected Long id;
    @NotNull
    @Column(nullable = false)
    protected String owner;
// ...
}
```

<aside>
📌 You have to add a special discriminator column to distinguish what each row represents. This isn’t a property of the entity; it’s used internally by Hibernate.

</aside>

### Sub-Class

```java
@Entity
@DiscriminatorValue("CC")
public class CreditCard extends BillingDetails {
    @NotNull
    protected String cardNumber;
    @NotNull
    protected String expMonth;
    @NotNull
    protected String expYear;
// ...
}
```

Annotate every subclass with , and then map properties of a subclass to coumns in the table.

Remember that `NOT NULL` constraints are not allowed in the schema,

---

Hibernate generates the following SQL for

`select bd from billingDetails bd`

```java
select
	ID, OWNER, EXPMONTH, EXPYEAR, CARDNUMBER, ACCOUNT, BANKNAME, SWIFT, BD_TYPE 
From
	BILLINGDETAILS
```

---
