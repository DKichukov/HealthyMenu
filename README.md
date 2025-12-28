# Healthy Menu

A simple JavaFX application to manage and track your food intake by category and weight.

## Features

- ✅ Add food items with name, category, and weight (in grams)
- ✅ View food items in a table with automatic weight conversion to ounces
- ✅ Categorize foods into: Milk and derivatives, Meat and fish, Fruits and vegetables, Other
- ✅ Persistent data storage - automatically saves and loads your food list

## Prerequisites

- Java 17 or higher
- Maven 3.6+

## Project Structure

```
src/
├── main/
│   ├── java/app/healthymenu/
│   │   ├── Food.java              # Food data model
│   │   ├── FoodService.java       # Service for save/load operations
│   │   ├── MainController.java    # UI controller
│   │   ├── HealthyMenu.java       # Main application class
│   │   └── Launcher.java          # Application launcher
│   └── resources/app/healthymenu/
│       └── main.fxml              # UI layout
food.txt                           # Data storage file
pom.xml                            # Maven configuration
```

## Getting Started

### 1. Clone or Download the Project
```bash
cd healthyMenu
```

### 2. Build the Project
```bash
mvn clean install
```

### 3. Run the Application
```bash
mvn javafx:run
```

Or run it directly:
```bash
java -jar target/healthyMenu.jar
```

## Usage

1. **Add Food:**
   - Enter food name in the "Food Name" field
   - Select a category from the dropdown
   - Enter weight in grams
   - Click "Add" button

2. **View Food List:**
   - All added foods appear in the table
   - Weight is automatically displayed in both grams and ounces

3. **Delete Food:**
   - **Double-click** on any food item in the table to remove it
   - The item will be instantly deleted and the file will be updated

4. **Data Persistence:**
   - Your food list is automatically saved to `food.txt`
   - On application restart, your previous entries are loaded

## Sample Food Data

The application comes with sample data in `food.txt`:
- Potatoes (200g)
- Chicken (300g)
- Milkshake (250ml)
- Salmon (300g)
- Bananas (150g)

## Technologies Used

- **JavaFX** - User interface framework
- **Java 17+** - Programming language
- **Maven** - Build automation tool

## File Format

Food data is stored in `food.txt` with the format:
```
Name; Category; Weight
```

Example:
```
Potatoes; Fruits and vegetables; 200
Chicken; Meat and fish; 300
```

## Notes

- All weights are stored in grams
- Ounces conversion: 1 gram = 0.035274 ounces
- Empty lines in the data file are automatically skipped
- Application validates that no fields are empty before adding food

## Future Enhancements

- Delete/Edit functionality for food items
- Calorie tracking and nutritional information
- Search and filter capabilities
- Export data to CSV or PDF

## License

This project is open source and available for personal use.

