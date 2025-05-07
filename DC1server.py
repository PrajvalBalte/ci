from xmlrpc.server import SimpleXMLRPCServer
import threading

# Define factorial function
def factorial(n):
    if n == 0 or n == 1:
        return 1
    else:
        return n * factorial(n - 1)

# Define shutdown function
def shutdown():
    print("Shutting down the server...")
    threading.Thread(target=server.shutdown).start()
    return "Server is shutting down."

# Create and configure the server
server = SimpleXMLRPCServer(("localhost", 8000), allow_none=True)
print("Server is listening on port 8000...")

# Register functions
server.register_function(factorial, "factorial")
server.register_function(shutdown, "shutdown")

# Start the server
server.serve_forever()
