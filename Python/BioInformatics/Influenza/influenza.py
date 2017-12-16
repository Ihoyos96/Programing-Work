import sys
import pprint
from scipy import stats


file_control = "Influenza_control_expr.txt"
file_inf = "Influenza_inf_expr.txt"
controlDictionary = {}
infDictionary = {}
control = open(file_control)
inf = open(file_inf)
control.readline() 
inf.readline() 

for line in control:
	line = line.rstrip("\n")
	line = line.split(" ")
	controlDictionary[line[0]] = map(float, line[1:len(line)]) # length of data is 25

for line in inf:
	line = line.rstrip("\n")
	line = line.split(" ")
	infDictionary[line[0]] = map(float, line[1:len(line)])

tTest = {}
pVal = {}

for n in controlDictionary:
	tTest[n] = stats.ttest_ind(controlDictionary[n] , infDictionary[n])
	pVal[n] = tTest[n][1]

pprint.PrettyPrinter(indent=4)

##********************##
# Correcting the p val #
##********************##
#Using bonferroni corection

bonfTestNum     = 60	
bonfVal = 0.05								
bonfResult 	 = bonfVal / bonfTestNum
print bonfVal

list_filt = {}

for i in pVal:
	if pVal[i] < bonfVal:
		list_filt[i] = pVal[i]

##********************##
####printing output#####
##********************##

result = "ID P-VALUE\n"
for u in list_filt:
	result = result + u + " " + str(list_filt[u]) + "\n"
print result
