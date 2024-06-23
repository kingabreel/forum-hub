# ForumHub ONE

## Alura Project - ONE

### Overview
ForumHub ONE is a forum application where users can register, create topics, post answers, and manage their discussions. The project utilizes Spring Security for authentication and JWT tokens for session management. Database migrations are managed using Flyway.

## Endpoints and Functionalities

### Authentication

#### `POST /login`
- Authenticates the user and returns a JWT token.
 
### Create User

#### `POST /usuarios`
- Create a new user who can  authenticate to use functionalities


### Topic Management

#### `POST /topicos`
- Create a new topic

#### `GET /topicos/{id}`
- Retrieves a specific topic by its ID.

#### `POST /topicos/{id}`
-  Creates an answer for a specific topic.

#### `PUT /topicos/{id}`
-  Updates an existing topic.

#### `DELETE /topicos/{id}`
- Deletes a specific topic by its ID.

### Security Config
#### Open Endpoints
- `POST /login: Public endpoint for user authentication.`
- `POST /usuarios: Public endpoint for user registration.`
- `GET /topicos: Public endpoint for retrieving topics.`
- `GET /topicos/{id}: Public endpoint for retrieving a specific topic.`

#### Protected Endpoints
- `POST /topicos: Requires authentication.`
- `PUT /topicos: Requires authentication.`
- `POST /topicos/{id}: Requires authentication.`
- `DELETE /topicos/{id}: Requires authentication.`