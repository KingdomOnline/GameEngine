# GameEngine
Game Engine for Kingdoms Online

### Compiling 

To compile and test your code, clone KingdomusRoyalus into a directory, navigate into the *Game* folder and either compile the *Main.java* file/jar it or run the main method in the class using any IDE.

### Threading

By default there are two threads, the GameEngine starts a thread rendering things on the main game loop. To get the engine to render things on this loop/thread simply do:

`mainHandler.add(object);`

### Handling

The GameEngine contains a Handler class where you can add GameObjects to a LinkedList (We use LinkedLists rather than an Array because LinkedLists can add, parse, and remove items faster),the handler can be accessed in the engine via the method `getMainHandler()`

## Event System

### New Event

All you need to do to create your own custom event is to make a class and extend Event. That's it. That event class now acts as an event but also a data class, the class will be passed as a parameter of it's listener, treat it as a data class. 

### Call Event 

`EventManager.callEvent(event);`

Let's assume the event to be created is a menu toggle event. The code becomes:

`EventManager.callEvent(new MenuToggleEvent(menu);`

Menu is simply the menu being toggled. (These parameters can be whatever you want)

### Register a Listener Class

Make a class and extend Listener, add a blank constructor and in the `setUpListeners()` method in the Game class write `new TestListenerClass();`

### Register a Listener Method within the class

The event listener method can only have 1 parameter, the event. Referring back to the menu toggle example, to get a method within our listener class to be invoked when the event is called, we have to add the annotation `@EventHandler` Over the method and make sure the only parameter of the method is the event. In this example the code would be:

`
@EventHandler
public void menuToggleEvent(MenuToggleEvent e) {}
`


