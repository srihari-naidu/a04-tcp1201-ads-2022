# Aid Distribution System

This is an aid distribution system that allows donors to donate aid to a distribution center (DC), and for the DC to match the aid with NGOs that need it.

## Features

1. Donor - A donor is an individual or organization who donates aid to a distribution center (DC). A donor has a name and a phone. A donor can perform the following tasks in the system:
   - Register and login an account at a DC.
   - Enter the aid to be donated (name, quantity, etc.).
   - View all aids donated and the NGOs receiving the aids (tabular format).
   - Match aids 1-to-1, 1-to-many, many-to-1, or many-to-many.

2. NGO - An NGO is a non-governmental organization that receives aid from a distribution center (DC). An NGO has a name and a phone. An NGO can perform the following tasks in the system:
   - Register and login an account at a DC.
   - Enter the aid needed (name, quantity, etc.).
   - View all aids received and the donors of the aids (tabular format).
   - Match aids 1-to-1, 1-to-many, many-to-1, or many-to-many.
   - Queue at a DC to collect aid items based on priority and availability.

3. Distribution Center (DC) - A distribution center is a location where aid items are collected and distributed to NGOs. A DC can perform the following tasks in the system:
   - View all aids donated to the DC, the donors of the aids, and the NGOs receiving the aids (tabular format).
   - Match aids 1-to-1, 1-to-many, many-to-1, or many-to-many.
   - Queue NGOs to collect aid items based on priority and availability.

## Installation

To compile and run the project, follow these steps:

1. Navigate to the `/src/` folder.
2. Compile the project with the following command: `javac --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml App.java ./*/*.java`
3. Run the project with the following command: `java --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml App`

## Usage

To use the project, follow these steps:

1. Register and login an account as a donor, NGO, or DC.
2. Enter the aid to be donated or needed.
3. View all aids donated and the NGOs receiving the aids (tabular format).
4. Match aids 1-to-1, 1-to-many, many-to-1, or many-to-many.
5. Queue at a DC to collect aid items based on priority and availability.

## Credits

This project was created by me for the Bachelors of Computer Science Trimester 2, 2021/2022 Object-Oriented Programming and Data Stuctures.
