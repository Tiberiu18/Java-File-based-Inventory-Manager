# Java File-based Inventory Manager

This repository contains a small Java application for managing book inventories using plain text files as the data source. It was originally developed as a university assignment and demonstrates basic object-oriented design in Java.

## Features
- Load books, authors, languages, and publishing retailers from the `init/` folder.
- Query all books provided by a retailer using its ID.
- Retrieve the list of books published by a given retailer.
- Find the intersection of books between two retailers.
- Determine in which countries a book can be found based on its ID.
- List the languages of books provided by a specific publishing retailer.

## Project Structure
```
src/                 Java source files
init/                Input files containing sample data
```
The input files are delimited by `###` and hold sample information about books, authors, languages, retailers, and their relationships.

## Building and Running
This project does not rely on external dependencies. To compile and run the provided test suite using a JDK (8 or later):

```bash
# Compile all sources
javac -d out $(find src -name "*.java")

# Run the entry point which loads data and executes test cases
java -cp out main.TestAll
```
The `TestAll` class will load the input files and print the results of several example queries to the console.


## Contributing
We welcome contributions! Please see [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines.

## Code of Conduct
Participating in this project means adhering to our [Code of Conduct](CODE_OF_CONDUCT.md).

## License
This software is available under the [Apache 2.0](LICENSE) license.


