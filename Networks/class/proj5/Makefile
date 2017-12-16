#
# Name: pikachu
# Date: 14 feb 2016
# 
# Note: Makefiles begin with a captal M
#   Indentation MUST be with a tab
#
# tagets build, test, clean and submit are required.
# 

COPTS= 
#COPTS= -Wall

PASSFILE= mypasswords.txt

build:
	make mradius

mradius: mradius.c mradius.h utils.o mradius-client.o mradius-server.o
	cc ${COPTS} -o $@ $< utils.o mradius-client.o mradius-server.o

mradius-client.o: mradius-client.c mradius.h
	cc ${COPTS} -c -o $@ $< 
	
mradius-server.o: mradius-server.c mradius.h
	cc ${COPTS} -c -o $@ $< 

utils.o: utils.c mradius.h
	cc ${COPTS} -c -o $@ $< 

run-server: mradius
	./mradius -v ${PASSFILE}
	
clean:
	-rm mradius utils.o mradius-client.o mradius-server.o

submit:
	@echo svn add your work
	svn commit -m "submitted for grading"


