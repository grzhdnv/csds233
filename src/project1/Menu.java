package project1;

public class Menu {
    public static String mainMenu = """
            
            MAIN MENU
            
            Choose an option:
             1. Edit composition
             2. Navigate
             3. Playback
             0. Exit""";

    public static String edit = """
            
            EDIT
            
            Choose an option:
             1. Add phrase to the end
             2. Add phrase to the beginning
             3. Add phrase to current position
             4. Copy current phrase to the end
             5. Remove current phrase
             6. Remove specific phrase
             7. Rearrange phrases
             0. Return to main menu""";

    public static String navigate = """
            
            NAVIGATE
            
            Choose an option:
             1. Go to the next phrase
             2. Go to the previous phrase
             0. Return to main menu""";

    public static String playback = """
            
            PLAYBACK
            
            Choose an option:
             1. Play from the beginning
             2. Play from the current phrase
             3. Play a specific phrase
             0. Return to main menu""";
}
