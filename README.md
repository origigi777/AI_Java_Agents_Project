# AI_Java_Agents_Project
 
Agent Class:
Contains the behavior pattern of the agents in the program - receives an ID Recipient Table Size receives a problem and receives an instance of the message sending mechanism and receives a constraint matrix. The department is responsible for solving the constraint problems.
The first agent sends a message first, he sends a CPA that connects the agents and he gives the task to the next agent in line, during this time all the agents listen and run in the background, the agents check if they have been notified until they receive a message when the agent receives a CPA message that will be printed on the screen and move on to the next agent with the task to repair that the next agent needs to perform. If the last agent has not found a solution the program will return  "NO SOLUTION" However if one of the agents finds a solution the solution will be printed



The algorithm by which the agent operates is a synchronous withdrawal algorithm – this means that the agents are waiting for "IS-OK" approval from the agents in front of them to move forward with their names.



ABTagant Class:
However we use the aynchronous version of the algorithm, this means that if in the synchronous bt algorithm it was customary for the agents to wait for approval from the previous agents the agents of this department first perform the names without waiting for approval from the previous agents and finally a test is carried out in the eyes of the need

AgentsBoards Class:
Contains an agent simulation and the agent after it and a 2D array that contains the answers 0 and 1 in the table The array size is determined by the user
The answer of zero or one in the table is determined by the following condition: each time a random number is selected between zero and 1 if it is greater than 0.5 we will receive zero and if less than 0.5 we will get 1 .

factoryAgents Class:
responsible for two parts,
Part 1 is  Creating the agents and their journey on the board of agents
Part 2 is creating the problems that agents have to deal with.



Mailer Class:
The message-sending mechanism contains the messages from the other agents, the instance is attached to each agent at the time of the run, so there is a mechanism for receiving messages and sending messages to each treadmill (agent).
Part one - the mechanismsendmessege that receives the agent's ID and a message that we would like to forward to the other agents
Part two -read message is responsible for reading the message from the other agents.
The  Mailer receives the number of agents in order to create a messaging mechanism for all new agents.

CPAMessage Class:
The constraint mechanism–the entire program is based on the legality found in this department.
The department is responsible for receiving and modifying the message that passes between the agents, the goal in the message will not be minus 1 if we succeed in receiving a SLUTION (we will receive a SLUTION even if we receive in the table between 2 agents that there are only unity and not zeros).
The CPA message consists of a simple array that contains numbers between minus one and one.
Assign-puts in the cell in the array the number they gave him in a CPA message, which is what helps agents change parts of the CPA message.

Metrics Class:
Returns us how many times some assignments have been performed (CPA notification change operations)
Several times agents were checked.  And it's my responsibility to return a message to us depending on the situation we're in.
There is a solution– we will getsolution and printing of the CPA message
There is no solution– the program will print that there is no solution.
Problem department:
Containing the problem the program ran on, two agents are taken with the actions they have taken and the method will determine whether the problem is solved or not.
Is ok-checking whether the table between each of the two agents contains only unity, if there is only unity we will get a solution if not then we will accept that there is no solution.


SolutionMessage Class:
An auxiliary department for the Matrix department that helps identify whether there is a solution or not.
Contains a matuda that is responsible for reimbursing us whether or not there is a solution in accordance with the conditions in the Matrix.
 
Main Class:
This class contains the instances of the other classes and also contains the queries about the amount of agents as rounds and the size of the table.
And contains the reset methodology that aims to allow us to restart every round of the program. 
Contains the round number methodology that is required to print the rotation number during the run



important methods: 
Kill AGENT  : This method runs a test at the end of the program to see how many agents remain active in the background 
And triggers an operation for all the agents in the background and sends a message returning how many agents she "killed" out of the total number of agents.
The test is based on a pre
