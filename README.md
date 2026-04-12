# Basketball League Management System

A complete Spring Boot application for managing basketball leagues, teams, players, games, and statistics using MongoDB.

## Features

- League management (CRUD operations)
- Team management with league association
- Player management
- Team roster management (add players to teams)
- Game scheduling and score tracking
- Player statistics per game
- RESTful API endpoints
- JWT-based authentication and authorization
- Admin user management

## Technology Stack

- Spring Boot 3.2.0
- Spring Data MongoDB
- Spring Web
- Spring Security
- Spring Validation
- JWT (JSON Web Tokens)
- BCrypt Password Encoding
- Lombok
- MongoDB

## Prerequisites

- Java 17+
- Maven 3.6+
- MongoDB running on localhost:27017

## Getting Started

1. Clone the repository
2. Ensure MongoDB is running on localhost:27017
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

The application will start on `http://localhost:8080`

## API Endpoints

### Authentication
- `POST /auth/login` - Admin login
- `POST /auth/register` - Register new admin

**Note: All other endpoints require JWT authentication via Authorization header: `Bearer <token>`**

### Leagues
- `GET /api/leagues` - Get all leagues
- `GET /api/leagues/{id}` - Get league by ID
- `POST /api/leagues` - Create new league
- `PUT /api/leagues/{id}` - Update league
- `DELETE /api/leagues/{id}` - Delete league

### Teams
- `GET /api/teams` - Get all teams
- `GET /api/teams/{id}` - Get team by ID
- `POST /api/teams` - Create new team
- `PUT /api/teams/{id}` - Update team
- `DELETE /api/teams/{id}` - Delete team
- `GET /api/teams/league/{leagueId}` - Get teams by league

### Players
- `GET /api/players` - Get all players
- `GET /api/players/{id}` - Get player by ID
- `POST /api/players` - Create new player
- `POST /api/players/batch` - Batch upload multiple players
- `PUT /api/players/{id}` - Update player
- `DELETE /api/players/{id}` - Delete player

### Team Roster
- `POST /api/roster/add-player` - Add player to team
- `POST /api/roster/batch-add-players` - Batch add multiple players to team
- `GET /api/roster/team/{teamId}` - Get team roster
- `GET /api/roster/league/{leagueId}` - Get all rosters in league

### Games
- `GET /api/games` - Get all games
- `GET /api/games/{id}` - Get game by ID
- `POST /api/games` - Create new game
- `PUT /api/games/{id}/score` - Update game score
- `GET /api/games/league/{leagueId}` - Get games by league
- `DELETE /api/games/{id}` - Delete game

### Player Statistics
- `POST /api/player-stats` - Add player stats for a game
- `GET /api/player-stats/game/{gameId}` - Get all stats for a game
- `GET /api/player-stats/player/{playerId}` - Get all stats for a player
- `GET /api/player-stats/{id}` - Get stats by ID
- `PUT /api/player-stats/{id}` - Update player stats
- `DELETE /api/player-stats/{id}` - Delete player stats

## Sample API Usage

### Register Admin
```json
POST /auth/register
{
  "username": "admin",
  "password": "password123"
}
```

### Login
```json
POST /auth/login
{
  "username": "admin",
  "password": "password123"
}
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "type": "Bearer",
  "username": "admin"
}
```

**For all subsequent requests, include the JWT token in the Authorization header:**
```
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
```

### Create a League
```json
POST /api/leagues
{
  "name": "2026 Rose Pointe Summer League",
  "startDate": "2026-06-01",
  "endDate": "2026-08-31"
}
```

### Create a Team
```json
POST /api/teams
{
  "name": "Lakers",
  "leagueId": "league_id_here"
}
```

### Create a Player
```json
POST /api/players
{
  "name": "John Doe",
  "position": "Point Guard"
}
```

### Batch Upload Players
```json
POST /api/players/batch
{
  "players": [
    {
      "name": "John Doe",
      "position": "Point Guard"
    },
    {
      "name": "Jane Smith",
      "position": "Shooting Guard"
    },
    {
      "name": "Mike Johnson",
      "position": "Center"
    }
  ]
}
```

