# Guessing Game

Guessing Game: Configure the ``application.properties`` file with the subject you want the program to guess. 

Set up the following properties:

- `` guessing.program `` 
  - Name the program.
- `` guessing.welcome `` 
  - Set up a welcome message.
- `` guessing.success ``
  - Set up a message to appear when the program correctly guesses what you were thinking.
- `` guessing.failure ``
  - Set up a message to appear when the program gives up.
- `` guessing.complete ``
  - Set up a message to appear when the program prompts you to complete a sentence. Replace {0} with the last question asked by the program, and {1} with your response. The program will ask you to provide a characteristic that distinguishes your response from the previous question asked.
- `` guessing.root ``
  - Set up an initial question.
- `` guessing.next ``
  - Set up a next question to appear when the first question correctly.
- `` guessing.other ``
  - Set up another question to appear when the first question incorrectly.

Example:

```
guessing.program = Jogo Gourmet 
guessing.welcome = Pense em um prato que gosta
guessing.success = Acertei de novo!
guessing.failure = Qual prato voce pensou?
guessing.complete = {0} __________ mas {1} não
guessing.root = massa
guessing.next = lasanha
guessing.other = bolo de chocolate

```

## Requirements
- Maven 3.x
- Java 8

## Usage

### Tests
`` make test ``

### Package
`` make package ``

### Install
`` make install ``

### Run Desktop
`` make run-desktop ``

### Run Web
`` make run-web ``