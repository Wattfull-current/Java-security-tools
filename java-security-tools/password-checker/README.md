# Password Strength Checker

A Java command-line tool that evaluates password strength using multiple security criteria, including entropy calculation and detection of commonly leaked passwords.

## Why this matters

Most basic password checkers only verify character composition (does it have a 
number? a symbol?). This is insufficient — a password like `Password123!` 
satisfies every composition rule but is still one of the most common passwords 
in real-world data breaches. This tool combines two layers of analysis:

1. **Composition and entropy** — measures theoretical randomness/strength based 
   on length and character variety, expressed in bits (how many guesses an 
   attacker would need on average).
2. **Leaked password detection** — cross-checks the password against a list of 
   commonly breached passwords, catching weak passwords that look strong on 
   paper but are trivially guessable in practice (dictionary/credential-stuffing attacks).

## What it checks
- Minimum length (8+) and Strength of password entered
- Presence of uppercase letters, lowercase letters, digits, and special characters
- Shannon-style entropy estimate (bits of randomness)
- Membership in a list of commonly leaked/breached passwords

## How entropy is calculated

entropy = password length × log2(character pool size)

Pool size is the sum of character-set sizes present in the password:
- Lowercase: 26
- Uppercase: 26
- Digits: 10
- Special characters: 32

Higher entropy means more possible combinations an attacker must try, and 
therefore a stronger password against brute-force attacks.

## How to run
```
javac passwordmanager.java
java passwordmanager
```
## Example output
Output-1

Welcome to password manager

 A strong password is a said when:
 
    #-It must be at least 8 characters long and should not exceed 15 characters
    #-Must contain a Lowercase letter
    #-Must contain a Uppercase letter
    #-Must contain a Numeric digit
    #-Must contain a Special character (&,$,#,@)
    #-Not in a small list of common/leaked passwords 
    
Enter the password

Hx7!mK9$

Password strength: Strong

Poolsize =94

Entropy =41.89153570263959
