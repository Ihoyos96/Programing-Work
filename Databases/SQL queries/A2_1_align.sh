#!/bin/bash
#BSUB -J Reads2_1_alignment
#BSUB -e Reads2_1.err
#BSUB -o Reads2_1_alignment.out
#BSUB -n 1
#BSUB -q general
#BSUB -W 72:00
#
cd ${HOME}/Ihoyos/bwa/
./bwa mem BioT/Transcriptome/Transcriptome.fasta BioT/Reads2_1/A2_1.fq > A2_1_alignment.sam
