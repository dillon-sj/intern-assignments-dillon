#Task 
# #Find all the lines with important
# grep "IMPORTANT" file{1..4}.txt > filtered.txt

# wc -w filtered.txt | cut -d'|' 


directory="/home/dillon/Documents/learing"
word="IMPORTANT"

for file in "$directory"/*; do
  if [[ -f "$file" ]]; then
    filtered_content=$(grep -E '^[^|]*\b'"$word"'\b' "$file")
    
    word_count=$(echo "$filtered_content" | wc -w)
    echo "File: $file - Word count: $word_count"
  fi
done
