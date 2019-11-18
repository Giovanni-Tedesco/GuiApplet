# Physics GUI Applet Class Structure
*Author: Giovanni Tedesco*

**Description** <br>
This app is designed to help students explore the topic of Momentum in a way that is electronic and visual.
Momentum shows the relationship between the mass of an object and its velocity, and why you would rather catch a tennis ball instead of a bowling ball.

## Program Outline
- Main Menu:
  - Many Object Elastic Collisions(Top Down)
    - Interactive Sidebar
    - Top down view panel
  - Single Object Momentum(Side View)
    - Change Mass Slider
    - Change Velocity Slider
    - Add impulse events bar
  - 2 Object Momentum(Side View)
  - About(Info Page)


## Classes
### Main Menu
**Description** <br>
This create and display the main JFrame, it is responsible for the creation of objects, as well as displaying a menu for the user to use.<br>

**Implements**
- ActionListener

**Outline**
- Title: ***Momentum Help Applet***
- Buttons
  - About
    - Author Name
    - Special Thanks
  - Multi Object Collision
  - Single Object
  - 2 Object Elastic Sideview

### Multi-Object Collision View (Top Down)

**Description:**<br>

**Implements**
- ActionListener

**Outline**
- Side selection bar
  - Drag and drop menu to choose different "balls" and create them on the plane
- Main Action Plane
  - "Top Down" view plane to show the elastic and inelastic relationship between different objects

- Vector and Component Menu:
  - Displays the values of each balls individual components. This will be more useful to simply observe the relationship between individual balls.

### Single Object Momentum View (Side)
**Description**<br>

**Implements**
- ActionListener
- ChangeListener

**Outline**
- Animation Pane:
  - This will show the object in question in a side view.
  - This is where the animation of the balls momentum will be done.
- Component Pane:
  - Displays the physical value of the balls momentum components. This is useful for the student to observe the relationship between how the ball reacts when a force works against it.
- Counter force selection pane:
  - Menu to choose the force you wish to observe acting against the ball, as well as the distance that the force will act on it.


### 2 Object Elastic Momentum View(Side)
**Description**<br>
Simply an extension of the Single Object Momentum View panel that will show how objects interact when undergoing elastic momentum. When colliding with each other. This will assume a frictionless surface


**Extends** <br>
- Single Object Momentum View

**Outline** <br>
Follows the outline of Single Object Momentum View

- Adds the second ball to the animation view. This ball will follow collision mechanics based on the laws surrounding the conservation of momentum.


## Ball Side View
**Description** <br>
The class that creates the blueprint for the side view ball

**Properties**

- Velocity
  - Type: Double
  - Notes: The balls velocity in the x-axis
- Mass
  - Type: Double
  - Notes: The mass of the ball. Will also determine the size of the ball
- Momentum:
  - Type: Double:
  - Notes: Determined by the size and velocity of the ball. May also be altered by additional forces that act on the ball.
- X Position:
  - Type: Double
  - Notes:


**Methods**<br>
***Accessors***:<br>
- getX
  - returns: X Position

- getVelocity
  - returns: Velocity

- getMass:
  - returns: Mass

- getMomentum:
  - returns: Momentum

***Mutators***:<br>
- setMass:
  - Return Type: void
  - Parameters:
    - mass
      - Type: Double
- setVelocity:
  - Return Type: void
  - Parameters:
    - velocity
      - Type: Double
- setPosition:
  - Return Type: void
  - Parameters:
    - x
      - Type: Double

***Utility***:<br>
- getMomentum
  - Return Type: double
  - Parameters:
    - Mass
      - Type: double
    - Velocity
      - Type: double

## Ball 2d View:
***Properties***
- double velX
- double velY
- double momentumX
- double momentumY
- double mass
- int intXPosition
- int intYPosition


***Accessors***
- getVelocityX
  - Return Type: double
- getVelocityY
 - Return Type: double
- getMass
  - Return Type: double
- getMomentumX
  - Return Type: double
- getMomentumY
  - Return Type: double
- getPositionX
  - Return Type: int
- getPositionY
  - Return Type: int
***Mutators***
- setVelocityX
  - Return Type: void
  - Parameters:
    - velocityX
      - Type: int
- setVelocityY
  - Return Type: void
  - Parameters:
    - velocityY
      - Type: int
- setPosition
  - Return Type: void
  - Parameters:
    - x
      - Type: int
    - y
      - Type: int
***Utility***
- getMomentum
  - Return type: int
  - Parameters:
    - vX
      - Type: double
    - vY
      - Type: double
    - m
      - Type: double
