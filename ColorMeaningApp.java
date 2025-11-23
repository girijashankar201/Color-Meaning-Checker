import java.util.Scanner;

public class ColorMeaningApp {
    
    // ANSI color codes for colorful output
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String BLACK_BG = "\u001B[40m";
    public static final String RED_BG = "\u001B[41m";
    public static final String GREEN_BG = "\u001B[42m";
    public static final String YELLOW_BG = "\u001B[43m";
    public static final String BLUE_BG = "\u001B[44m";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;
        
        System.out.println(CYAN + "🌈 Welcome to the Color Meaning Explorer! 🌈" + RESET);
        System.out.println("Discover the personality traits and meanings behind different colors!\n");
        
        while (continueProgram) {
            displayColorOptions();
            System.out.print("\nEnter a color name: ");
            String colorInput = scanner.nextLine().trim();
            
            String meaning = getColorMeaning(colorInput);
            String quote = getColorQuote(colorInput);
            
            displayColorResult(colorInput, meaning, quote);
            
            // Ask if user wants to continue
            System.out.print("\n" + CYAN + "Would you like to check another color? (yes/no): " + RESET);
            String continueChoice = scanner.nextLine().trim().toLowerCase();
            
            if (!continueChoice.equals("yes") && !continueChoice.equals("y")) {
                continueProgram = false;
                System.out.println(YELLOW + "\nThank you for using the Color Meaning Explorer! Goodbye! 👋" + RESET);
            }
            System.out.println(); // Empty line for better readability
        }
        
