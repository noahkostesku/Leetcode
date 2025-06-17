import java.util.*;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        // HashMap to store the counts of each subdomain
        Map<String, Integer> domainCountMap = new HashMap<>();
        
        // Iterate through each count-paired domain
        for (String cpdomain : cpdomains) {
            // Split the input into the count and the domain
            String[] parts = cpdomain.split(" ");
            int count = Integer.parseInt(parts[0]);
            String domain = parts[1];
            
            // Split the domain into subdomains by "."
            String[] subdomains = domain.split("\\.");
            
            // Form subdomains and accumulate their counts
            String currentDomain = "";
            for (int i = subdomains.length - 1; i >= 0; i--) {
                currentDomain = subdomains[i] + (currentDomain.isEmpty() ? "" : "." + currentDomain);
                domainCountMap.put(currentDomain, domainCountMap.getOrDefault(currentDomain, 0) + count);
            }
        }
        
        // Prepare the result list
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : domainCountMap.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        
        return result;
    }
}
