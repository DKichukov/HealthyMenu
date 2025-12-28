package app.healthymenu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for handling food data persistence operations.
 * Manages save and load operations for food items from/to file storage.
 */
public class FoodService {

  private static final String FILE_PATH = "food.txt";

  /**
   * Saves a list of food items to file storage.
   *
   * @param foodList the list of Food objects to persist
   * @throws RuntimeException if the file cannot be written
   */
  public void saveFood(List<Food> foodList) {
    try (PrintWriter pw = new PrintWriter(FILE_PATH)) {
      foodList.forEach(food -> pw.println(food.toString()));
    } catch (FileNotFoundException exception) {
      throw new RuntimeException("Failed to save food data to " + FILE_PATH, exception);
    }
  }

  /**
   * Loads food items from file storage.
   *
   * @return a list of Food objects loaded from file
   * @throws RuntimeException if the file cannot be read or data is invalid
   */
  public List<Food> loadFood() {
    try {
      return Files.readAllLines(Paths.get(FILE_PATH))
          .stream()
          .filter(line -> !line.trim().isEmpty())
          .map(this::parseFoodLine)
          .collect(Collectors.toList());
    } catch (IOException e) {
      throw new RuntimeException("Failed to load food data from " + FILE_PATH, e);
    }
  }

  /**
   * Parses a single line from the food file into a Food object.
   *
   * @param line the line to parse in format "name; category; weight"
   * @return a Food object created from the parsed line
   * @throws IllegalArgumentException if the line format is invalid
   */
  private Food parseFoodLine(String line) {
    String[] parts = line.split("; ");
    if (parts.length != 3) {
      throw new IllegalArgumentException("Invalid food line format: " + line);
    }

    String name = parts[0].trim();
    String category = parts[1].trim();
    int weight = Integer.parseInt(parts[2].trim());

    return new Food(name, category, weight);
  }
}

