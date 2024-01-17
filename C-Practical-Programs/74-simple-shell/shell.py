import os

def run_command(command):
    try:
        # Use os.system() to execute the command
        os.system(command)
    except Exception as e:
        print(f"Error: {e}")

def simple_shell():
    while True:
        # Get user input
        user_input = input("jbshell> ")

        # Check if the user wants to exit
        if user_input.lower() == 'exit':
            print("Exiting jbshell.")
            break

        # Run the command
        run_command(user_input)

if __name__ == "__main__":
    print("Welcome to jbshell!")
    print("Type 'exit' to exit the shell.")

    # Run the simple shell
    simple_shell()
