# GameEngine
Game Engine for Kingdoms Online

### Compiling 

To compile and test your code, clone KingdomusRoyalus into a directory, navigate into the *Game* folder and either compile the *Main.java* file/jar it or run the main method in the class using any IDE.

### Threading

By default there are two threads, the GameEngine starts a thread rendering things on the main game loop. To get the engine to render things on this loop/thread simply do:

`mainHandler.add(object);`

### Handling

The GameEngine contains a Handler class where you can add GameObjects to a LinkedList (We use LinkedLists rather than an Array because LinkedLists can add, parse, and remove items faster),the handler can be accessed in the engine via the method `getMainHandler()`
