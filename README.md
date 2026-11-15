# Under The Mask

A Java console application that encrypts and decrypts sentences with a custom substitution key. The user creates a key, protects it with a PIN, and then masks and unmasks sentences from a menu.

This was my first Java project. I started with a single-class version, then rebuilt it with separate classes to practice object-oriented design.

---

## Key Features

- **PIN protection:** the user sets a 4-digit PIN at startup (digits only, cannot start with 0). The PIN is required to set or display keys.
- **Custom keys:** a key has an *original* part and a *code* part of the same length. The program rejects keys with mismatched lengths or with original characters missing from the code part.
- **Encrypt and decrypt:** each character found in the key is replaced by its matching character. Characters not in the key stay unchanged.
- **Three keys and two sentences** (OOP version): the user picks which key encrypts which sentence, and which sentence is the current one.
- **State tracking:** each sentence remembers whether it is encrypted and which key was used. This prevents encrypting twice and lets the program decrypt with the right key.
- **Enter an already-encrypted sentence** together with the ID of the key that encrypted it, then decrypt it.
- **Formatted key display:** keys are shown as a table with their set / not set status.
- **Menu-driven interface** with input validation and clear error messages.

### Example

With the key `original = abc` and `code = xyz`, the sentence `cab` is encrypted to `zxy`, and decrypting it returns `cab`.

---

## Two Versions

| Version | Files | Description |
|---|---|---|
| Phase 1 (procedural) | `UnderTheMask.java` | Everything in one class: one key, one sentence |
| Phase 2 (object-oriented) | `mainTest.java`, `Key.java`, `SecureSentence.java` | Separate classes: three keys, two sentences |

---

## Skills Used

### Object-Oriented Programming (Phase 2)
- **Classes and objects:** `Key` and `SecureSentence`, each with its own data and behavior
- **Encapsulation:** private fields with getters and setters
- **Constructors** that set safe default values
- **Static members:** `Key.numKeys` gives each key a unique ID automatically
- **Method overloading:** `setSentence(String)` and `setSentence(String, Key)`
- **Object relationships:** a `SecureSentence` holds a reference to the `Key` it was encrypted with

### Core Java (both phases)
- **Control flow:** `do-while` loops, `switch`, `break` / `continue`
- **User input:** `Scanner` for console input
- **Input validation:** PIN rules and key rules
- **String handling:** `charAt`, `indexOf`, `substring`, and building strings character by character
- **Formatted output:** `printf` for the menu and the key table
- **Boolean flags** to track program state

### Problem Solving
- **Substitution cipher:** a character is encrypted by finding its position in the original part and taking the character at the same position in the code part. Decryption does the reverse.
- **Modular design:** helper methods such as `setPin()`, `pinMatches()`, `menu()`, and `keychoice()` keep `main` short and readable

---

## How to Run

Put all the `.java` files in the same folder, then:

```bash
javac *.java
java mainTest          # object-oriented version
java UnderTheMask      # Phase 1 version
```

Requires JDK 8 or newer.

---

## Menu (object-oriented version)

```
1 - Set / change a key
2 - Display all keys
3 - Select a SecureSentence object
4 - Enter a sentence
5 - Display sentence
6 - Encrypt sentence and display it
7 - Decrypt sentence and display it
8 - Display all SecureSentence objects
9 - Exit
```
