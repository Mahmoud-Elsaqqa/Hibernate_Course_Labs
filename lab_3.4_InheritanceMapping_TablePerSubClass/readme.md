# Table Per Sub-Class

represent inheritance relationships as SQL foreign key associations. Every class/subclass that declares persistent properties—including abstract classes and even interfaces—has its own table.

> Unlike the table-per-concrete-class strategy we mapped first, the table of a concrete @Entity here contains columns only for each non-inherited property, declared by the subclass itself, along with a primary key that is also a foreign key of the superclass table.
> 

![image](https://user-images.githubusercontent.com/119105101/224630373-8c8de8e7-7a4b-4d33-8873-4e69f896527f.png)

If you make an instance of the CreditCard subclass persistent:

- Hibernate inserts two rows.
- The values of properties declared by the `BillingDetails` superclass are stored in a new row of the `BILLINGDETAILS` table.
- Only the values of properties declared by the `CreditCard` subclass are stored in a new row of the `CREDITCARD` table.
- The primary key shared by the two rows links them together.
- Later, the subclass instance may be retrieved from the database by joining the subclass table with the superclass table.

### Super Class

```java
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingDetails {
    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    protected Long id;
    @NotNull
    protected String owner;
// ...
}
```

<aside>
📌 - Note that no discriminator is required with this strategy.
- In subclasses, you don’t need to specify the join column if the primary key column of the subclass table has (or is supposed to have) the same name as the primary key column of the superclass table.

</aside>

### Sub-Class

```java
@Entity
public class BankAccount extends BillingDetails {
    @NotNull
    protected String account;
    @NotNull
    protected String bankname;
    @NotNull
    protected String swift;
// ...
}

```

This entity has no identifier property; it automatically inherits the ID property and column from the superclass, and Hibernate knows how to join the tables if you want to retrieve instances of BankAccount.

Of course, you can specify the column name explicitly.

> The primary key columns of the BANKACCOUNT and CREDITCARD tables each also have a foreign key constraint referencing the primary key of the BILLINGDETAILS table.
> 

---

Hibernate generates the following SQL for 

`select bd from billingDetails bd`
