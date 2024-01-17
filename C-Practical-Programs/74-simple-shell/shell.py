import os
import sys

def shell():
    while True:
        
        user_input = input("$ ").strip()

        # Exit the shell if the user types 'exit' or 'quit'
        if user_input.lower() in ['exit', 'quit']:
            print("Goodbye!")
            break

        # Split the user input into command and arguments
        command_args = user_input.split()

        # Check if any command is entered
        if not command_args:
            continue

        # Get the command and its arguments
        command = command_args[0]
        args = command_args[1:]

        # Execute the command
        try:
            if command == "cd":
                # Change directory
                os.chdir(args[0])
            else:
                # Run the command using os.system
                os.system(user_input)
        except Exception as e:
            print(f"Error: {e}")

if name == "__main__":
    shell()