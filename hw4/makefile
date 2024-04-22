JC = javac
JFLAGS = -classpath . -d ./bin

JD = javadoc
JDFLAGS = -protected -splitindex -use -author -version -d ./javadoc
RM = rm
JR = java -classpath ./bin

PACKAGE_DIR = hw4
SOURCE_DIR = $(PACKAGE_DIR)/

CLASSES = \
    $(SOURCE_DIR)FileSystemElement.java \
    $(SOURCE_DIR)Directory.java \
    $(SOURCE_DIR)File.java \
    $(SOURCE_DIR)FileSystem.java \
    $(SOURCE_DIR)Main.java

all: $(CLASSES:.java=.class) run

run:
	$(JR) $(PACKAGE_DIR).Main

%.class: %.java
	$(JC) $(JFLAGS) $<

doc:
	$(JD) $(JDFLAGS) $(SOURCE_DIR)*.java

clean:
	$(RM) -r bin

cleandoc:
	$(RM) -r ./javadoc
