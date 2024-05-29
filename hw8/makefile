# Compiler
JC = javac -d ./bin

# Flags
JFLAGS = -g 

# Source files
SRCS = Main.java Person.java SocialNetworkGraph.java
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
	java -cp ./bin  Main 
doc:
	javadoc -d ./docs -author -version $(SRCS)
