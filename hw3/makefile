JC = javac 
JFLAGS = -classpath . -d ./bin

JD = javadoc
JDFLAGS = -protected -splitindex -use -author -version -d ./javadoc
RM = rm
JR = java -classpath ./bin

CLASSES = \
		Inventory.java \
		Device.java \
		eDevice.java \
		Camera.java \
		Laptop.java \
		TV.java \
		Watch.java \
		Laptop.java \
		Main.java \

all : Main.class

run : 
	$(JR) Main

classes : $(CLASSES:.java=.class)

%.class : %.java
	$(JC) $(JFLAGS) $<

doc:
	$(JD) $(JDFLAGS) *.java 

clean:
	$(RM) -r bin
cleandoc:
	$(RM) -r ./javadoc