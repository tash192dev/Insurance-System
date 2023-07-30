# Insurance System

Insurance System that can be used to clients and their policies for an insurance company. 

## Features: 
  - Add new clients,
  - Delete existing clients
  - Add new policies for existing clients
  - Calculate the cost of premiums for any given policy
  - Calculate the total cost of premiums for all policies for a client
  - Applying discounts for clients who have multiple policies

## Commands:
|PRINT_DB | [no args] | Print the entire insurance database |
|-------------|:--------------:|----------------------|
CREATE_PROFILE | [2 arguments] |  Create a new client profile <USERNAME> <AGE>
LOAD_PROFILE   | [1 arguments] |  Load the specified profile <USERNAME>
UNLOAD_PROFILE  |[no args]     |  Unload the currently-loaded profile
DELETE_PROFILE  |[1 arguments] |  Delete the specified profile <USERNAME> from the database
POLICY_HOME   |  [no args]     |  Create a new home policy for the currently-loaded profile
POLICY_CAR    |  [no args]     |  Create a new car policy for the currently-loaded profile
POLICY_LIFE    | [no args]     |  Create a new life policy for the currently-loaded profile
HELP           | [no args]     |  Print usage
EXIT           | [no args]     |  Exit the application
