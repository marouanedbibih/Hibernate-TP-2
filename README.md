Here’s a simple `README.md` file template for your Hibernate project:

```md
# Hibernate TP Project

This project is a demonstration of basic Hibernate functionality, including CRUD operations (Create, Read, Update, Delete) with a MySQL database. It includes an implementation of data persistence for the `Salle` and `Machine` entities using Hibernate ORM.

## Features

- Hibernate integration with MySQL database
- CRUD operations for the `Salle` and `Machine` entity
- Configuration of Hibernate with `hibernate.cfg.xml`
- Transaction management and exception handling

## Project Structure

```plaintext
my-hibernate-project/
├── pom.xml
├── README.md
├── src
│   ├── main
│   │   ├── java
│   │   │   └── org
│   │   │       └── marouane
│   │   │           ├── IDao
│   │   │           │   └── IDao.java
│   │   │           ├── Main.java
│   │   │           ├── models
│   │   │           │   ├── Machine.java
│   │   │           │   └── Salle.java
│   │   │           ├── services
│   │   │           │   ├── MachineServiceImpl.java
│   │   │           │   └── SalleServiceImpl.java
│   │   │           └── util
│   │   │               └── HibernateUtil.java
│   │   └── resources
│   │       └── hibernate.cfg.xml
│   └── test
│       └── java
│           ├── MachineServiceTest.java
│           └── SalleServiceTest.java
└── target
    ├── classes
    │   ├── hibernate.cfg.xml
    │   └── org
    │       └── marouane
    │           ├── IDao
    │           │   └── IDao.class
    │           ├── Main.class
    │           ├── models
    │           │   ├── Machine.class
    │           │   └── Salle.class
    │           ├── services
    │           │   ├── MachineServiceImpl.class
    │           │   └── SalleServiceImpl.class
    │           └── util
    │               └── HibernateUtil.class
    └── test-classes
        ├── MachineServiceTest.class
        └── SalleServiceTest.class
```

## Requirements

- JDK 21
- MySQL database
- Maven for dependency management
- Hibernate ORM

## Setup

1. Clone the repository:
    ```bash
    git clone https://github.com/marouanedbibih/Hibernate-TP-2.git
    ```

2. Configure your MySQL database in `hibernate.cfg.xml`:
    ```xml
    <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/your_database_name</property>
    <property name="hibernate.connection.username">your_username</property>
    <property name="hibernate.connection.password">your_password</property>
    ```

3. Build the project:
    ```bash
    mvn clean install
    ```

4. Run the project and test the CRUD operations.
