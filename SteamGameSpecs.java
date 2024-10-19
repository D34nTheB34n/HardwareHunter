import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class SteamGameSpecs {
    public static void main(String[] args) {
        try {
            System.out.print("Enter the Steam game URL: ");
            String gameUrl = new Scanner(System.in).nextLine();
            String appId = extractAppId(gameUrl);

            JSONObject data = new JSONObject(sendHttpRequest("https://store.steampowered.com/api/appdetails?appids=" + appId))
                    .getJSONObject(appId).getJSONObject("data");

            String gameName = data.getString("name");
            GameSpecs specs = new GameSpecs(gameName);

            if (data.has("pc_requirements") && data.getJSONObject("pc_requirements").has("minimum")) {
                String minimumSpecs = data.getJSONObject("pc_requirements").getString("minimum");
                parseSpecs(minimumSpecs, specs);
                System.out.println(specs);
            } else {
                System.out.println("PC requirements information not available for " + gameName);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static String extractAppId(String gameUrl) {
        return gameUrl.split("/")[4];
    }

    private static String sendHttpRequest(String apiUrl) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        }
    }

    private static void parseSpecs(String minimumSpecs, GameSpecs specs) {
        // Remove HTML tags and clean up the string
        String cleanedSpecs = minimumSpecs.replaceAll("<[^>]+>", "")
                .replaceAll("&nbsp;", " ")
                .replaceAll("\r", "")
                .replaceAll("\n+", "\n");

        String[] lines = cleanedSpecs.split("\n");
        for (String line : lines) {
            line = line.trim();
            if (line.toLowerCase().contains("os:")) {
                specs.setOs(extractSpec(line, "OS:"));
            }
            if (line.toLowerCase().contains("processor:")) {
                specs.setCpu(extractSpec(line, "Processor:"));
            }
            if (line.toLowerCase().contains("memory:")) {
                specs.setMemory(extractSpec(line, "Memory:"));
            }
            if (line.toLowerCase().contains("graphics:")) {
                specs.setGpu(extractSpec(line, "Graphics:"));
            }
            if (line.toLowerCase().contains("storage:")) {
                specs.setStorage(extractSpec(line, "Storage:"));
            }
        }
    }

    private static String extractSpec(String line, String prefix) {
        int start = line.toLowerCase().indexOf(prefix.toLowerCase());
        if (start != -1) {
            start += prefix.length();
            int end = line.indexOf(":", start);
            if (end == -1) {
                end = line.length();
            }
            return line.substring(start, end).trim();
        }
        return "";
    }
}

class GameSpecs {
    private String name;
    private String os;
    private String cpu;
    private String memory;
    private String gpu;
    private String storage;

    // Constructor
    public GameSpecs(String name) {
        this.name = name;
    }

    // Getters
    public String getName() { return name; }
    public String getOs() { return os; }
    public String getCpu() { return cpu; }
    public String getMemory() { return memory; }
    public String getGpu() { return gpu; }
    public String getStorage() { return storage; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setOs(String os) { this.os = os; }
    public void setCpu(String cpu) { this.cpu = cpu; }
    public void setMemory(String memory) { this.memory = memory; }
    public void setGpu(String gpu) { this.gpu = gpu; }
    public void setStorage(String storage) { this.storage = storage; }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("Recommended PC Specs For: " + (name != null ? name : "Unknown Game") + "\n");
        if (os != null && !os.isEmpty()) output.append("OS: ").append(os).append("\n");
        if (cpu != null && !cpu.isEmpty()) output.append("CPU: ").append(cpu).append("\n");
        if (memory != null && !memory.isEmpty()) output.append("Memory: ").append(memory).append("\n");
        if (gpu != null && !gpu.isEmpty()) output.append("GPU: ").append(gpu).append("\n");
        if (storage != null && !storage.isEmpty()) output.append("Storage: ").append(storage);
        return output.toString().trim();
    }
}
