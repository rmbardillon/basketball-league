# Basketball League API - Sample Calls

This document provides complete sample API calls for all endpoints in the Basketball League Management System.

## Base URL
```
http://localhost:8080
```

## Authentication

**Important:** All API endpoints (except authentication endpoints) require JWT authentication. Include the JWT token in the Authorization header:

```
Authorization: Bearer <your-jwt-token>
```

### Register Admin
```bash
POST /auth/register
Content-Type: application/json

{
  "username": "admin",
  "password": "password123"
}
```

**Response:**
```json
"User registered successfully!"
```

### Login
```bash
POST /auth/login
Content-Type: application/json

{
  "username": "admin",
  "password": "password123"
}
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcwNjE4NDAwMCwiZXhwIjoxNzA2MjcwNDAwfQ.signature",
  "type": "Bearer",
  "username": "admin"
}
```

**Save the token and use it in all subsequent requests!**

## 1. League Management

### Create a League
```bash
POST /api/leagues
Content-Type: application/json
Authorization: Bearer <your-jwt-token>

{
  "name": "2026 Rose Pointe Summer League",
  "startDate": "2026-06-01",
  "endDate": "2026-08-31"
}
```

**Response:**
```json
{
  "id": "65f1a2b3c4d5e6f7g8h9i0j1",
  "name": "2026 Rose Pointe Summer League",
  "startDate": "2026-06-01",
  "endDate": "2026-08-31"
}
```

### Get All Leagues
```bash
GET /api/leagues
Authorization: Bearer <your-jwt-token>
```

### Get League by ID
```bash
GET /api/leagues/65f1a2b3c4d5e6f7g8h9i0j1
Authorization: Bearer <your-jwt-token>
```

### Update League
```bash
PUT /api/leagues/65f1a2b3c4d5e6f7g8h9i0j1
Content-Type: application/json
Authorization: Bearer <your-jwt-token>

{
  "name": "2026 Rose Pointe Summer League - Updated",
  "startDate": "2026-06-01",
  "endDate": "2026-09-15"
}
```

### Delete League
```bash
DELETE /api/leagues/65f1a2b3c4d5e6f7g8h9i0j1
Authorization: Bearer <your-jwt-token>
```

## 2. Team Management

### Create Teams
```bash
POST /api/teams
Content-Type: application/json
Authorization: Bearer <your-jwt-token>

{
  "name": "Lakers",
  "leagueId": "65f1a2b3c4d5e6f7g8h9i0j1"
}
```

### Get All Teams
```bash
GET /api/teams
Authorization: Bearer <your-jwt-token>
```

### Get Team by ID
```bash
GET /api/teams/65f2b3c4d5e6f7g8h9i0j1k2
Authorization: Bearer <your-jwt-token>
```

### Get Teams by League
```bash
GET /api/teams/league/65f1a2b3c4d5e6f7g8h9i0j1
Authorization: Bearer <your-jwt-token>
```

### Update Team
```bash
PUT /api/teams/65f2b3c4d5e6f7g8h9i0j1k2
Content-Type: application/json
Authorization: Bearer <your-jwt-token>

{
  "name": "Los Angeles Lakers",
  "leagueId": "65f1a2b3c4d5e6f7g8h9i0j1"
}
```

### Delete Team
```bash
DELETE /api/teams/65f2b3c4d5e6f7g8h9i0j1k2
Authorization: Bearer <your-jwt-token>
```

## 3. Player Management

### Create Players
```bash
POST /api/players
Content-Type: application/json
Authorization: Bearer <your-jwt-token>

{
  "name": "LeBron James",
  "position": "Small Forward"
}
```

### Get All Players
```bash
GET /api/players
Authorization: Bearer <your-jwt-token>
```

### Get Player by ID
```bash
GET /api/players/65f4d5e6f7g8h9i0j1k2l3m4
Authorization: Bearer <your-jwt-token>
```

### Update Player
```bash
PUT /api/players/65f4d5e6f7g8h9i0j1k2l3m4
Content-Type: application/json
Authorization: Bearer <your-jwt-token>

{
  "name": "LeBron James",
  "position": "Small Forward"
}
```

### Delete Player
```bash
DELETE /api/players/65f4d5e6f7g8h9i0j1k2l3m4
Authorization: Bearer <your-jwt-token>
```

