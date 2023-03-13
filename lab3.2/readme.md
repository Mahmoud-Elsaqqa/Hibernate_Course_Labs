#Table per concrete class with unions

consider a union subclass mapping with BillingDetails as an abstract class (or interface),

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/36b5a7a3-6edd-4141-953c-8937c6a743df/Untitled.png)

### Super Class

The database identifier and its mapping have to be present in the superclass, to share it in all subclasses and their tables

```java
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BillingDetails {
    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    protected Long id;
    @NotNull
```

### Sub Class

All concrete class mappings inherit persistent properties from the superclass (or interface). An @Entity annotation on each subclass is all that is required.

```java
@Entity
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

<aside>
📢 Keep in mind that the SQL schema still isn’t aware of the inheritance; the tables look exactly alike as in figure
</aside>


<aside>
✅ If BillingDetails were concrete, you’d need an additional table to hold instances. We have to emphasize again that there is still no relationship between the database tables, except for the fact that they have some (many) similar columns.
</aside>


The advantages of this mapping strategy are clearer if we examine polymorphic queries. For example, the query select bd from BillingDetails bd generates the following SQL statement:

```java
select
        ID, OWNER, EXPMONTH, EXPYEAR, CARDNUMBER,
        ACCOUNT, BANKNAME, SWIFT, CLAZZ_
        from
        ( select
        ID, OWNER, EXPMONTH, EXPYEAR, CARDNUMBER,
        null as ACCOUNT,
        null as BANKNAME,
        null as SWIFT,
        1 as CLAZZ_
        from
        CREDITCARD
        union all
        select
        id, OWNER,
        null as EXPMONTH,
        null as EXPYEAR,
        null as CARDNUMBER,
        ACCOUNT, BANKNAME, SWIFT,
        2 as CLAZZ_
        from
        BANKACCOUNT
        ) as BILLINGDETAILS
```