        scanner.close();
    }
    
    public static void displayColorOptions() {
        System.out.println("Available colors: " + RED + "Red" + RESET + ", " + 
                         BLUE + "Blue" + RESET + ", " + 
                         GREEN + "Green" + RESET + ", " + 
                         YELLOW + "Yellow" + RESET + ", " + 
                         PURPLE + "Purple" + RESET + ", " + 
                         WHITE + "White" + RESET + ", " + 
                         BLACK_BG + WHITE + "Black" + RESET + ", " + 
                         CYAN + "Orange" + RESET + ", " + 
                         PURPLE + "Pink" + RESET);
    }
    
    public static String getColorMeaning(String color) {
        String colorLower = color.toLowerCase();
        
        switch (colorLower) {
            case "red":
                return "Passion, Energy, Confidence, Courage";
            case "blue":
                return "Calmness, Trust, Intelligence, Stability";
            case "green":
                return "Growth, Balance, Harmony, Renewal";
            case "yellow":
                return "Happiness, Optimism, Creativity, Warmth";
            case "purple":
                return "Royalty, Luxury, Spirituality, Creativity";
            case "orange":
                return "Enthusiasm, Success, Determination, Fun";
            case "pink":
                return "Love, Compassion, Kindness, Gentleness";
            case "white":
                return "Purity, Simplicity, Peace, Innocence";
            case "black":
                return "Power, Mystery, Elegance, Sophistication";
            default:
                return null; // Color not found
        }
    }
    
    public static String getColorQuote(String color) {
        String colorLower = color.toLowerCase();
        
        switch (colorLower) {
            case "red":
                return "Live with passion and energy!";
            case "blue":
                return "Stay calm and trust the journey.";
            case "green":
                return "Grow like nature - steadily and beautifully.";
            case "yellow":
                return "Let your inner sunshine brighten the world.";
            case "purple":
                return "Embrace your unique creative spirit.";
            case "orange":
                return "Approach life with enthusiasm and joy.";
            case "pink":
                return "Spread love and kindness wherever you go.";
            case "white":
                return "Find peace in simplicity.";
            case "black":
                return "There is elegance in mystery and strength.";
            default:
                return "Every color has its own beautiful story.";
        }
    }
    
    public static void displayColorResult(String colorInput, String meaning, String quote) {
        String colorLower = colorInput.toLowerCase();
        String colorDisplay = colorInput.substring(0, 1).toUpperCase() + colorInput.substring(1).toLowerCase();
        
        System.out.println("\n" + "=".repeat(50));
        
        if (meaning == null) {
            System.out.println(RED + "❌ Color not found: \"" + colorInput + "\"" + RESET);
            System.out.println("Please check the spelling or try a different color.");
            return;
        }
        
        // Display color name with appropriate background
        switch (colorLower) {
            case "red":
                System.out.println(RED_BG + WHITE + "🎨 COLOR: " + colorDisplay.toUpperCase() + " 🎨" + RESET);
                break;
            case "blue":
                System.out.println(BLUE_BG + WHITE + "🎨 COLOR: " + colorDisplay.toUpperCase() + " 🎨" + RESET);
                break;
            case "green":
                System.out.println(GREEN_BG + WHITE + "🎨 COLOR: " + colorDisplay.toUpperCase() + " 🎨" + RESET);
                break;
            case "yellow":
                System.out.println(YELLOW_BG + BLACK_BG + "🎨 COLOR: " + colorDisplay.toUpperCase() + " 🎨" + RESET);
                break;
            case "purple":
                System.out.println(PURPLE + "🎨 COLOR: " + colorDisplay.toUpperCase() + " 🎨" + RESET);
                break;
            case "orange":
                System.out.println(YELLOW + "🎨 COLOR: " + colorDisplay.toUpperCase() + " 🎨" + RESET);
                break;
            case "pink":
                System.out.println(PURPLE + "🎨 COLOR: " + colorDisplay.toUpperCase() + " 🎨" + RESET);
                break;
            case "white":
                System.out.println(WHITE + BLACK_BG + "🎨 COLOR: " + colorDisplay.toUpperCase() + " 🎨" + RESET);
                break;
            case "black":
                System.out.println(BLACK_BG + WHITE + "🎨 COLOR: " + colorDisplay.toUpperCase() + " 🎨" + RESET);
                break;
            default:
                System.out.println(CYAN + "🎨 COLOR: " + colorDisplay.toUpperCase() + " 🎨" + RESET);
        }
        
        // Display meaning with appropriate color
        String meaningColor = getTextColor(colorLower);
        System.out.println(meaningColor + "✨ MEANING: " + meaning + RESET);
        
        // Display quote
        System.out.println(YELLOW + "💬 QUOTE: \"" + quote + "\"" + RESET);
        
        // Display personality traits
        displayPersonalityTraits(colorLower);
        
        System.out.println("=".repeat(50));
    }
    
    public static String getTextColor(String color) {
        switch (color) {
            case "red": return RED;
            case "blue": return BLUE;
            case "green": return GREEN;
            case "yellow": return YELLOW;
            case "purple": return PURPLE;
            case "orange": return YELLOW;
            case "pink": return PURPLE;
            case "white": return WHITE;
            case "black": return WHITE;
            default: return CYAN;
        }
    }
    
    public static void displayPersonalityTraits(String color) {
        String traitsColor = getTextColor(color);
        System.out.print(traitsColor + "🌟 PERSONALITY: " + RESET);
        
        switch (color) {
            case "red":
                System.out.println("Ambitious, Energetic, Confident, Passionate");
                break;
            case "blue":
                System.out.println("Calm, Trustworthy, Intelligent, Loyal");
                break;
            case "green":
                System.out.println("Balanced, Harmonious, Growth-oriented, Natural");
                break;
            case "yellow":
                System.out.println("Optimistic, Creative, Cheerful, Warm-hearted");
                break;
            case "purple":
                System.out.println("Creative, Spiritual, Luxurious, Imaginative");
                break;
            case "orange":
                System.out.println("Enthusiastic, Successful, Determined, Fun-loving");
                break;
            case "pink":
                System.out.println("Loving, Compassionate, Kind, Gentle");
                break;
            case "white":
                System.out.println("Pure, Simple, Peaceful, Innocent");
                break;
            case "black":
                System.out.println("Powerful, Mysterious, Elegant, Sophisticated");
                break;
            default:
                System.out.println("Unique and special in your own way!");
        }
    }
}