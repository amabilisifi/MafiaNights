# Mafia Nights

A digital implementation of the classic social deduction party game Mafia (also known as Werewolf), featuring day/night cycles, unique roles, and immersive gameplay.


##  About the Game

Mafia Nights brings the popular party game to digital life, allowing friends to play together remotely or locally. In this game of deception and deduction, players are secretly assigned roles as either innocent townspeople or mafia members. The townspeople must identify and eliminate the mafia before they're outnumbered, while the mafia works to eliminate the townspeople without revealing their identities.

##  Features

- **Multiple Game Roles**: Play as a variety of characters including Mafia, Townspeople, Doctor, Detective, and more
- **Day/Night Cycle**: Experience the suspense of night phases (when mafia strikes) and day phases (for discussion and voting)
- **Custom Game Settings**: Adjust player counts, role distributions, and game rules
- **Game Hosting**: Create private lobbies to play with friends
- **Chat System**: Communicate with other players during daytime discussion phases
- **Voice Support**: Optional voice chat for a more immersive experience
- **Spectator Mode**: Watch games after elimination
- **Cross-Platform**: Play on various devices and operating systems
- **Game History**: Review past games and statistics

##  Installation

### Prerequisites
- Java JDK 11 or higher
- Maven (for dependency management)

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/amabilisifi/MafiaNights.git
   ```

2. Navigate to the project directory:
   ```bash
   cd MafiaNights
   ```

3. Compile the project:
   ```bash
   mvn clean compile
   ```

4. Run the game:
   ```bash
   mvn exec:java -Dexec.mainClass="com.amabilisifi.mafianights.MafiaNightsGame"
   ```

##  How to Play

### Getting Started
1. Launch the game and create an account or log in
2. Join an existing game or create a new lobby
3. Wait for enough players to join your lobby
4. The game will begin once all players are ready

### Game Phases
- **Role Assignment**: Each player is secretly assigned a role
- **Night Phase**: Mafia members choose a victim, while special roles (Doctor, Detective, etc.) use their abilities
- **Day Phase**: All players discuss the events and vote to eliminate a suspected mafia member
- **Game End**: The game continues until either all mafia members are eliminated (town wins) or mafia outnumbers townspeople (mafia wins)

### Key Controls
- **Mouse/Touch**: Select options, vote, and use role abilities
- **Enter**: Send chat messages
- **Tab**: Toggle between game view and player list
- **Esc**: Open menu
- **M**: Mute/unmute microphone (when voice chat is enabled)

##  Project Structure

```
MafiaNights/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── amabilisifi/
│   │   │           └── mafianights/
│   │   │               ├── game/
│   │   │               │   ├── Game.java
│   │   │               │   ├── Player.java
│   │   │               │   ├── Role.java
│   │   │               │   └── ...
│   │   │               ├── network/
│   │   │               ├── ui/
│   │   │               ├── audio/
│   │   │               ├── util/
│   │   │               ├── MafiaNightsGame.java
│   │   │               └── ...
│   │   └── resources/
│   │       ├── images/
│   │       ├── audio/
│   │       ├── config/
│   │       └── ...
│   └── test/
│       └── java/
│           └── com/
│               └── amabilisifi/
│                   └── mafianights/
│                       └── ...
├── pom.xml
├── LICENSE
└── README.md
```

##  Roles

### Town Roles
- **Villager**: A regular townsperson with no special abilities
- **Doctor**: Can protect one player from being eliminated each night
- **Detective**: Can investigate one player each night to learn their alignment
- **Sheriff**: Can check if a player is suspicious
- **Bodyguard**: Can protect other players by taking their place as a target
- **Mayor**: Vote counts as double during day phase voting

### Mafia Roles
- **Godfather**: Leads the mafia and appears innocent to the Detective
- **Mafioso**: Regular mafia member who can eliminate townspeople
- **Framer**: Can make innocent players appear guilty to investigations
- **Janitor**: Can clean up evidence, hiding the role of eliminated players

### Neutral Roles
- **Jester**: Wins if they get voted out during the day phase
- **Serial Killer**: Works alone, must eliminate everyone to win
- **Survivor**: Must simply survive until the end of the game


##  Development

### Adding New Roles
1. Create a new class that extends the `Role` class
2. Implement the required methods for night and day actions
3. Add the role to the `RoleFactory` class
4. Update the UI to include the new role in game setup options

### Add Network Code
1. `network/README.md` for details on the networking architecture
2. tests with `mvn test -Dtest=NetworkTests` to validate changes

##  Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.


##  Contact

Project Maintainer: [amabilisifi](https://github.com/amabilisifi)

For bug reports and feature requests, please use the [GitHub Issues](https://github.com/amabilisifi/MafiaNights/issues) page.
