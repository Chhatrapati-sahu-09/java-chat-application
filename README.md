# Java Chat Application

A multi-threaded client-server chat application built with Java sockets.

## Project Structure

```
ChatApp/
├── server/
│   ├── ChatServer.java      # Main server that accepts client connections
│   └── ClientHandler.java   # Handles individual client communication
├── client/
│   └── ChatClient.java      # Client application to connect to server
└── README.md
```

## Features

- **Multi-client support**: Multiple clients can connect and chat simultaneously
- **Broadcast messaging**: Messages are sent to all connected clients
- **Private messaging**: Send private messages using `@username message`
- **Server logging**: All messages are logged with timestamps
- **Threaded architecture**: Each client runs in its own thread

## Requirements

- JDK 17 or higher
- Terminal/Command Prompt

## How to Run

### Step 1: Compile the Project

Navigate to the `ChatApp` directory and compile:

```bash
cd ChatApp
javac server/*.java
javac client/*.java
```

### Step 2: Start the Server

```bash
java server.ChatServer
```

Output:

```
[HH:mm:ss] Server started...
```

### Step 3: Start Clients

Open multiple terminal windows and run:

```bash
java client.ChatClient
```

Enter your username when prompted.

## Usage Examples

### Broadcast Message

Simply type your message and press Enter:

```
Hello everyone!
```

### Private Message

Use the `@username` syntax:

```
@Rahul Hello, this is a private message!
```

### Exit

Type `quit` to disconnect:

```
quit
```

## Architecture

```
Client 1
        \
Client 2 -----> Server -----> Broadcast to all clients
        /
Client 3
```

## Server Logs Format

The server logs all activity with timestamps:

```
[10:30:15] Server started...
[10:30:20] New client connected
[10:30:25] Rahul joined the chat
[10:31:00] Rahul: Hello
[10:32:00] Rahul left the chat
```

## Configuration

Default settings in the code:

- **Port**: 12345
- **Server Address**: localhost

To change these, modify the constants in:

- `ChatServer.java` - `PORT`
- `ChatClient.java` - `SERVER_ADDRESS` and `PORT`

## License

This project is for educational purposes.
