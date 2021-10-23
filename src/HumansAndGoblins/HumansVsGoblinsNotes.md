### Humans Vs Goblins

1. Everything must be objects
    - land
    - goblins
    - humans
2. You must *override* the _toString_ method to
represent the object.
3. Create a **GRID** for the game world
4. Use _UTF_ characters for the players, goblins and land.
5. Game is turned based: move **n/s/e/w**
6. Once a human and a goblin collide, combat is initiated.
7. Combat uses _**Math.random()**_ 
8. Extras:
    1. human has an inventory system
    2. goblins have drops
    3. stats can be modified by equipment
    4. map gen random treasure chest after each round of combat
    5. goblins persue players
