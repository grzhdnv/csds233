# Programming Assignment 1: Music Composition

## Problem Description

For this assignment, you will be using the sound/music library jFugue ([http://www.jfugue.org](http://www.jfugue.org)) to develop an interactive music composition system. This should be a console-based application. Your program needs to provide for the following functionality:

### Adding musical phrases
A phrase will be any musical unit that the user has input, from a single note to a collection of notes, chords, etc.
- [x] Adding at the end of the composition
- [x] Adding at the beginning of the composition
- [x] Adding at the "current" location of the composition
- [x] Allow a user to repeat (copy) a phrase to the end of the composition

### Removing phrases
- [x] Removing the "current" phrase
- [x] Removing a specific phrase

### Rearranging phrases
Allow a user to rearrange the phrases of the musical composition by moving phrases to new locations within the composition

### Playback
- Playback entire composition (from the beginning)
- Playback from the "current" location and going to the end
- Playback of one phrase at a time

### Composition navigation
- Move the "current" location ahead one phrase
- Move the "current" location back one phrase

The main program should loop offering the user the above functionality until the user indicates that she or he is finished composing/listening. If you would like to add functionality for saving a composition to a file or reading a composition from a file, you can, but this is not a requirement of the project.

## jFugue and Using External Libraries

jFugue is an older Java library designed for easy music playback and composition. There's a lot to it that we won't use for this particular project. In fact, the only jFugue commands you'll need are a call to the Player constructor and a call to the Player class's play() method. The play method takes in a string or series of strings that specifies a phrase of music to be played. The music is specified using the Staccato markup language. Here are a couple of websites with examples of using this markup language:

- [http://www.jfugue.org/examples.html](http://www.jfugue.org/examples.html)
- [https://medium.com/@dmkoelle/a-quick-reference-for-making-music-in-jfugue-7a15c1dbc9c3](https://medium.com/@dmkoelle/a-quick-reference-for-making-music-in-jfugue-7a15c1dbc9c3)

While there are lots of features of jFugue, I want you to keep it simple for this project (see below).

In order to use jFugue, you'll first need to download the jar file of this library: [jfugue-5.0.9.jar](http://www.jfugue.org/jfugue-5.0.9.jar). Save this jar file somewhere that you'll be able to remember—maybe in a directory named JavaLibs or somewhere else you'll remember. Within IntelliJ you'll need to add this external library to the project:

1. Under the File menu, choose "Project Structure..."
2. Click on "Libraries"
3. Click on the "+"
4. Navigate to the jfugue-5.0.9.jar file and select it.

In your java file, you'll need to make sure to have the line: `import org.jfugue.player.Player;` near the beginning.

## Program Approach

While you have some flexibility in how you solve this problem, there are a few requirements:

The only jFugue commands that you are allowed to use are:
- Creation of a new player (e.g. `Player player = new Player()`)
- Use of the play method (e.g. `player.play(phrase)`, where phrase is a string)

You will need to create a doubly linked structure to manage the user supplied phrases. This data structure should include nodes with links to the next and previous phrases (if there are ones) in the list. The content of each node would be a musical phrase (i.e., a String in Staccato format). See the problem description above for functionality that you'll need to include. You will need to write your own linked data structure rather than using a java library for this assignment.

## Deliverables

By the due date you should deliver:

- The java files that contain your solution—if more than one file, then turn in a zip file of them. Note, we only want your java files.

- A written report that addresses the following points:
  1. What is the asymptotic runtime of each of your functions?
  2. Describe how you tested your code, list your test cases, and provide a log of your test runs
  3. What was the most interesting part of this assignment?
  4. What was the most challenging part of this assignment?
  5. How would you like to extend your solution (i.e., what other functions would you like to provide for this application)?
  6. Any feedback you'd like to provide about the assignment?