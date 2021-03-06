# Hibernate_Tiny_Prjects

### Branch Main:

Spring boot hibernate simple project

### Branch joined_inheritance:

Using Joined strategy, each class in the hierarchy is mapped to its table. The only column which repeatedly appears in all the tables is the identifier, which will be used for joining them when needed

![](https://github.com/hanabizhani/Hibernate_Tiny_Prjects/blob/joined_inheritance/images/map.jpg?raw=true)

### Branch spring_data_query_method:

As the queries themselves are tied to the Java method that runs them, you can actually bind them directly by using the Spring Data JPA @Query annotation rather than annotating them to the domain class. This frees the domain class from persistence specific information and co-locates the query to the repository interface

