# Java Socket Chat Application

A multi-client real-time chat application built using Java Socket Programming and Multithreading.
This project demonstrates how a client-server architecture works where multiple clients connect to a server and exchange messages simultaneously.

---

## Tech Stack

<p>
<img src="https://skillicons.dev/icons?i=java" />
<img src="https://skillicons.dev/icons?i=git" />
<img src="https://skillicons.dev/icons?i=github" />
</p>

---

## Project Overview

This application allows multiple users to connect to a central server and communicate in real time.

Each client connects through a socket connection, and the server manages multiple clients using multithreading. Every message sent by a client is broadcast to all connected clients.

---

## Features

* Multi-client chat support
* Real-time message broadcasting
* Username identification for each user
* Thread-based client handling
* Server logs for connections and messages
* Terminal-based interface

---

## Project Architecture

```
Client 1
        \
Client 2 -----> Server -----> Broadcast to all clients
        /
Client 3
```

The server listens for client connections and creates a new thread for each connected client to handle communication independently.

---

## Project Structure

```
ChatApp
│
├── server
│   ├── ChatServer.java
│   └── ClientHandler.java
│
├── client
│   └── ChatClient.java
│
└── README.md
```

---

## Requirements

* Java JDK 17 or higher
* Git (optional)
* VS Code or IntelliJ IDEA

---

## How to Run the Project

### 1. Clone the Repository

```
git clone https://github.com/yourusername/java-chat-application.git
cd java-chat-application
```

---

### 2. Compile the Server

```
javac server/*.java
```

---

### 3. Compile the Client

```
javac client/*.java
```

---

### 4. Start the Server

```
java server.ChatServer
```

Server output example:

```
Server started...
```

---

### 5. Run the Client

Open another terminal and run:

```
java client.ChatClient
```

Example:

```
Enter your username:
Rahul
```

Run multiple clients to simulate a real chat environment.

---

## Example Chat

Client 1

```
Enter your username:
Rahul
Rahul joined the chat
```

Client 2

```
Enter your username:
Amit
Amit joined the chat
```

Conversation

```
Rahul: Hello
Amit: Hi Rahul
```

---

## Possible Improvements

* Private messaging between users
* Chat rooms / group chats
* GUI interface using Java Swing
* Message encryption for secure communication
* Chat history storage

---

## Author

Chhatrapati Sahu
Full Stack Developer (MERN Stack)

GitHub
https://github.com/Chhatrapati-sahu-09

Portfolio
https://www.chhatrapatisahu.me
