# Hibernate_Tiny_Prjects

### Branch Main:

Spring boot hibernate simple project

### joined_inheritance:

Using Joined strategy, each class in the hierarchy is mapped to its table. The only column which repeatedly appears in all the tables is the identifier, which will be used for joining them when needed

![](https://github.com/hanabizhani/Hibernate_Tiny_Prjects/blob/joined_inheritance/images/map.jpg?raw=true)

### spring_data_query_method:

As the queries themselves are tied to the Java method that runs them, you can actually bind them directly by using the Spring Data JPA @Query annotation rather than annotating them to the domain class. This frees the domain class from persistence specific information and co-locates the query to the repository interface

### spring_data_Envers:

At some point of every company’s adult life it starts reassessing the sanity and quality of its data set. One of the ways to regain the trust is to introduce auditing and versioning of database entities, which is exactly what Hibernate Envers is for.