**Response:**
```json
{
  "totalPlayers": 3,
  "successfulUploads": 3,
  "failedUploads": 0,
  "uploadedPlayers": [
    {
      "id": "player_id_1",
      "name": "John Doe",
      "position": "Point Guard"
    },
    {
      "id": "player_id_2",
      "name": "Jane Smith",
      "position": "Shooting Guard"
    },
    {
      "id": "player_id_3",
      "name": "Mike Johnson",
      "position": "Center"
    }
  ],
  "errors": []
}
```

### Add Player to Team
```json
POST /api/roster/add-player
{
  "teamId": "team_id_here",
  "playerId": "player_id_here",
  "leagueId": "league_id_here",
  "jerseyNumber": 23
}
```

### Batch Add Players to Team
```json
POST /api/roster/batch-add-players
{
  "teamId": "team_id_here",
  "leagueId": "league_id_here",
  "playerAssignments": [
    {
      "playerId": "player_id_1",
      "jerseyNumber": 23
    },
    {
      "playerId": "player_id_2",
      "jerseyNumber": 10
    },
    {
      "playerId": "player_id_3",
      "jerseyNumber": 7
    }
  ]
}
```

**Response:**
```json
{
  "totalAssignments": 3,
  "successfulAssignments": 3,
  "failedAssignments": 0,
  "addedPlayers": [
    {
      "id": "roster_id_1",
      "teamId": "team_id_here",
      "playerId": "player_id_1",
      "leagueId": "league_id_here",
      "jerseyNumber": 23
    },
    {
      "id": "roster_id_2",
      "teamId": "team_id_here",
      "playerId": "player_id_2",
      "leagueId": "league_id_here",
      "jerseyNumber": 10
    },
    {
      "id": "roster_id_3",
      "teamId": "team_id_here",
      "playerId": "player_id_3",
      "leagueId": "league_id_here",
      "jerseyNumber": 7
    }
  ],
  "errors": []
}
```

### Create a Game
```json
POST /api/games
{
  "leagueId": "league_id_here",
  "teamAId": "team_a_id",
  "teamBId": "team_b_id",
  "gameDate": "2026-06-15T19:00:00",
  "venue": "Main Court",
  "status": "SCHEDULED"
}
```

### Update Game Score
```json
PUT /api/games/{gameId}/score
{
  "scoreA": 95,
  "scoreB": 87
}
```

### Add Player Stats
```json
POST /api/player-stats
{
  "playerId": "player_id_here",
  "gameId": "game_id_here",
  "points": 25,
  "rebounds": 8,
  "assists": 6,
  "steals": 2,
  "blocks": 1,
  "threePointersMade": 4
}
```

## Database Collections

The application creates the following MongoDB collections:
- `admins` - Admin user information (for authentication)
- `leagues` - League information
- `teams` - Team information
- `players` - Player information
- `team_players` - Team roster (many-to-many relationship)
- `games` - Game information
- `player_stats` - Player statistics per game

## Validation

All entities include proper validation:
- Required fields are validated
- Jersey numbers must be between 0-99
- Scores must be non-negative
- Dates are properly validated

## Game Status

Games can have the following statuses:
- `SCHEDULED` - Game is scheduled but not started
- `ONGOING` - Game is currently in progress
- `FINISHED` - Game is completed (automatically set when score is updated)

## Getting Started with Authentication

1. Start the application
2. Register an admin user:
   ```bash
   curl -X POST http://localhost:8080/auth/register \
     -H "Content-Type: application/json" \
     -d '{"username":"admin","password":"password123"}'
   ```
3. Login to get JWT token:
   ```bash
   curl -X POST http://localhost:8080/auth/login \
     -H "Content-Type: application/json" \
     -d '{"username":"admin","password":"password123"}'
   ```
4. Use the returned token in Authorization header for all other API calls:
   ```bash
   curl -X GET http://localhost:8080/api/leagues \
     -H "Authorization: Bearer YOUR_JWT_TOKEN_HERE"
   ```