## 4. Team Roster Management

### Add Players to Teams
```bash
POST /api/roster/add-player
Content-Type: application/json
Authorization: Bearer <your-jwt-token>

{
  "teamId": "65f2b3c4d5e6f7g8h9i0j1k2",
  "playerId": "65f4d5e6f7g8h9i0j1k2l3m4",
  "leagueId": "65f1a2b3c4d5e6f7g8h9i0j1",
  "jerseyNumber": 23
}
```

### Get Team Roster
```bash
GET /api/roster/team/65f2b3c4d5e6f7g8h9i0j1k2
Authorization: Bearer <your-jwt-token>
```

### Get All League Rosters
```bash
GET /api/roster/league/65f1a2b3c4d5e6f7g8h9i0j1
Authorization: Bearer <your-jwt-token>
```

## 5. Game Management

### Create a Game
```bash
POST /api/games
Content-Type: application/json
Authorization: Bearer <your-jwt-token>

{
  "leagueId": "65f1a2b3c4d5e6f7g8h9i0j1",
  "teamAId": "65f2b3c4d5e6f7g8h9i0j1k2",
  "teamBId": "65f3c4d5e6f7g8h9i0j1k2l3",
  "gameDate": "2026-06-15T19:00:00",
  "venue": "Main Court",
  "status": "SCHEDULED"
}
```

### Get All Games
```bash
GET /api/games
Authorization: Bearer <your-jwt-token>
```

### Get Game by ID
```bash
GET /api/games/65faj1k2l3m4n5o6p7q8r9s0
Authorization: Bearer <your-jwt-token>
```

### Get Games by League
```bash
GET /api/games/league/65f1a2b3c4d5e6f7g8h9i0j1
Authorization: Bearer <your-jwt-token>
```

### Update Game Score
```bash
PUT /api/games/65faj1k2l3m4n5o6p7q8r9s0/score
Content-Type: application/json
Authorization: Bearer <your-jwt-token>

{
  "scoreA": 108,
  "scoreB": 95
}
```

### Delete Game
```bash
DELETE /api/games/65faj1k2l3m4n5o6p7q8r9s0
Authorization: Bearer <your-jwt-token>
```

## 6. Player Statistics Management

### Add Player Stats for Game
```bash
POST /api/player-stats
Content-Type: application/json
Authorization: Bearer <your-jwt-token>

{
  "playerId": "65f4d5e6f7g8h9i0j1k2l3m4",
  "gameId": "65faj1k2l3m4n5o6p7q8r9s0",
  "points": 28,
  "rebounds": 8,
  "assists": 7,
  "steals": 2,
  "blocks": 1,
  "threePointersMade": 3
}
```

### Get All Stats for a Game
```bash
GET /api/player-stats/game/65faj1k2l3m4n5o6p7q8r9s0
Authorization: Bearer <your-jwt-token>
```

### Get All Stats for a Player
```bash
GET /api/player-stats/player/65f4d5e6f7g8h9i0j1k2l3m4
Authorization: Bearer <your-jwt-token>
```

### Get Stats by ID
```bash
GET /api/player-stats/65fcl3m4n5o6p7q8r9s0t1u2
Authorization: Bearer <your-jwt-token>
```

### Update Player Stats
```bash
PUT /api/player-stats/65fcl3m4n5o6p7q8r9s0t1u2
Content-Type: application/json
Authorization: Bearer <your-jwt-token>

{
  "playerId": "65f4d5e6f7g8h9i0j1k2l3m4",
  "gameId": "65faj1k2l3m4n5o6p7q8r9s0",
  "points": 30,
  "rebounds": 9,
  "assists": 8,
  "steals": 3,
  "blocks": 2,
  "threePointersMade": 4
}
```

### Delete Player Stats
```bash
DELETE /api/player-stats/65fcl3m4n5o6p7q8r9s0t1u2
Authorization: Bearer <your-jwt-token>
```

## Complete Workflow Example

Here's a complete workflow showing how to set up a league with teams, players, and games:

### 0. Authentication Setup
```bash
# Register admin
POST /auth/register
{
  "username": "admin",
  "password": "password123"
}

# Login to get token
POST /auth/login
{
  "username": "admin",
  "password": "password123"
}

# Save the returned token for use in all subsequent requests
```

