package se.lexicon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The NameRepository class provides methods to manage a list of names.
 * It offers functionalities such as adding, removing, finding, and updating names.
 */
public class NameRepository {

    private static String[] names = new String[0]; // element format should be ["firstName lastName", "firstName lastName"]


    /**
     * Retrieves the current size of the names array.
     *
     * @return The number of elements in the names array.
     */
    public static int getSize() {
        return names.length;
    }


    /**
     * Sets the names array to the provided array of names & it should replace all existing names.
     *
     * @param names The array of names to set.
     */
    public static void setNames(final String[] names) {
        if (names == null) {
            NameRepository.names = new String[0];
        } else {
            NameRepository.names = names.clone();
        }
    }


    /**
     * Clears the names array by creating a new empty array.
     */
    public static void clear() {
        NameRepository.names = new String[0];
    }


    /**
     * Returns all names in a new array (Retrieves a copy of the names array).
     *
     * @return A new array containing all elements from the names array.
     */
    public static String[] findAll() {
        return NameRepository.names.clone();
    }


    /**
     * Finds a name that matches the given fullName case-insensitively.
     *
     * @param fullName The full name to search for.
     * @return The matching name if found; otherwise, null.
     */
    public static String find(final String fullName) {
        for (String name : names) {
            if(name.equalsIgnoreCase(fullName)){
                return name;
            }
        }
        return null;
    }


    /**
     * Adds a new fullName to the names array if it doesn't already exist.
     *
     * @param fullName The full name to add.
     * @return True if the fullName is added successfully; false if it already exists.
     */
    public static boolean add(final String fullName) {
        boolean present = find(fullName) != null;
        if (present){
            return false;
        } else {
            String[] newNames = Arrays.copyOf(names,names.length+1);
            newNames[newNames.length - 1] = fullName;

            names = newNames;
            return true;
        }
    }


    /**
     * Find all names that match the given firstName.
     *
     * @param firstName The first name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByFirstName(final String firstName) {
        List<String> foundNames = new ArrayList<>();
        for(String name : names) {
            if (name.split(" ")[0].equals(firstName)) {
                foundNames.add(name);
            }
        }
        return foundNames.toArray(new String[0]);
    }


    /**
     * Find all names that match the given lastName.
     *
     * @param lastName The last name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByLastName(final String lastName) {
        List<String> foundNames = new ArrayList<>();
        for(String name : names) {
            if (name.split(" ")[1].equals(lastName)) {
                foundNames.add(name);
            }
        }
        return foundNames.toArray(new String[0]);
    }


    /**
     * Updates a name in the names array from the original name to the updated name.
     *
     * @param original    The original name to update.
     * @param updatedName The updated name to set.
     * @return True if the name is updated successfully; false if the updated name already exists or the original name is not found.
     */
    public static boolean update(final String original, final String updatedName) {
        if (find(updatedName) == updatedName || find(original) == null) {
            return false;
        } else {
            //find index of original name and update
            for (int i = 0; i < names.length; i++) {
                if (names[i].equals(original)) {
                    names[i] = updatedName;
                }
            }
            return true;
        }
    }


    /**
     * Removes a name from the names array, case-insensitively.
     *
     * @param fullName The full name to remove.
     * @return True if the name is removed successfully; false if the name is not found in the array.
     */
    public static boolean remove(final String fullName) {
        if (find(fullName) == null){
            return false;
        } else {
            String[] newNames = new String[names.length - 1];
            int index = 0;
            for (String name : names) {
                if (!name.equals(fullName)) {
                    newNames[index] = name;
                    index++;
                }
            }
            names = newNames;
            return true;
        }
    }
}