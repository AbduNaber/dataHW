# Compiler
JC = javac -d ./bin

# Flags
JFLAGS = -g 

# Source files
SRCS = AVLTree.java GUIVisualization.java InputGenerator.java Main.java Stock.java StockDataManager.java

# Object files
OBJS = $(SRCS:.java=.class)

# Default target
default: $(OBJS)

# Rule to compile Java source files
%.class: %.java
	$(JC) $(JFLAGS) $<

# Clean target
clean:
	rm -f ./bin/*.class

run :
	java -Djava.compiler=NONE -Xint -cp ./bin  Main input.txt

javadoc:
	javadoc -d ./docs -author -version $(SRCS)
# create variable for the number of ADD, REMOVE, UPDATE, SEARCH . you can change the value of these variables to test the program
ADD = 100
REMOVE = 0
UPDATE = 0
SEARCH = 0
InputGenerator : 
	java -cp ./bin InputGenerator ADD $(ADD) REMOVE $(REMOVE) UPDATE $(UPDATE) SEARCH $(SEARCH)
