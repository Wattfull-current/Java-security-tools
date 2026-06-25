# File Encryption/Decryption Tool (XOR Cipher)

A Java command-line tool that encrypts and decrypts text files using a 
byte-level XOR cipher.

## Why this matters
Encryption protects data confidentiality — if a file is intercepted or 
accessed without authorization, encrypted content is unreadable without 
the key. This project demonstrates a foundational cryptographic concept: 
XOR encryption, where applying the same key twice returns the original 
data (a ^ key ^ key = a).

## How it works
- Reads user input as plain text
- Converts text to raw bytes
- XORs each byte with a fixed key, writing the result to a file (encryption)
- Reads the file back byte-by-byte, XORs again with the same key, 
  reconstructing the original text (decryption)

## Why byte streams instead of character streams
Encrypted data is not valid readable text, so character streams 
(FileReader/FileWriter), which assume and enforce text encoding, would 
corrupt it. Byte streams (FileInputStream/FileOutputStream) handle raw 
bytes directly without any such assumption, making them the correct 
choice here.

## How to run 
javac filecipher.java
java filecipher

## Sample output
Enter file name:
yy.txt
Enter the input in file
hello
File encrypted and saved
Decrypted content hello

>> Note: The program also contains some segments of file operations used however they are not in the active program
>> Warning : Do not try to play with them they are just for the understanding the concepts used in java 