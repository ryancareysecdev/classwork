''' routing.py
    Constructs a graph from a file and computes a path for
    user-specified start and end points using depth-first search.
    Author: Zack Butler
'''

class Node:
    ''' Represents a node in the graph, neighbors should be a list of Nodes.'''
    __slots__ = ['name', 'neighbors']

def makeNode(name):
    ''' Constructs a node object with the given name and no neighbors. '''
    n = Node()
    n.name = name
    n.neighbors = []
    return n

def findNode(graph,name):
    ''' returns the node from the graph with the given name. '''
    for n in graph:
        if n.name == name:
            return n
    
def loadGraph(filename):
    ''' 
    Loads graph data from the file with the given name, assumes that
    each line contains two strings (representing the two nodes of
    an edge), in which case edges in both directions will be formed.
    Nodes will be created on an as-needed basis.
    Assumes a well-formed file. Returns a list of nodes.
    '''
    graph = []
    for line in open(filename):
        contents = line.split()
        n1 = findNode(graph,contents[0])
        if n1 == None:
            n1 = makeNode(contents[0])
            graph.append(n1)
        n2 = findNode(graph,contents[1])
        if n2 == None:
            n2 = makeNode(contents[1])
            graph.append(n2)
        n1.neighbors.append(n2)
        n2.neighbors.append(n1)
    return graph

def printNode(n):
    ''' Prints the name of the node and its neighbors' names, all on one line. '''
    print(n.name,end = ': ')
    if len(n.neighbors) > 0:
        for i in range(0,len(n.neighbors)-1):
            print(n.neighbors[i].name, end=', ')
        print(n.neighbors[len(n.neighbors)-1].name)
    
def printGraph(graph):
    ''' Prints a graph by simply printing each of its nodes. '''
    for n in graph:
        printNode(n)

def dfspNode(start,goal,visited):
    ''' 
    Takes a graph and two node objects representing the start and goal of
    the search, along with a list of nodes visited.  
    Returns a list of nodes forming a path.
    '''
    if start == goal:
        return [start]
    for n in start.neighbors:
        if not n in visited:
            visited.append(n)
            path = dfspNode(n,goal,visited)
            if path != None:
                return [start]+path

def dfspath(start,goal):
    '''
    Performs a graph search given a start and goal and prints out
    the resulting path.
    '''
    # start node needs to be marked as visited when we start
    visited = [start]
    # by passing in a named list here we will be able to see the
    # final status of the visited list when the search is complete.
    path = dfspNode(start,goal,visited)
    print(len(visited), "nodes visited")
    if path == None:
        print("No path exists.")
    else:
        for n in path:
            print(n.name)
            
# read in the data:
graph = loadGraph(input("Enter graph data filename: "))
printGraph(graph)
# get start and goal from the user
start = findNode(graph,input("Enter starting node name: "))
goal = findNode(graph,input("Enter goal node name: "))
dfspath(start,goal)
