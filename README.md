## Backend for e-Shop
### Technologies used:
- Java
- Spring Boot
- Lombok
- Mapstruct
- Liquibase
- Docker 
- Postgresql
- Maven

### Idea:
E-commission shop. In which the following functions are implemented.
- User registration
- User login
- Create a post
- Remove post
- Edit post
- Adding a picture to a post
- Ability to place an order and book a product
- Remove order and cancel product reservation
- Search posts by title
- Filter posts by category

## Backend Installation guide
1.Install dependencies and Docker (Linux/Mac)
- Update system `sudo apt-get update`
- Install docker `sudo apt install docker.io`
- Enable service `sudo systemctl enable --now docker`
- Confirm installation `docker --version`
- Install Java at least 17 version.

2.Clone project using git clone with https.\
3.Create local postgres database.\
4.Run sudo `docker-compose up -d`\
5.You should run backend project.\
6.You should run frontend project(You fill wind how to do this in our frontend project wiki)

### Test

For integration tests change in `application.yml`file:\
`change-log: classpath:/db/changelog/changelog-root.xml`\
to\
`change-log: classpath:/db/changelog/changelog-test-data.xml`