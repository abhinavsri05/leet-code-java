# Read from the file words.txt and output the word frequency list to stdout.

egrep "[a-z]+" -o words.txt | sort | uniq -c | sort -r | awk '{print $2, $1}'