### 1. Create League (with JWT token)
```bash
POST /api/leagues
Authorization: Bearer <your-jwt-token>
{
  "name": "2026 Rose Pointe Summer League",
  "startDate": "2026-06-01",
  "endDate": "2026-08-31"
}
```

### 2. Create Teams (with JWT token)
```bash
POST /api/teams
Authorization: Bearer <your-jwt-token>
{
  "name": "Lakers",
  "leagueId": "LEAGUE_ID_FROM_STEP_1"
}
```

### 3. Create Players (with JWT token)
```bash
POST /api/players
Authorization: Bearer <your-jwt-token>
{
  "name": "LeBron James",
  "position": "Small Forward"
}
```

### 4. Add Players to Teams (with JWT token)
```bash
POST /api/roster/add-player
Authorization: Bearer <your-jwt-token>
{
  "teamId": "LAKERS_TEAM_ID",
  "playerId": "LEBRON_PLAYER_ID",
  "leagueId": "LEAGUE_ID",
  "jerseyNumber": 23
}
```

### 5. Create Game (with JWT token)
```bash
POST /api/games
Authorization: Bearer <your-jwt-token>
{
  "leagueId": "LEAGUE_ID",
  "teamAId": "LAKERS_TEAM_ID",
  "teamBId": "WARRIORS_TEAM_ID",
  "gameDate": "2026-06-15T19:00:00",
  "venue": "Main Court",
  "status": "SCHEDULED"
}
```

### 6. Update Game Score (with JWT token)
```bash
PUT /api/games/GAME_ID/score
Authorization: Bearer <your-jwt-token>
{
  "scoreA": 108,
  "scoreB": 95
}
```

### 7. Add Player Statistics (with JWT token)
```bash
POST /api/player-stats
Authorization: Bearer <your-jwt-token>
{
  "playerId": "LEBRON_PLAYER_ID",
  "gameId": "GAME_ID",
  "points": 28,
  "rebounds": 8,
  "assists": 7,
  "steals": 2,
  "blocks": 1,
  "threePointersMade": 3
}
```

## Testing with cURL

You can test these endpoints using cURL commands:

```bash
# Register admin
curl -X POST http://localhost:8080/auth/register \
  -H "Content-Type: application/json" \
  -d '{"username":"admin","password":"password123"}'

# Login to get JWT token
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"admin","password":"password123"}'

# Create a league (replace <JWT_TOKEN> with actual token from login)
curl -X POST http://localhost:8080/api/leagues \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer <JWT_TOKEN>" \
  -d '{"name":"2026 Rose Pointe Summer League","startDate":"2026-06-01","endDate":"2026-08-31"}'

# Get all leagues
curl -X GET http://localhost:8080/api/leagues \
  -H "Authorization: Bearer <JWT_TOKEN>"

# Create a player
curl -X POST http://localhost:8080/api/players \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer <JWT_TOKEN>" \
  -d '{"name":"LeBron James","position":"Small Forward"}'
```

## Testing with Postman

Import these requests into Postman by creating a new collection and adding each endpoint with the corresponding HTTP method, URL, headers, and body content as shown above.

### Postman Authentication Setup:
1. Create a new request for `/auth/login`
2. Set method to POST
3. Add Content-Type: application/json header
4. Add login credentials in body
5. Send request and copy the token from response
6. For all other requests, add Authorization header with value: `Bearer <your-token>`

### Postman Environment Variables:
Create environment variables for easier testing:
- `baseUrl`: http://localhost:8080
- `jwtToken`: (paste your JWT token here after login)

Then use `{{baseUrl}}` and `Bearer {{jwtToken}}` in your requests.

## Error Responses

### Authentication Error (401 Unauthorized)
```json
{
  "status": 401,
  "error": "Unauthorized",
  "message": "Full authentication is required to access this resource",
  "path": "/api/leagues"
}
```

### Validation Error (400 Bad Request)
```json
{
  "timestamp": "2026-01-15T10:30:00.000+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed",
  "path": "/api/players"
}
```

### Not Found (404)
```json
{
  "timestamp": "2026-01-15T10:30:00.000+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Player not found",
  "path": "/api/players/invalid-id"
}
```