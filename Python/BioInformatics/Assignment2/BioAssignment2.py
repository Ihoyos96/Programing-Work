#!/usr/bin/python


### FOR THIS PROGRAM, CLASS SLIDES WHERE USED AS TEMPLATE ####
import sys
sys.path.append("/Users/ianhoyos/biopython-1.70")
import Bio

from Bio.Blast.Applications import NcbiblastpCommandline
from Bio.Blast import NCBIStandalone

### Fixed path to where blastp is located ###

### The Database utilized is a localized database for the mus mulusucus genes. Instead of searching
### Through the entire universe of genes, this way it is a more compact search.

### Also the database is localized so a terminal command is needed to run a conver
### TO turn the file into a Database 'makeblastdb -in mus_protein.fa -parse_seqids -dbtype prot'
blastp_cline = NcbiblastpCommandline(cmd ="/usr/local/ncbi/blast/bin/blastp", query="human.fa", db="mus_protein.fa", evalue=0.01, out="out.txt")
blastp_cline()

### The algorithms chosen are because these blast algorithms analyze on proteins, which
### is what we need.

### Substitution matrix?

### The evalue parameter allows us to select a range for possible matches.



result_handle = open("out.txt")
blast_parser = NCBIStandalone.BlastParser()
blast_record = blast_parser.parse(result_handle)

### 
for alignment in blast_record.alignments:
    for hsp in alignment.hsps:
        if hsp.expect < 0.001:
			print (alignment.title)
			print (alignment.length)
			print (hsp.expect)
			print (hsp.query)
			print (hsp.match)
			print (hsp.sbjct)

