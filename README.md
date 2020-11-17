# Blocklogger
A block change logging tool for the Fabric mod loader. Part of the FabricAdmin suite of tools
#### Join the discord at https://discord.gg/UxHnDWr
## Todo
- [ ] Add container transactions (Pos, player, items removed)
- [ ] Implement /bl scan

## Develop
How can you help develop blocklogger?
- First download the source code and open in your IDE
- Run the following commands:

```
./gradlew genSources
./gradlew vscode (if you are using VScode, if you're using IntelliJ then look on the fabric wiki)
Build with .\gradlew build 
```

# Use
Blocklogger (as of v0.2) saves the log to a file named blocklogger.bl in the game directory. Access via the command /bl in game

## All interactions
### v0.2 and above
Information is saved to interactions.bl.
Block interaction data for a block is accessible via command /bl i x y z
You can filter for players and block types by using /bl s

# Compile
Open in your IDE, and open a terminal. Run the following commands:
```
./gradlew genSources

./gradlew build
```
The .jar files are located in build/libs

# License
Blocklogger is licensed under the GNU GPL v3.0, found in license.txt
