#!/usr/bin/python

import sys
sys.path.append("/Users/ianhoyos/biopython-1.70")
from Bio import SeqIO
import textwrap

gene_dict = {}

for seq_record in SeqIO.parse("human.fa", "fasta"):
    gene_name = seq_record.id
    sequence = seq_record.seq
    gene_dict.update({gene_name : sequence})
print gene_dict.keys()

filename = open("output.fa", "w")

with open("protein-coding_gene.txt") as f:
    for line in f:
        split_line = line.split("\t")
        id = split_line[1]
        previous_id = split_line[4]
        synonyms = split_line[6]
        location = split_line[7]
        for name,sequence in gene_dict.iteritems():
            if id == name or previous_id == name:
                print name
                print synonyms
                print location
                print "----------------------------"
                if synonyms != "":
                    filename.write(">" + name + "|" + synonyms + "|" + location + "\n")
                    fasta_sequence = textwrap.wrap(str(sequence), width=60)
                    for text in fasta_sequence:
                        filename.write(text + "\n")
                else:
                    filename.write(">" + name + "|" + location + "\n")
                    fasta_sequence = textwrap.wrap(str(sequence), width=60)
                    for text in fasta_sequence:
                        filename.write(text + "\n")

filename.close()
