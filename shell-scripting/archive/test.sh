#!/bin/bash

directory="/home/dillon/Documents/learing"
results_dir="$directory/results"
archive_dir="$directory/archive"
word="IMPORTANT"
total_word_count_file="$results_dir/TotalWordCount.txt"

mkdir -p "$results_dir"
mkdir -p "$archive_dir"

touch "$total_word_count_file"
chmod 644 "$total_word_count_file"  # Set permissions to rw-r--r-- <---owner can read/write, others can read only

# Loop through each file in the directory
for file in "$directory"/*; do
  if [[ -f "$file" ]]; then
    filtered_content=$(grep -E '^[^|]*\b'"$word"'\b' "$file")
    
    word_count=$(echo "$filtered_content" | wc -w)
    
    echo "File: $file - Word count: $word_count" >> "$total_word_count_file"
    
    mv "$file" "$archive_dir/"
    
    echo "Processed file: $file, Moved to archive."
  fi
done

echo "Processing complete."
