root_dir="/home/dillon/Documents/Learing"
results_dir="$root_dir/results"
archive_dir="$root_dir/archive"

mkdir -p "$results_dir"
mkdir -p "$archive_dir"

> "$results_dir/TotalWordCount.txt"

for file in "$root_dir"/*; do
  if [ -f "$file" ]; then
    word_count=$(awk -F'|' '$1 ~ /IMPORTANT/ { print }' "$file" | wc -w)

    echo "$file: $word_count words" >> "$results_dir/TotalWordCount.txt"

    mv "$file" "$archive_dir/"
  fi
done
