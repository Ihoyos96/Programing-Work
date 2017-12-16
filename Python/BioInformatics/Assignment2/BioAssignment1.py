#!/usr/bin/python
import sys
import re
import textwrap

GeneString = open('human.fa', 'rb+')
OutputFile = open('resultsFinal.fa', 'rb+')


for lineA in GeneString.readlines():
	# Finds Gene Name and Strips Excess Characters
	if ('>') in lineA:
		GeneName = lineA
		GeneName = str(GeneName[1:])
		GeneName = GeneName.rstrip()
		GeneInfo = open('protein-coding_gene.txt', 'r')

		####INTERNAL CHECKS####
		#print('\n Test1')
		#print(GeneName)
		#print(len(GeneName))
		####---------------####

		#Finds Corresponding Info in Second File

		
		for lineB in GeneInfo:
			if (re.search(r'\s%s\s' % GeneName, lineB)) is not None:
				GeneInfoList = lineB
				GeneInfoList = GeneInfoList.split('\t')				
				lineA = lineA.rstrip()
				lineA = lineA + ' | ' + GeneInfoList[6] + ' | ' + GeneInfoList[7] + '\n'	
					
				
	printString = []
	for i in range(len(lineA)):
		try:
			if (lineA[i+1]):
				if len(printString) < 60:
					printString.append(lineA[i])
				else:
					printString.append(lineA[i])
					#print (''.join(printString))
					OutputFile.write(''.join(printString) + '\n')
					del printString [:]
		except IndexError:
			OutputFile.write(''.join(printString) + '\n')

OutputFile.close()
GeneString.close()
GeneInfo.close()			

